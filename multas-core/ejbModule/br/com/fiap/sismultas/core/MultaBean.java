package br.com.fiap.sismultas.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import br.com.fiap.sismultas.domain.CobrancaReceber;
import br.com.fiap.sismultas.domain.Infracao;
import br.com.fiap.sismultas.domain.ItemCtb;
import br.com.fiap.sismultas.domain.ItemCtbPK;
import br.com.fiap.sismultas.domain.Notificacao;
import br.com.fiap.sismultas.domain.Pessoa;
import br.com.fiap.sismultas.domain.StatusInfracao;
import br.com.fiap.sismultas.domain.StatusNotificacao;
import br.com.fiap.sismultas.domain.Veiculo;
import br.com.fiap.sismultas.enumeration.PerfilPessoaEnum;
import br.com.fiap.sismultas.enumeration.StatusInfracaoEnum;
import br.com.fiap.sismultas.enumeration.StatusNotificacaoEnum;
import br.com.fiap.sismultas.ws.vo.InfracaoVO;
import br.com.fiap.sismultas.ws.vo.MultaVO;
import br.com.fiap.sismultas.ws.vo.StatusInfracaoVO;

/**
 * Session Bean que representa uma multa
 */
@Stateless
public class MultaBean implements Multa {

	private static final Logger LOGGER = Logger.getLogger(Multa.class);
	
	@Override
	public StatusInfracaoVO valida(MultaVO dadosMulta) {

		LOGGER.info("Iniciando validacao dos dados da infracao...");
		
		//Objeto de retorno
		StatusInfracaoVO status = new StatusInfracaoVO(Boolean.TRUE);
		
		//-----------------------------------------------------------------------------------------//
		//------ Verifica fiscal que enviou a multa -----------------------------------------------//
		//-----------------------------------------------------------------------------------------//
		Pessoa fiscal = Pessoa.buscaPorId(dadosMulta.getIdFiscal().longValue());
		
		if (fiscal == null || 
				!PerfilPessoaEnum.contemPerfil(PerfilPessoaEnum.FISCAL, fiscal.getPerfils())) {
			status.setValido(Boolean.FALSE);
			status.adicionaMensagem(StatusInfracaoEnum.FISCAL_NAO_ENCONTRADO);
		}
		
		LOGGER.info("Validacao de pessoa = " + status.isValido());
		
		//-----------------------------------------------------------------------------------------//
		//------ Verifica veículo -----------------------------------------------------------------//
		//-----------------------------------------------------------------------------------------//
		Veiculo veiculo = Veiculo.buscaPorPlaca(dadosMulta.getPlacaVeiculo());
		
		if (veiculo == null) {
			status.setValido(Boolean.FALSE);
			status.adicionaMensagem(StatusInfracaoEnum.VEICULO_NAO_ENCONTRADO);
		}
		
		LOGGER.info("Validacao de veiculo = " + status.isValido());
		
		//-----------------------------------------------------------------------------------------//
		//------ Verifica o código da infração e o desdobramento. ---------------------------------//
		//-----------------------------------------------------------------------------------------//
		ItemCtbPK itemCtbPrimaryKey =
				new ItemCtbPK(dadosMulta.getCodigoInfracaoCtb(), dadosMulta.getDesdobramentoCtb().intValue());
		
		ItemCtb itemCtb = ItemCtb.buscaPorId(itemCtbPrimaryKey);

		if (itemCtb == null) {
			status.setValido(Boolean.FALSE);
			status.adicionaMensagem(StatusInfracaoEnum.ITEM_CTB_NAO_ENCONTRADO);
		}
		
		LOGGER.info("Validacao de item CTB = " + status.isValido());
		
		//-----------------------------------------------------------------------------------------//
		//--- Caso todas as validações tenham sido bem sucedidas, adiciona mensagem ---------------//
		//--- de OK ao objeto de retorno ----------------------------------------------------------//
		//-----------------------------------------------------------------------------------------//
		if (status.isValido()) {
			status.adicionaMensagem(StatusInfracaoEnum.PROCESSAMENTO_OK);
		}
		
		LOGGER.info("Validacao finalizada. Status = " + status.isValido());
		
		return status;
		
	}

	@Override
	public Infracao persiste(MultaVO dadosMulta, StatusInfracaoVO status) {
		
		LOGGER.info("Iniciando persistencia dos dados da infracao");
		
		//-----------------------------------------------------------------------------------------//
		//------ Cria entidades com status da infração --------------------------------------------//
		//-----------------------------------------------------------------------------------------//
		List<StatusInfracao> statusInfracaoList = new ArrayList<StatusInfracao>();
		
		for (StatusInfracaoEnum mensagem : status.getMensagens()) {
			
			StatusInfracao statusInfracao = new StatusInfracao();
			statusInfracao.setCodigo(mensagem.getCodigo().longValue());
			statusInfracao.setMensagem(mensagem.getMensagem());
			
			LOGGER.info("Adicionando mensagem de status = " + mensagem.getMensagem());
			
			statusInfracaoList.add(statusInfracao);
			
		}
		
		LOGGER.info("Criada lista de mensagens de status");
		
		//-----------------------------------------------------------------------------------------//
		//------ Busca dependências da infração ---------------------------------------------------//
		//-----------------------------------------------------------------------------------------//
		
		LOGGER.info("Buscando dependencias...");
		
		//fiscal
		Pessoa fiscal = Pessoa.buscaPorId(dadosMulta.getIdFiscal().longValue());
		
		//veículo
		Veiculo veiculo = Veiculo.buscaPorPlaca(dadosMulta.getPlacaVeiculo());
		
		//Infracao de acordo com o CTB
		ItemCtbPK itemCtbPrimaryKey =
				new ItemCtbPK(dadosMulta.getCodigoInfracaoCtb(), dadosMulta.getDesdobramentoCtb().intValue());
		ItemCtb itemCtb = ItemCtb.buscaPorId(itemCtbPrimaryKey);
		
		//-----------------------------------------------------------------------------------------//
		//------ Cria entidade e persiste os dados da infração ------------------------------------//
		//-----------------------------------------------------------------------------------------//
		Infracao infracao = new Infracao();
		
		infracao.setCepLocalOcorrencia(dadosMulta.getCepLocalOcorrencia());
		infracao.setDataOcorrencia(dadosMulta.getDataOcorrencia());
		infracao.setPessoa(fiscal);
		infracao.setVeiculo(veiculo);
		infracao.setItemCtb(itemCtb);
		infracao.setStatusInfracao(statusInfracaoList);
		
		//registra data do processamento como a data atual do sistema
		infracao.setDataProcessamento(new Date());
		
		//persiste dados da infracao no banco de dados.
		infracao.persist();
		
		LOGGER.info("Criada infracao = " + infracao);
		
		return infracao;
		
	}

	@Override
	public Notificacao emiteNotificacao(Long idInfracao) {
		
		LOGGER.info("Iniciando processo de emissão de notificação para a infracao Id = " + idInfracao);
		
		//-----------------------------------------------------------------------------------------//
		//------ Busca a infracao correspondente ao Id enviado ------------------------------------//
		//-----------------------------------------------------------------------------------------//
		Infracao infracao = Infracao.find(idInfracao);

		if (infracao == null) {
			
			LOGGER.info("Infracao id = " + idInfracao + " não foi encontrada na base de dados.");
			LOGGER.info("Não foi possível emitir a notificacao.");
			
			return null;
			
		}
		
		LOGGER.info("Gerando notificacao...");
		
		//-----------------------------------------------------------------------------------------//
		//------ Gera os dados da notificao e persiste na base de dados ---------------------------//
		//-----------------------------------------------------------------------------------------//
		Notificacao notificacao = new Notificacao();
		
		//relaciona com a infracao
		notificacao.setInfracao(infracao);
		//configura com a data corrente
		notificacao.setDataEmissao(new Date());
		
		//configura com status emitida.
		StatusNotificacao statusNotificacao =
				StatusNotificacao.buscaPorDescricao(StatusNotificacaoEnum.EMITIDA.getDescricao());
		
		notificacao.setStatus(statusNotificacao);
		
		//persiste na base de dados
		notificacao.persist();
		
		LOGGER.info("Notificacao gerada com sucesso. Id = " + notificacao.getId());
		
		return notificacao;
		
	}

	@Override
	public void geraCobranca(Notificacao notificacao) {
		
		LOGGER.info("Gerando cobranca para a notificacao Id = " + notificacao.getId());
		
		//-----------------------------------------------------------------------------------------//
		//------ Recupera o valor da multa de acord com o ItemCTB ---------------------------------//
		//-----------------------------------------------------------------------------------------//
		Double valorCobranca = notificacao.getInfracao().getItemCtb().getValorMulta();
		
		LOGGER.info("Valor da cobranca = " + valorCobranca);
		
		//-----------------------------------------------------------------------------------------//
		//------ Gera os dados da cobranca e persiste na base de dados ----------------------------//
		//-----------------------------------------------------------------------------------------//
		CobrancaReceber cobrancaReceber = new CobrancaReceber();
		
		//relaciona com a notificacao
		cobrancaReceber.setNotificacao(notificacao);
		//valor da cobranca
		cobrancaReceber.setValor(valorCobranca);
		//data da criacao da cobranca = data corrente
		cobrancaReceber.setDataCriacao(new Date());
		
		//persiste na base de dados
		cobrancaReceber.persist();
		
		LOGGER.info("Cobranca gerada com sucesso. Id = " + cobrancaReceber.getId());
				
	}

	@Override
	public void atualizaStatusNotificacao(Long idNotificacao, StatusNotificacaoEnum statusNotificacao) {
		
		LOGGER.info("Atualizando status da notificacao Id = " + idNotificacao);
		
		//-----------------------------------------------------------------------------------------//
		//------ Busca a notificacao correspondente ao Id enviado ---------------------------------//
		//-----------------------------------------------------------------------------------------//
		Notificacao notificacao = Notificacao.find(idNotificacao);
		
		//-----------------------------------------------------------------------------------------//
		//------ Atribui o status enviado e atualiza na base de dados -----------------------------//
		//-----------------------------------------------------------------------------------------//
		StatusNotificacao statusEntity = StatusNotificacao.buscaPorDescricao(statusNotificacao.getDescricao());
		notificacao.setStatus(statusEntity);
		
		//persiste
		notificacao.update();
		
	}

	@Override
	public List<InfracaoVO> getMultas(MultaVO filtro) {

		try {
			
			//-----------------------------------------------------------------------------------------//
			//------ Faz a pesquisa de acordo com o filtro passado como parâmetro ---------------------//
			//-----------------------------------------------------------------------------------------//
			List<Infracao> infracoes = Infracao.getByFilter(filtro);
			
			//-----------------------------------------------------------------------------------------//
			//------ Cria lista de objetos de retorno -------------------------------------------------//
			//-----------------------------------------------------------------------------------------//
			List<InfracaoVO> infracoesVO = new ArrayList<InfracaoVO>();
			
			if (infracoes != null && !infracoes.isEmpty()) {
				for (Infracao infracao : infracoes) {
					InfracaoVO infracaoVO = new InfracaoVO(infracao);
					infracoesVO.add(infracaoVO);
				}
			}
			
			//-----------------------------------------------------------------------------------------//
			//------ Retorna lista de VOs -------------------------------------------------------------//
			//-----------------------------------------------------------------------------------------//
			return infracoesVO;
			
		} catch (Exception ex) {
			return null;
		}
		
	}

}

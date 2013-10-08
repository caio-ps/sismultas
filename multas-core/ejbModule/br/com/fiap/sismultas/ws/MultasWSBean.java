package br.com.fiap.sismultas.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import br.com.fiap.sismultas.core.CodigoTransitoBrasileiro;
import br.com.fiap.sismultas.core.Multa;
import br.com.fiap.sismultas.core.Relatorio;
import br.com.fiap.sismultas.domain.Infracao;
import br.com.fiap.sismultas.domain.InfracaoGravidade;
import br.com.fiap.sismultas.domain.Notificacao;
import br.com.fiap.sismultas.domain.Pessoa;
import br.com.fiap.sismultas.enumeration.StatusNotificacaoEnum;
import br.com.fiap.sismultas.enumeration.TipoRelatorioEnum;
import br.com.fiap.sismultas.ws.vo.GravidadeInfracaoVO;
import br.com.fiap.sismultas.ws.vo.IdOperacaoVO;
import br.com.fiap.sismultas.ws.vo.InfracaoVO;
import br.com.fiap.sismultas.ws.vo.ItemCTBVO;
import br.com.fiap.sismultas.ws.vo.MultaVO;
import br.com.fiap.sismultas.ws.vo.RelatorioVO;
import br.com.fiap.sismultas.ws.vo.StatusInfracaoVO;

/**
 * Session Bean que hospeda os serviços relativos ao processamento das multas.
 * 
 * @author caio-pereira
 *
 */
@Stateless
@WebService(serviceName="SisMultasWS")
public class MultasWSBean implements MultasWS {

	private static final Logger LOGGER = Logger.getLogger(MultasWS.class);
	
	@EJB
	Multa multa;
	@EJB
	Relatorio relatorio;
	@EJB
	CodigoTransitoBrasileiro codigoTransitoBrasileiro;
	
	@Override
	public IdOperacaoVO processaDadosMulta(@WebParam(name="dadosMulta") MultaVO dadosMultaVO) throws Exception {

		try {
			
			LOGGER.info("Recebida infracao: " + dadosMultaVO);
			
			//-----------------------------------------------------------------------------------------//
			//------ Valida os dados recebidos --------------------------------------------------------//
			//-----------------------------------------------------------------------------------------//
			LOGGER.info("Validando dados da infracao...");
			StatusInfracaoVO statusProcessamento = this.multa.valida(dadosMultaVO);
			
			//-----------------------------------------------------------------------------------------//
			//------ Persiste os dados da infração ----------------------------------------------------//
			//-----------------------------------------------------------------------------------------//
			LOGGER.info("Persistindo infracao na base de dados");
			Infracao infracao = this.multa.persiste(dadosMultaVO, statusProcessamento);
			
			//Retorna ID da infracao.
			LOGGER.info("Criada infracao. Id = " + infracao.getId());
			return new IdOperacaoVO(infracao.getId());
			
		} catch (Exception ex) {
			
			LOGGER.error("Ocorreu um erro no processamento da infracao", ex);
			throw ex;
			
		}
		
	}

	@Override
	public IdOperacaoVO emiteNotificacao(@WebParam(name="idInfracao") IdOperacaoVO idInfracao) throws Exception {
		
		try {
			
			LOGGER.info("Recebido pedido para emitir notificacao. Infracao id: " + idInfracao);
			
			//-----------------------------------------------------------------------------------------//
			//------ Emite uma nova notificacao de infracao -------------------------------------------//
			//-----------------------------------------------------------------------------------------//
			LOGGER.info("Emitindo notificacao...");
			
			Notificacao notificacao = this.multa.emiteNotificacao(idInfracao.getIdOperacao());
			
			//-----------------------------------------------------------------------------------------//
			//------ Emite uma nova cobranca para a notificacao ---------------------------------------//
			//-----------------------------------------------------------------------------------------//
			LOGGER.info("Emitindo cobranca para a notificacao...");
			
			this.multa.geraCobranca(notificacao);
			
			LOGGER.info("Notificacao gerada com sucesso. Id = " + notificacao.getId());
			
			return new IdOperacaoVO(notificacao.getId());
			
		} catch (Exception ex) {
			
			LOGGER.error("Ocorreu um erro na emissao da notificacao", ex);
			throw ex;
			
		}
		
	}

	@Override
	public RelatorioVO geraArquivoNotificacao(@WebParam(name="idNotificacao") IdOperacaoVO idNotificacao)
			throws Exception {
		
		try {
		
			LOGGER.info("Recebido pedido para gerar arquivo de notificacao. Id = " + idNotificacao.getIdOperacao());
			
			//-----------------------------------------------------------------------------------------//
			//------ Parametros necessarios para geracao do relatorio ---------------------------------//
			//-----------------------------------------------------------------------------------------//
			Map<String, Object> parametrosRelatorio = new HashMap<String, Object>();
			
			//id da notificacao
			parametrosRelatorio.put("idNotificacao", idNotificacao.getIdOperacao());
			
			//-----------------------------------------------------------------------------------------//
			//------ Gera relatorio -------------------------------------------------------------------//
			//-----------------------------------------------------------------------------------------//
			RelatorioVO relatorio = this.relatorio.geraRelatorio(TipoRelatorioEnum.NOTIFICACAO, parametrosRelatorio);
			
			return relatorio;
		
		} catch (Exception ex) {
			
			LOGGER.error("Ocorreu um erro na geracao do relatorio de notificacao", ex);
			throw ex;
			
		} 
		
	}

	@Override
	public void enviaEmailNotificacao(@WebParam(name="relatorio") RelatorioVO relatorioVO) throws Exception {
		
		try {
			
			LOGGER.info("Recebido pedido para enviar por e-mail arquivo de notificacao: " + relatorioVO.getCaminhoArquivo());
			
			//-----------------------------------------------------------------------------------------//
			//------ Envio do relatório ---------------------------------------------------------------//
			//-----------------------------------------------------------------------------------------//
			Boolean statusEnvio = this.relatorio.enviaPorEmail(relatorioVO);
			
			//-----------------------------------------------------------------------------------------//
			//------ Atualiza status da notificacao ---------------------------------------------------//
			//-----------------------------------------------------------------------------------------//
			StatusNotificacaoEnum statusNotificacao = 
					statusEnvio ? 
							StatusNotificacaoEnum.ENVIADA_POR_EMAIL :
							StatusNotificacaoEnum.ERRO_ENVIO;
			
			this.multa.atualizaStatusNotificacao(relatorioVO.getId(), statusNotificacao);
		
		} catch (Exception ex) {
			
			LOGGER.error("Ocorreu um erro na geracao do relatorio de notificacao", ex);
			throw ex;
			
		} 
		
	}

	@Override
	public List<GravidadeInfracaoVO> getGravidades() throws Exception {
		
		try {

			LOGGER.info("Recebida solicitação de consulta de gravidades de infrações.");

			// -----------------------------------------------------------------------------------------//
			// ------ Consulta gravidades --------------------------------------------------------------//
			// -----------------------------------------------------------------------------------------//
			List<InfracaoGravidade> gravidades = InfracaoGravidade.buscaTodos();
			
			// -----------------------------------------------------------------------------------------//
			// ------ Converte objeto de retorno -------------------------------------------------------//
			// -----------------------------------------------------------------------------------------//
			List<GravidadeInfracaoVO> gravidadesVO = new ArrayList<GravidadeInfracaoVO>();
			
			for (InfracaoGravidade gravidade : gravidades) {
				
				GravidadeInfracaoVO gravidadeInfracaoVO = new GravidadeInfracaoVO(gravidade);
				gravidadesVO.add(gravidadeInfracaoVO);
				
			}
			
			return gravidadesVO;
			
		} catch (Exception ex) {
			LOGGER.error("Ocorreu um erro no serviço de consulta de gravidades de infração.", ex);
			throw ex;
		}
		
	}

	@Override
	public ItemCTBVO cadastraItemCTB(ItemCTBVO itemCTBVO) throws Exception {
		
		try {

			LOGGER.info("Recebida solicitação de cadastro de item ctb. cod = " + itemCTBVO.getCodigoInfracao());

			// -----------------------------------------------------------------------------------------//
			// ------ Cadastra item ctb ----------------------------------------------------------------//
			// -----------------------------------------------------------------------------------------//
			ItemCTBVO ItemCTBCadastrado = this.codigoTransitoBrasileiro.cadastraItemCTB(itemCTBVO);
			
			return ItemCTBCadastrado;
			
		} catch (Exception ex) {
			LOGGER.error("Ocorreu um erro no serviço de cadastro de item ctb.", ex);
			throw ex;
		}	
		
	}

	@Override
	public List<InfracaoVO> getMultas(MultaVO filtro) throws Exception {
	
		try {

			LOGGER.info("Recebida solicitação de consulta de multas.");

			// -----------------------------------------------------------------------------------------//
			// ----- Consulta multas de acordo com filtro ----------------------------------------------//
			// -----------------------------------------------------------------------------------------//
			return this.multa.getMultas(filtro);
						
		} catch (Exception ex) {
			LOGGER.error("Ocorreu um erro no serviço de consulta de multas por filtro.", ex);
			throw ex;
		}
		
	}

	@Override
	public RelatorioVO geraRelatorioMultas(MultaVO filtro) throws Exception {
		
		try {
			
			LOGGER.info("Recebido pedido para gerar relatorio de multas.");
			//Objeto de retorno
			RelatorioVO relatorio = null;
			
			//-----------------------------------------------------------------------------------------//
			//------ Parametros necessarios para geracao do relatorio ---------------------------------//
			//-----------------------------------------------------------------------------------------//
			Map<String, Object> parametrosRelatorio = new HashMap<String, Object>();
			
			//-----------------------------------------------------------------------------------------//
			//------ Busca lista de infracoes pelo filtro ---------------------------------------------//
			//-----------------------------------------------------------------------------------------//
			List<Infracao> listaInfracao = Infracao.getByFilter(filtro);
			
			//lista de infracoes
			parametrosRelatorio.put("listaInfracao", listaInfracao);
			
			//-----------------------------------------------------------------------------------------//
			//------ Gera relatorio de acordo com o filtro enviado como parâmetro ---------------------//
			//-----------------------------------------------------------------------------------------//
			if (filtro.getIdFiscal() != null) {
				Pessoa pessoa = Pessoa.buscaPorId(filtro.getIdFiscal().longValue());
				parametrosRelatorio.put("valor", pessoa.getNome() + " " + pessoa.getSobrenome());
				relatorio = this.relatorio.geraRelatorio(TipoRelatorioEnum.RELATORIO_FISCAL, parametrosRelatorio);
			} else {
				parametrosRelatorio.put("valor", filtro.getPlacaVeiculo());
				relatorio = this.relatorio.geraRelatorio(TipoRelatorioEnum.RELATORIO_VEICULO, parametrosRelatorio);
			}
			
			return relatorio;
		
		} catch (Exception ex) {
			
			LOGGER.error("Ocorreu um erro na geracao do relatorio de notificacao", ex);
			throw ex;
			
		}
		
	}
		
}

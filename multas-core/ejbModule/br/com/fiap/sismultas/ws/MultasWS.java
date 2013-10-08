package br.com.fiap.sismultas.ws;

import java.util.List;

import javax.ejb.Remote;

import br.com.fiap.sismultas.ws.vo.GravidadeInfracaoVO;
import br.com.fiap.sismultas.ws.vo.IdOperacaoVO;
import br.com.fiap.sismultas.ws.vo.InfracaoVO;
import br.com.fiap.sismultas.ws.vo.ItemCTBVO;
import br.com.fiap.sismultas.ws.vo.MultaVO;
import br.com.fiap.sismultas.ws.vo.RelatorioVO;

@Remote
public interface MultasWS {

	/**
	 * Processa os dados de uma multa enviada para o sistema.
	 * 
	 * @param dadosMultaVO
	 * @return
	 * @throws Exception
	 */
	IdOperacaoVO processaDadosMulta(MultaVO multaVO) throws Exception;
	
	/**
	 * Emite uma notificacao para uma infracao
	 * 
	 * @param idInfracao
	 * @return
	 * @throws Exception
	 */
	IdOperacaoVO emiteNotificacao(IdOperacaoVO idInfracao) throws Exception;
	
	/**
	 * Gera o arquivo pdf de notificacao da multa.
	 * 
	 * @param idNotificacao
	 * @return
	 * @throws Exception
	 */
	RelatorioVO geraArquivoNotificacao(IdOperacaoVO idNotificacao) throws Exception;

	/**
	 * Envia um relatorio de notificacao por e-mail
	 * 
	 * @param relatorioVO
	 * @throws Exception
	 */
	void enviaEmailNotificacao(RelatorioVO relatorioVO) throws Exception;

	/**
	 * 
	 * Consulta as gravidades possíveis de uma infração
	 * 
	 * @return
	 * @throws Exception
	 */
	List<GravidadeInfracaoVO> getGravidades() throws Exception;
	
	/**
	 * Cadastra novo item do código brasileiro
	 * 
	 * @param itemCTBVO
	 * @return
	 * @throws Exception
	 */
	ItemCTBVO cadastraItemCTB(ItemCTBVO itemCTBVO) throws Exception;
	
	/**
	 * Consulta multas com filtro
	 * 
	 * @param filtro
	 * @return
	 */
	List<InfracaoVO> getMultas(MultaVO filtro) throws Exception;
	
	/**
	 * Gera relatorio de multas
	 * 
	 * @param filtro
	 * @return
	 */
	RelatorioVO geraRelatorioMultas(MultaVO filtro) throws Exception;
	
}

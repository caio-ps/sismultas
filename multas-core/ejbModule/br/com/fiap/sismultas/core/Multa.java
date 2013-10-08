package br.com.fiap.sismultas.core;

import java.util.List;

import javax.ejb.Local;

import br.com.fiap.sismultas.domain.Infracao;
import br.com.fiap.sismultas.domain.Notificacao;
import br.com.fiap.sismultas.enumeration.StatusNotificacaoEnum;
import br.com.fiap.sismultas.ws.vo.InfracaoVO;
import br.com.fiap.sismultas.ws.vo.MultaVO;
import br.com.fiap.sismultas.ws.vo.StatusInfracaoVO;

@Local
public interface Multa {
	
	/**
	 * Método que valida os dados de uma infração recebida pelo serviço de
	 * processamento de multas
	 * 
	 * @param dadosMulta
	 * @return
	 */
	StatusInfracaoVO valida(MultaVO dadosMulta);
	
	/**
	 * Método que persiste todos os dados de uma infração
	 * (não inclui notificação e cobranças)
	 * 
	 * @param dadosMulta
	 * @param status
	 */
	Infracao persiste(MultaVO dadosMulta, StatusInfracaoVO status);
	
	/**
	 * Emite uma notificacao
	 * 
	 * @param idInfracao
	 * @return
	 */
	Notificacao emiteNotificacao(Long idInfracao);
	
	/**
	 * Atualiza o status de uma notificacao
	 * 
	 * @param idNotificacao
	 * @param statusNotificacao
	 */
	void atualizaStatusNotificacao(Long idNotificacao, StatusNotificacaoEnum statusNotificacao);
	
	/**
	 * Gera uma cobrança a partir de uma notificacao
	 * 
	 * @param notificacao
	 */
	void geraCobranca(Notificacao notificacao);
	
	/**
	 * Consulta multas com filtro
	 * 
	 * @param filtro
	 * @return
	 */
	List<InfracaoVO> getMultas(MultaVO filtro);

}

package br.com.fiap.sismultas.ws.vo;

import java.math.BigDecimal;

import br.com.fiap.sismultas.domain.Infracao;

/**
 * Value Object:
 * Encapsula os dados de uma infracao emitida.
 * 
 * @author caio-pereira
 *
 */
public class InfracaoVO extends MultaVO {

	private VeiculoVO veiculo;
	private String status;
	private NotificacaoVO notificacaoVO;
	
	public InfracaoVO(Infracao infracao) {
		super(
			infracao.getVeiculo() != null ? infracao.getVeiculo().getPlaca() : null,
			infracao.getDataOcorrencia(),
			infracao.getCepLocalOcorrencia(),
			new BigDecimal(infracao.getPessoa().getId()),
			infracao.getItemCtb().getPk().getCodigoInfracao(),
			new BigDecimal(infracao.getItemCtb().getPk().getDesdobramento()));
		
		this.veiculo = new VeiculoVO(infracao.getVeiculo());
		
		if (infracao.getStatusInfracao() != null && !infracao.getStatusInfracao().isEmpty()) {
			this.status = infracao.getStatusInfracao().get(infracao.getStatusInfracao().size()-1).getMensagem();
		}
		if (infracao.getNotificacaos() != null && !infracao.getNotificacaos().isEmpty()) {
			this.notificacaoVO = new NotificacaoVO(infracao.getNotificacaos().get(infracao.getNotificacaos().size()-1));
		}
		
	}
	
	public InfracaoVO() {
		super();
	}

	public VeiculoVO getVeiculo() {
		return veiculo;
	}
	
	public void setVeiculo(VeiculoVO veiculo) {
		this.veiculo = veiculo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public NotificacaoVO getNotificacaoVO() {
		return notificacaoVO;
	}

	public void setNotificacaoVO(NotificacaoVO notificacaoVO) {
		this.notificacaoVO = notificacaoVO;
	}
	
}

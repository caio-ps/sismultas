package br.com.fiap.sismultas.web.vo;

import java.text.SimpleDateFormat;

import br.com.fiap.sismultas.web.ws.consulta.InfracaoVO;

public class InfracaoConsultaVO extends InfracaoVO {

	private boolean selected;

	public InfracaoConsultaVO() {
	}

	public InfracaoConsultaVO(InfracaoVO parent) {
		this.setCepLocalOcorrencia(parent.getCepLocalOcorrencia());
		this.setCodigoInfracaoCtb(parent.getCodigoInfracaoCtb());
		this.setDataOcorrencia(parent.getDataOcorrencia());
		this.setDesdobramentoCtb(parent.getDesdobramentoCtb());
		this.setIdFiscal(parent.getIdFiscal());
		this.setPlacaVeiculo(parent.getPlacaVeiculo());
		
		this.setStatus(parent.getStatus());
		this.setNotificacaoVO(parent.getNotificacaoVO());
		this.setVeiculo(parent.getVeiculo());

	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public String getDataFormatada() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
		return sdf.format(this.getDataOcorrencia().toGregorianCalendar().getTime());
	}

}

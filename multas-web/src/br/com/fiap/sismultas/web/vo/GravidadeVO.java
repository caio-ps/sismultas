package br.com.fiap.sismultas.web.vo;

import br.com.fiap.sismultas.web.ws.ctb.GravidadeInfracaoVO;


public class GravidadeVO extends GravidadeInfracaoVO {

	private boolean selected;

	public GravidadeVO() {
	}
	
	public GravidadeVO(GravidadeInfracaoVO parent) {
		this.setId(parent.getId());
		this.setDescricao(parent.getDescricao());
		this.setPontos(parent.getPontos());
	}
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
}

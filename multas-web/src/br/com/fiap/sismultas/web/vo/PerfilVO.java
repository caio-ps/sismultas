package br.com.fiap.sismultas.web.vo;


public class PerfilVO extends br.com.fiap.sismultas.web.ws.usuario.PerfilVO{

	private boolean selected;

	public PerfilVO() {
	}
	
	public PerfilVO(br.com.fiap.sismultas.web.ws.usuario.PerfilVO parent) {
		this.setId(parent.getId());
		this.setDescricao(parent.getDescricao());
	}
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
}

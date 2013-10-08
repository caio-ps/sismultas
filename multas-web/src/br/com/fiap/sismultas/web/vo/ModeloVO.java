package br.com.fiap.sismultas.web.vo;


public class ModeloVO extends br.com.fiap.sismultas.web.ws.veiculo.ModeloVO{

	private boolean selected;

	public ModeloVO() {
	}
	
	public ModeloVO(br.com.fiap.sismultas.web.ws.veiculo.ModeloVO parent) {
		this.setId(parent.getId());
		this.setAno(parent.getAno());
		this.setDescricao(parent.getDescricao());
		this.setMontadora(parent.getMontadora());
	}
	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
}

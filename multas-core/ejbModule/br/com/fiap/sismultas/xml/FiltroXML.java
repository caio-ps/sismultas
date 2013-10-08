package br.com.fiap.sismultas.xml;

public class FiltroXML {

	private String descricao;
	private String valor;

	public FiltroXML() {
	}

	public FiltroXML(String descricao, String valor) {
		this.descricao = descricao;
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}


}

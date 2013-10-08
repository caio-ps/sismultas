package br.com.fiap.sismultas.xml;

public class MultaXML {

	private String placa;
	private String modelo;
	private String data;
	private String codCtb;
	private String descInfracao;
	
	public MultaXML() {
	}

	public MultaXML(String placa, String modelo, String data, String codCtb,
			String descInfracao) {
		this.placa = placa;
		this.modelo = modelo;
		this.data = data;
		this.codCtb = codCtb;
		this.descInfracao = descInfracao;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCodCtb() {
		return codCtb;
	}

	public void setCodCtb(String codCtb) {
		this.codCtb = codCtb;
	}

	public String getDescInfracao() {
		return descInfracao;
	}

	public void setDescInfracao(String descInfracao) {
		this.descInfracao = descInfracao;
	}

}

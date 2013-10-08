package br.com.fiap.sismultas.xml;

public class VeiculoXML {

	private String placa;
	private String modelo;

	public VeiculoXML() {
	}

	public VeiculoXML(String placa, String modelo) {
		super();
		this.placa = placa;
		this.modelo = modelo;
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

}

package br.com.fiap.sismultas.xml;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CobrancaXML {

	private String valor;
	private String dataVencimento;

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	public String getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public CobrancaXML(Double valor, Date dataVencimento) {
		super();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		this.valor = String.format("R$ %.2f", valor).replace(".", ",");
		this.dataVencimento = sdf.format(dataVencimento);
	}

	public CobrancaXML() {
	}

}

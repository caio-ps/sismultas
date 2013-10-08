package br.com.fiap.sismultas.xml;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InfracaoXML {

	private Long id;
	private String data;
	private String cepLocalOcorrencia;
	private String descricao;
	private String gravidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCepLocalOcorrencia() {
		return cepLocalOcorrencia;
	}

	public void setCepLocalOcorrencia(String cepLocalOcorrencia) {
		this.cepLocalOcorrencia = cepLocalOcorrencia;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getGravidade() {
		return gravidade;
	}

	public void setGravidade(String gravidade) {
		this.gravidade = gravidade;
	}

	public InfracaoXML(Long id, Date data, String cepLocalOcorrencia,
			String descricao, String gravidade) {
		super();
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		this.id = id;
		this.data = sdf.format(data);
		this.cepLocalOcorrencia = cepLocalOcorrencia;
		this.descricao = descricao;
		this.gravidade = gravidade;
	}

	public InfracaoXML() {
	}

}

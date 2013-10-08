package br.com.fiap.sismultas.ws.vo;

/**
 * Value Object: Encapsula os dados de um relatorio
 * 
 * @author caio-pereira
 * 
 */
public class RelatorioVO {

	private Long id;
	private String tipoRelatorio;
	private String caminhoArquivo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTipoRelatorio() {
		return tipoRelatorio;
	}

	public void setTipoRelatorio(String tipoRelatorio) {
		this.tipoRelatorio = tipoRelatorio;
	}

	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}

	public void setCaminhoArquivo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}

}

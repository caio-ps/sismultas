package br.com.fiap.sismultas.enumeration;

/**
 * Enumeracao com os tipos de relatorio gerados pelo sistema
 * 
 * @author caio-pereira
 *
 */
public enum TipoRelatorioEnum {

	NOTIFICACAO("Notificacao"),
	RELATORIO_VEICULO("Veiculo"),
	RELATORIO_FISCAL("Fiscal");
	
	private String descricao;

	private TipoRelatorioEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}

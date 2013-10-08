package br.com.fiap.sismultas.enumeration;

/**
 * Enumeracao com os status de uma notificacao de multa.
 * 
 * @author caio-pereira
 * 
 */
public enum StatusNotificacaoEnum {

	EMITIDA("Emitida."),
	ENVIADA_POR_EMAIL("Enviada por e-mail."),
	ERRO_PROCESSAMENTO("Erro no processamento."),
	ERRO_ENVIO("Erro no envio.");

	private String descricao;

	private StatusNotificacaoEnum(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

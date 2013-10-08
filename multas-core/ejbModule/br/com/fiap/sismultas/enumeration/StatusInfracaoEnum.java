package br.com.fiap.sismultas.enumeration;

/**
 * Enumeracao que lista as mensagens de status de uma Infracao.
 * 
 * @author caio-pereira
 *
 */
public enum StatusInfracaoEnum {

	PROCESSAMENTO_OK(0, "Processamento OK."),
	VEICULO_NAO_ENCONTRADO(1, "O veículo não foi encontrado na base de dados."),
	FISCAL_NAO_ENCONTRADO(2, "O fiscal emitente não pode ser identificado."),
	ITEM_CTB_NAO_ENCONTRADO(3, "O código da infração e/ou desdobramento não existem na base de dados.");

	private Integer codigo;
	private String mensagem;

	private StatusInfracaoEnum(Integer codigo, String mensagem) {
		this.codigo = codigo;
		this.mensagem = mensagem;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}

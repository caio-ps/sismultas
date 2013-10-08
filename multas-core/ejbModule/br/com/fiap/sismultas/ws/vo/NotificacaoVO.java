package br.com.fiap.sismultas.ws.vo;

import java.util.Date;

import br.com.fiap.sismultas.domain.Notificacao;

/**
 * Value Object:
 * Encapsula os dados de uma notificacao de infracao emitida.
 * 
 * @author caio-pereira
 *
 */
public class NotificacaoVO {

	private Long id;
	private Date dataEmissao;
	private String status;
	private String caminhoArquivo;
	
	public NotificacaoVO(Notificacao notificacao) {
		this.id = notificacao.getId();
		this.dataEmissao = notificacao.getDataEmissao();
		this.status = notificacao.getStatus().getDescricao();
		this.caminhoArquivo = notificacao.getCobrancaRecebers().get(notificacao.getCobrancaRecebers().size()-1).getCaminhoArquivo();
	}
	
	public NotificacaoVO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}

	public void setCaminhoArquivo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}
	
}

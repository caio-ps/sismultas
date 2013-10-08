package br.com.fiap.sismultas.domain;

import java.io.Serializable;
import javax.persistence.*;

import br.com.fiap.sismultas.domain.manager.EntityManagerContainer;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the cobranca_receber database table.
 * 
 */
@Entity
@Table(name="cobranca_receber")
public class CobrancaReceber extends EntityManagerContainer implements Serializable {

	private static final long serialVersionUID = 3177153078291991032L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_criacao")
	private Date dataCriacao;

	@Column(name="valor")
	private double valor;

	@ManyToOne
	@JoinColumn(name="id_notificao")
	private Notificacao notificacao;
	
	@Column(name="caminho_arquivo")
	private String caminhoArquivo;

	@OneToMany(mappedBy="cobrancaReceber")
	private List<CobrancaRecebida> cobrancaRecebidas;

	//------ Métodos da entidade ------//
	//---------------------------------//
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataCriacao() {
		return this.dataCriacao;
	}

	public void setDataCriacao(Date dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Notificacao getNotificacao() {
		return this.notificacao;
	}

	public void setNotificacao(Notificacao notificacao) {
		this.notificacao = notificacao;
	}

	public List<CobrancaRecebida> getCobrancaRecebidas() {
		return this.cobrancaRecebidas;
	}

	public void setCobrancaRecebidas(List<CobrancaRecebida> cobrancaRecebidas) {
		this.cobrancaRecebidas = cobrancaRecebidas;
	}

	public String getCaminhoArquivo() {
		return caminhoArquivo;
	}

	public void setCaminhoArquivo(String caminhoArquivo) {
		this.caminhoArquivo = caminhoArquivo;
	}

}
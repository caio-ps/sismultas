package br.com.fiap.sismultas.domain;

import java.io.Serializable;
import javax.persistence.*;

import br.com.fiap.sismultas.domain.manager.EntityManagerContainer;

import java.util.Date;


/**
 * The persistent class for the cobranca_recebida database table.
 * 
 */
@Entity
@Table(name="cobranca_recebida")
public class CobrancaRecebida extends EntityManagerContainer implements Serializable {

	private static final long serialVersionUID = 5424775594173345963L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_processamento")
	private Date dataProcessamento;

	@Column(name="valor")
	private double valor;

	@ManyToOne
	@JoinColumn(name="id_cobranca_receber")
	private CobrancaReceber cobrancaReceber;

	//------ Métodos da entidade ------//
	//---------------------------------//
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataProcessamento() {
		return this.dataProcessamento;
	}

	public void setDataProcessamento(Date dataProcessamento) {
		this.dataProcessamento = dataProcessamento;
	}

	public double getValor() {
		return this.valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public CobrancaReceber getCobrancaReceber() {
		return this.cobrancaReceber;
	}

	public void setCobrancaReceber(CobrancaReceber cobrancaReceber) {
		this.cobrancaReceber = cobrancaReceber;
	}

}
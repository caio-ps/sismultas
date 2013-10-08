package br.com.fiap.sismultas.domain;

import java.io.Serializable;
import javax.persistence.*;

import br.com.fiap.sismultas.domain.manager.EntityManagerContainer;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the notificacao database table.
 * 
 */
@Entity
@Table(name="notificacao")
public class Notificacao extends EntityManagerContainer implements Serializable {

	private static final long serialVersionUID = 4493889288390598774L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_emissao")
	private Date dataEmissao;

	@OneToMany(mappedBy="notificacao")
	private List<CobrancaReceber> cobrancaRecebers;

	@ManyToOne
	@JoinColumn(name="id_infracao")
	private Infracao infracao;
	
	@ManyToOne
	@JoinColumn(name="id_status")
	private StatusNotificacao status;
	
	//------ Métodos da entidade ------//
	/**
	 * Busca notificacao pelo ID
	 * 
	 * @return
	 */
	public static Notificacao find(Long id) {
		
		return getEntityManager().find(Notificacao.class, id);
		
	}
	
	//---------------------------------//
	
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDataEmissao() {
		return this.dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public List<CobrancaReceber> getCobrancaRecebers() {
		return this.cobrancaRecebers;
	}

	public void setCobrancaRecebers(List<CobrancaReceber> cobrancaRecebers) {
		this.cobrancaRecebers = cobrancaRecebers;
	}

	public Infracao getInfracao() {
		return this.infracao;
	}

	public void setInfracao(Infracao infracao) {
		this.infracao = infracao;
	}

	public StatusNotificacao getStatus() {
		return status;
	}

	public void setStatus(StatusNotificacao status) {
		this.status = status;
	}

}
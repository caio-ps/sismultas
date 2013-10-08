package br.com.fiap.sismultas.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.fiap.sismultas.domain.manager.EntityManagerContainer;

@Entity
@Table(name = "status_infracao")
public class StatusInfracao extends EntityManagerContainer implements Serializable {

	private static final long serialVersionUID = 6224189235538453069L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_infracao")
	private Infracao infracao;

	@Column(name = "codigo")
	private Long codigo;

	@Column(name = "mensagem")
	private String mensagem;
	
	//------ Métodos da entidade ------//
	//---------------------------------//

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Infracao getInfracao() {
		return infracao;
	}

	public void setInfracao(Infracao infracao) {
		this.infracao = infracao;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

}

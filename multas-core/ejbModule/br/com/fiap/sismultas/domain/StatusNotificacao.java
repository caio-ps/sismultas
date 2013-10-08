package br.com.fiap.sismultas.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import javax.persistence.Table;

import br.com.fiap.sismultas.domain.manager.EntityManagerContainer;

@Entity
@Table(name = "status_notificacao")
@NamedQueries({
	@NamedQuery(name="buscaStatusNotificaoPorDescricao", query="SELECT sn FROM StatusNotificacao sn WHERE sn.descricao = ?1")
})
public class StatusNotificacao extends EntityManagerContainer implements Serializable {

	private static final long serialVersionUID = 6224189235538453069L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="descricao")
	private String descricao;
	
	//------ Métodos da entidade ------//
	
	/**
	 * Busca um status pela descricao.
	 * 
	 * @param descricao
	 * @return
	 */
	public static StatusNotificacao buscaPorDescricao(String descricao) {
		
		Query query = getEntityManager().createNamedQuery("buscaStatusNotificaoPorDescricao");
		query.setParameter(1, descricao);
		return (StatusNotificacao) query.getSingleResult();
		
	}
	
	//---------------------------------//

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}

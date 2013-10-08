package br.com.fiap.sismultas.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.fiap.sismultas.domain.manager.EntityManagerContainer;


/**
 * The persistent class for the item_ctb database table.
 * 
 */
@Entity
@Table(name="item_ctb")
public class ItemCtb extends EntityManagerContainer implements Serializable {

	private static final long serialVersionUID = 8898148240812761239L;

	@EmbeddedId
	private ItemCtbPK pk;
	
	@Column(name="artigo")
	private Integer artigo;

	@Column(name="descricao_resumida")
	private String descricaoResumida;

	@Column(name="paragrafo")
	private Integer paragrafo;

	@Column(name="valor_multa")
	private double valorMulta;

	@OneToMany(mappedBy="itemCtb")
	private List<Infracao> infracaos;

	@ManyToOne
	@JoinColumn(name="id_gravidade")
	private InfracaoGravidade infracaoGravidade;
	
	//------ Métodos da entidade ------//

	/**
	 * Busca um item do ctb pelo Id
	 * 
	 * @param id
	 * @return
	 */
	public static ItemCtb buscaPorId(ItemCtbPK id) {
		return getEntityManager().find(ItemCtb.class, id);
	}

	//---------------------------------//
	
	public Integer getArtigo() {
		return this.artigo;
	}

	public void setArtigo(Integer artigo) {
		this.artigo = artigo;
	}

	public String getDescricaoResumida() {
		return this.descricaoResumida;
	}

	public void setDescricaoResumida(String descricaoResumida) {
		this.descricaoResumida = descricaoResumida;
	}

	public Integer getParagrafo() {
		return this.paragrafo;
	}

	public void setParagrafo(Integer paragrafo) {
		this.paragrafo = paragrafo;
	}

	public double getValorMulta() {
		return this.valorMulta;
	}

	public void setValorMulta(double valorMulta) {
		this.valorMulta = valorMulta;
	}

	public List<Infracao> getInfracaos() {
		return this.infracaos;
	}

	public void setInfracaos(List<Infracao> infracaos) {
		this.infracaos = infracaos;
	}

	public InfracaoGravidade getInfracaoGravidade() {
		return this.infracaoGravidade;
	}

	public void setInfracaoGravidade(InfracaoGravidade infracaoGravidade) {
		this.infracaoGravidade = infracaoGravidade;
	}

	public ItemCtbPK getPk() {
		return pk;
	}

	public void setPk(ItemCtbPK pk) {
		this.pk = pk;
	}

}
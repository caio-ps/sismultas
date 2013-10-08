package br.com.fiap.sismultas.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;

import br.com.fiap.sismultas.domain.manager.EntityManagerContainer;


/**
 * The persistent class for the veiculo_modelo database table.
 * 
 */
@Entity
@Table(name="veiculo_modelo")
@NamedQueries({
	@NamedQuery(name="todosModelos", query="SELECT vm FROM VeiculoModelo vm")
})
public class VeiculoModelo extends EntityManagerContainer implements Serializable {

	private static final long serialVersionUID = -4574686728201142620L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	@Column(name="ano")
	private Integer ano;

	@Column(name="descricao")
	private String descricao;

	@Column(name="montadora")
	private String montadora;

	@OneToMany(mappedBy="veiculoModelo")
	private List<Veiculo> veiculos;
	
	//------ Métodos da entidade ------//
	/**
	 * Busca todos os modelos cadastrados
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static List<VeiculoModelo> buscaTodos() {
		
		Query query = getEntityManager().createNamedQuery("todosModelos", VeiculoModelo.class);
		List<VeiculoModelo> modelos = (List<VeiculoModelo>) query.getResultList();
		
		return modelos;
		
	}
	
	/**
	 * Busca modelo pelo id
	 * 
	 * @param id
	 * @return
	 */
	public static VeiculoModelo find(Long id) {
		
		return getEntityManager().find(VeiculoModelo.class, id);
		
	}
	//---------------------------------//

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAno() {
		return this.ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMontadora() {
		return this.montadora;
	}

	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}

	public List<Veiculo> getVeiculos() {
		return this.veiculos;
	}

	public void setVeiculos(List<Veiculo> veiculos) {
		this.veiculos = veiculos;
	}

}
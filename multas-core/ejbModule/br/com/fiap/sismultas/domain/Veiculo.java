package br.com.fiap.sismultas.domain;

import java.io.Serializable;
import javax.persistence.*;

import br.com.fiap.sismultas.domain.manager.EntityManagerContainer;

import java.util.List;


/**
 * The persistent class for the veiculo database table.
 * 
 */
@Entity
@Table(name="veiculo")
@NamedQueries({
	@NamedQuery(name="veiculoPorPlaca", query="SELECT v FROM Veiculo v WHERE v.placa = ?1")
})
public class Veiculo extends EntityManagerContainer implements Serializable {

	private static final long serialVersionUID = 8722759637086836096L;

	@Id
	@Column(name="chassi")
	private String chassi;

	@Column(name="cor")
	private String cor;

	@Column(name="placa")
	private String placa;

	@OneToMany(mappedBy="veiculo")
	private List<Infracao> infracaos;

	@ManyToOne
	@JoinColumn(name="id_pessoa")
	private Pessoa pessoa;

	@ManyToOne
	@JoinColumn(name="id_modelo")
	private VeiculoModelo veiculoModelo;
	
	//------ Métodos da entidade ------//
	
	/**
	 * Busca um veículo pela placa.
	 * 
	 * @param placa
	 * @return
	 */
	public static Veiculo buscaPorPlaca(String placa) {
	
		try {
			
			Query query = getEntityManager().createNamedQuery("veiculoPorPlaca", Veiculo.class);
			query.setParameter(1, placa);
			Veiculo veiculo = (Veiculo) query.getSingleResult();
			
			return veiculo;
			
		} catch (NoResultException nre) {
			return null;
		}
		
	}
	
	/**
	 * Busca veículo pelo chassi
	 * 
	 * @param chassi
	 * @return
	 */
	public static Veiculo find(String chassi) {
		
		return getEntityManager().find(Veiculo.class, chassi);
		
	}

	//---------------------------------//
	
	public String getChassi() {
		return this.chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getCor() {
		return this.cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return this.placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public List<Infracao> getInfracaos() {
		return this.infracaos;
	}

	public void setInfracaos(List<Infracao> infracaos) {
		this.infracaos = infracaos;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public VeiculoModelo getVeiculoModelo() {
		return this.veiculoModelo;
	}

	public void setVeiculoModelo(VeiculoModelo veiculoModelo) {
		this.veiculoModelo = veiculoModelo;
	}

}
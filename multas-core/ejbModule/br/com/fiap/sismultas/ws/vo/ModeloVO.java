package br.com.fiap.sismultas.ws.vo;

import br.com.fiap.sismultas.domain.VeiculoModelo;

/**
 * Value Object: representa um modelo de veiculo
 */
public class ModeloVO {

	private Long id;
	private String descricao;
	private String montadora;
	private Integer ano;

	public ModeloVO(){}
	
	public ModeloVO(VeiculoModelo modelo) {
		this.id = modelo.getId();
		this.descricao = modelo.getDescricao();
		this.montadora = modelo.getMontadora();
		this.ano = modelo.getAno();
	}
	
	public VeiculoModelo toEntity() {
		
		VeiculoModelo entity = new VeiculoModelo();
		
		entity.setAno(this.ano);
		entity.setDescricao(this.descricao);
		entity.setMontadora(this.montadora);
		entity.setId(this.id);

		return entity;
		
	}
	
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

	public String getMontadora() {
		return montadora;
	}

	public void setMontadora(String montadora) {
		this.montadora = montadora;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

}

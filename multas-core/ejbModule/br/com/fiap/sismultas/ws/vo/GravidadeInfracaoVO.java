package br.com.fiap.sismultas.ws.vo;

import br.com.fiap.sismultas.domain.InfracaoGravidade;

/**
 * Value object - representa a gravidade de uma infração de trânsito
 * 
 * @author caio-pereira
 * 
 */
public class GravidadeInfracaoVO {

	private Long id;
	private String descricao;
	private Integer pontos;

	public GravidadeInfracaoVO() {
	}

	public GravidadeInfracaoVO(InfracaoGravidade gravidade) {

		this.id = gravidade.getId();
		this.descricao = gravidade.getDescricao();
		this.pontos = gravidade.getPontos();

	}

	public InfracaoGravidade toEntity() {

		InfracaoGravidade entity = new InfracaoGravidade();

		entity.setId(this.id);
		entity.setDescricao(this.descricao);
		entity.setPontos(this.pontos);

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

	public Integer getPontos() {
		return pontos;
	}

	public void setPontos(Integer pontos) {
		this.pontos = pontos;
	}

}

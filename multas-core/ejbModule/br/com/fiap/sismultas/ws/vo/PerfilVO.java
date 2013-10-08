package br.com.fiap.sismultas.ws.vo;

import br.com.fiap.sismultas.domain.Perfil;

/**
 * Value Object: representa um perfil
 */
public class PerfilVO {

	private Long id;
	private String descricao;

	public PerfilVO(){}
	
	public PerfilVO(Perfil perfil) {
		this.id = perfil.getId();
		this.descricao = perfil.getDescricao();
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

}

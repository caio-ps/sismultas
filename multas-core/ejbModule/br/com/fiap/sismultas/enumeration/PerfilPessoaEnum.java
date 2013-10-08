package br.com.fiap.sismultas.enumeration;

import java.util.List;

import br.com.fiap.sismultas.domain.Perfil;

/**
 * Enumeracao que lista os perfis (roles) dos atores do sistema.
 * 
 * @author caio-pereira
 *
 */
public enum PerfilPessoaEnum {

	FISCAL("fiscal");

	private String descricao;

	/**
	 * 
	 * Verifica se uma pessoa contem um determinado perfil a partir
	 * da lista de perfis desta pessoa.
	 * 
	 * @param perfil
	 * @param perfis
	 * @return
	 */
	public static boolean contemPerfil(PerfilPessoaEnum perfil, List<Perfil> perfis) {
		
		for (Perfil perfilPessoa : perfis) {
			if (perfil.getDescricao().equals(perfilPessoa.getDescricao())) {
				return Boolean.TRUE;
			}
		}
		
		return Boolean.FALSE;
		
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	private PerfilPessoaEnum(String descricao) {
		this.descricao = descricao;
	}

}

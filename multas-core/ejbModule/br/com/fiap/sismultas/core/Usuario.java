package br.com.fiap.sismultas.core;

import javax.ejb.Local;

import br.com.fiap.sismultas.domain.Pessoa;
import br.com.fiap.sismultas.ws.vo.PessoaVO;


@Local
public interface Usuario {

	/**
	 * Método para autenticacao de um usuário
	 * 
	 * @param usuario
	 * @param senha
	 * @return
	 */
	Pessoa autentica(String usuario, String senha);
	
	/**
	 * Cadastro de usuário
	 * 
	 * @param pessoaVO
	 * @return
	 */
	PessoaVO cadastra(PessoaVO pessoaVO);
	
}

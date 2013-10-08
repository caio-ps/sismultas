package br.com.fiap.sismultas.ws;

import javax.ejb.Remote;

import br.com.fiap.sismultas.ws.vo.PessoaVO;

@Remote
public interface AutenticacaoWS {

	/**
	 * Autenticacao de usuario
	 * 
	 * @param usuario
	 * @param senha - deve vir em hexadecimal como hash MD5
	 * @return
	 */
	PessoaVO autentica(String usuario, String senha) throws Exception;
	
}

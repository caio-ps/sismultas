package br.com.fiap.sismultas.ws;

import java.util.List;

import javax.ejb.Remote;

import br.com.fiap.sismultas.ws.vo.PerfilVO;
import br.com.fiap.sismultas.ws.vo.PessoaVO;

@Remote
public interface UsuarioWS {

	/**
	 * Método que recupera todos os perfis do sistema
	 * 
	 * @return
	 * @throws Exception
	 */
	List<PerfilVO> getPerfis() throws Exception;
	
	/**
	 * Cadastro de usuário
	 * 
	 * @param pessoaVO
	 * @return
	 * @throws Exception
	 */
	PessoaVO cadastra(PessoaVO pessoaVO) throws Exception;
	
}

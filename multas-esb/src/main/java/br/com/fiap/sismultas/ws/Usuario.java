package br.com.fiap.sismultas.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.fiap.sismultas.mule.user.ws.PerfilVO;
import br.com.fiap.sismultas.mule.user.ws.PessoaVO;


@WebService(name = "Usuario")
public interface Usuario {

	@WebMethod(action = "getPerfis")
	List<PerfilVO> getPerfis() throws Exception ;
	
	@WebMethod(action = "cadastra")
	PessoaVO cadastra(PessoaVO pessoaVO) throws Exception ;

}

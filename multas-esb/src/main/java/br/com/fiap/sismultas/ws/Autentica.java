package br.com.fiap.sismultas.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.fiap.sismultas.mule.auth.ws.PessoaVO;


@WebService(name = "Autentica")
public interface Autentica {

	@WebMethod(action = "autentica")
	PessoaVO autentica( @WebParam(name = "usuario") String usuario, @WebParam(name = "senha") String senha)
		throws Exception ;

}

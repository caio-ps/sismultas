package br.com.fiap.sismultas.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.fiap.sismultas.mule.ws.MultaVO;

@WebService(name = "EmiteMulta")
public interface EmiteMulta {

	@WebMethod(action = "emiteMulta")
	void emiteMulta(@WebParam(name = "dadosMulta") MultaVO dadosMultaVO);
	
}

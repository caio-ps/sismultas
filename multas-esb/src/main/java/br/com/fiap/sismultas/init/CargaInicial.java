package br.com.fiap.sismultas.init;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(name = "CargaInicial")
public interface CargaInicial {

	@WebMethod(operationName = "executaCargaInicial")
	String executaCargaInicial();
	
}

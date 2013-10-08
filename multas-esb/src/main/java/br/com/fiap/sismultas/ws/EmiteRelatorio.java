package br.com.fiap.sismultas.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.fiap.sismultas.mule.ws.MultaVO;
import br.com.fiap.sismultas.mule.ws.RelatorioVO;


@WebService(name = "EmiteRelatorio")
public interface EmiteRelatorio {

	@WebMethod(action = "emiteRelatorio")
	RelatorioVO emiteRelatorio(@WebParam(name="filtro") MultaVO filtro) throws Exception ;

}

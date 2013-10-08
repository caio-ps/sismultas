package br.com.fiap.sismultas.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.fiap.sismultas.mule.ws.InfracaoVO;
import br.com.fiap.sismultas.mule.ws.MultaVO;


@WebService(name = "ConsultaMultas")
public interface ConsultaMultas {

	@WebMethod(action = "consulta")
	List<InfracaoVO> getMultas(MultaVO filtro) throws Exception;

}

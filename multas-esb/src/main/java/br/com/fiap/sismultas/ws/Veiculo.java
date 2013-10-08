package br.com.fiap.sismultas.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.fiap.sismultas.mule.car.ws.ModeloVO;
import br.com.fiap.sismultas.mule.car.ws.VeiculoVO;


@WebService(name = "Veiculo")
public interface Veiculo {

	@WebMethod(action = "getModelos")
	List<ModeloVO> getModelos() throws Exception;
	
	@WebMethod(action = "cadastra")
	VeiculoVO cadastra(VeiculoVO veiculoVO) throws Exception;

}

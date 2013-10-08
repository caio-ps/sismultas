package br.com.fiap.sismultas.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;

import br.com.fiap.sismultas.mule.ws.GravidadeInfracaoVO;
import br.com.fiap.sismultas.mule.ws.ItemCTBVO;


@WebService(name = "Ctb")
public interface Ctb {

	@WebMethod(operationName="getGravidades")
	List<GravidadeInfracaoVO> getGravidades() throws Exception;
	
	@WebMethod(operationName="cadastraItemCtb")
	ItemCTBVO cadastraItemCTB(ItemCTBVO itemCTBVO) throws Exception;

}

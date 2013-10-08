package br.com.fiap.sismultas.ws;

import java.util.List;

import br.com.fiap.sismultas.mule.ws.GravidadeInfracaoVO;
import br.com.fiap.sismultas.mule.ws.ItemCTBVO;
import br.com.fiap.sismultas.mule.ws.MultasWSBean;
import br.com.fiap.sismultas.mule.ws.SisMultasWS;

public class CtbService implements Ctb {

	@Override
	public List<GravidadeInfracaoVO> getGravidades() throws Exception {
		
		MultasWSBean wsMultas = (new SisMultasWS()).getMultasWSBeanPort();
		return wsMultas.getGravidades();
		
	}

	@Override
	public ItemCTBVO cadastraItemCTB(ItemCTBVO itemCTBVO) throws Exception {
		
		MultasWSBean wsMultas = (new SisMultasWS()).getMultasWSBeanPort();
		return wsMultas.cadastraItemCTB(itemCTBVO);
		
	}

}

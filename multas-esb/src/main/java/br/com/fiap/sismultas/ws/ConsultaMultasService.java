package br.com.fiap.sismultas.ws;

import java.util.List;

import br.com.fiap.sismultas.mule.ws.InfracaoVO;
import br.com.fiap.sismultas.mule.ws.MultaVO;
import br.com.fiap.sismultas.mule.ws.MultasWSBean;
import br.com.fiap.sismultas.mule.ws.SisMultasWS;

public class ConsultaMultasService implements ConsultaMultas {

	@Override
	public List<InfracaoVO> getMultas(MultaVO filtro) throws Exception {
		
		MultasWSBean multasWS = (new SisMultasWS()).getMultasWSBeanPort();
		return multasWS.getMultas(filtro);
		
	}

	

}

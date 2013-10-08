package br.com.fiap.sismultas.ws;

import br.com.fiap.sismultas.mule.ws.MultaVO;
import br.com.fiap.sismultas.mule.ws.MultasWSBean;
import br.com.fiap.sismultas.mule.ws.RelatorioVO;
import br.com.fiap.sismultas.mule.ws.SisMultasWS;

public class EmiteRelatorioService implements EmiteRelatorio {

	@Override
	public RelatorioVO emiteRelatorio(MultaVO filtro) throws Exception {
	
		try {

			MultasWSBean wsMultas = (new SisMultasWS()).getMultasWSBeanPort();
			return wsMultas.geraRelatorioMultas(filtro);

		} catch (Exception ex) {
			throw ex;
		}
		
	}

}

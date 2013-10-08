package br.com.fiap.sismultas.ws;

import br.com.fiap.sismultas.mule.ws.IdOperacaoVO;
import br.com.fiap.sismultas.mule.ws.MultasWSBean;
import br.com.fiap.sismultas.mule.ws.SisMultasWS;

public class EmiteNotificacaoService implements EmiteNotificacao {

	public IdOperacaoVO emiteNotificacao(IdOperacaoVO idInfracao) throws Exception {

		try {

			MultasWSBean wsMultas = (new SisMultasWS()).getMultasWSBeanPort();
			return wsMultas.emiteNotificacao(idInfracao);

		} catch (Exception ex) {
			throw ex;
		}
		
	}

}

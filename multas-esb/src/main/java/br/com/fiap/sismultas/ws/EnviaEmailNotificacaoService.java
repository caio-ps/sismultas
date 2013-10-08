package br.com.fiap.sismultas.ws;

import br.com.fiap.sismultas.mule.ws.MultasWSBean;
import br.com.fiap.sismultas.mule.ws.RelatorioVO;
import br.com.fiap.sismultas.mule.ws.SisMultasWS;

public class EnviaEmailNotificacaoService implements EnviaEmailNotificacao {

	public void enviaEmailNotificacao(RelatorioVO relatorioVO) throws Exception {

		try {

			MultasWSBean wsMultas = (new SisMultasWS()).getMultasWSBeanPort();
			wsMultas.enviaEmailNotificacao(relatorioVO);

		} catch (Exception ex) {
			throw ex;
		}

	}

}

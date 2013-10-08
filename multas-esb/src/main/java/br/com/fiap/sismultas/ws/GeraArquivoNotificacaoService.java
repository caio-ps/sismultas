package br.com.fiap.sismultas.ws;

import br.com.fiap.sismultas.mule.ws.IdOperacaoVO;
import br.com.fiap.sismultas.mule.ws.MultasWSBean;
import br.com.fiap.sismultas.mule.ws.RelatorioVO;
import br.com.fiap.sismultas.mule.ws.SisMultasWS;

public class GeraArquivoNotificacaoService implements GeraArquivoNotificacao {
	
	public RelatorioVO geraArquivoNotificacao(IdOperacaoVO idNotificacao) throws Exception {
		
		try {
			
			MultasWSBean wsMultas = (new SisMultasWS()).getMultasWSBeanPort();
			return wsMultas.geraArquivoNotificacao(idNotificacao);
			
		} catch (Exception ex) {
			throw ex;
		}
		
	}

}

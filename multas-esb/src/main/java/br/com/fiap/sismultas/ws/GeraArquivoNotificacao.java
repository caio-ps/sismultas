package br.com.fiap.sismultas.ws;

import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.fiap.sismultas.mule.ws.IdOperacaoVO;
import br.com.fiap.sismultas.mule.ws.RelatorioVO;

@WebService(name = "GeraArquivoNotificacao")
public interface GeraArquivoNotificacao {
	
	RelatorioVO geraArquivoNotificacao(@WebParam(name="idNotificacao") IdOperacaoVO idNotificacao) throws Exception;

}

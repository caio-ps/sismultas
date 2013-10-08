package br.com.fiap.sismultas.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.fiap.sismultas.mule.ws.RelatorioVO;


@WebService(name = "EnviaEmailNotificacao")
public interface EnviaEmailNotificacao {

	@WebMethod(action = "enviaEmailNotificacao")
	void enviaEmailNotificacao(@WebParam(name="relatorio") RelatorioVO relatorioVO) throws Exception;

}

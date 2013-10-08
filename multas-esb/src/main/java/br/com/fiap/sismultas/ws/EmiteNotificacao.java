package br.com.fiap.sismultas.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.com.fiap.sismultas.mule.ws.IdOperacaoVO;


@WebService(name = "EmiteNotificacao")
public interface EmiteNotificacao {

	@WebMethod(action = "emiteNotificacao")
	IdOperacaoVO emiteNotificacao(@WebParam(name="idInfracao") IdOperacaoVO idInfracao) throws Exception ;

}

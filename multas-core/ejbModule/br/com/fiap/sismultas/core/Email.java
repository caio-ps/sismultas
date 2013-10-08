package br.com.fiap.sismultas.core;

import javax.ejb.Local;

import br.com.fiap.sismultas.ws.vo.EmailVO;


@Local
public interface Email {

	/**
	 * Método que envia e-mail.
	 * 
	 * @param tipoEmail
	 * @param parametros
	 */
	boolean envia(EmailVO emailVO);
	
}

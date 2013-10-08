package br.com.fiap.sismultas.core;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;

import org.apache.log4j.Logger;

import br.com.fiap.sismultas.util.PropertiesUtil;
import br.com.fiap.sismultas.ws.vo.EmailVO;

/**
 * Session Bean que representa um email
 */
@Stateless
@LocalBean
public class EmailBean implements Email {

	private static final Logger LOGGER = Logger.getLogger(Email.class);
	
	@Resource(mappedName = "java:jboss/mail/SisMultas")
	private Session mailSession;

	@Override
	public boolean envia(EmailVO emailVO) {

		try {

			LOGGER.info("Enviando e-mail para o destinatario: " + emailVO.getDestinatario());
			
			//-----------------------------------------------------------------------------------------//
			//------ Busca remetente padrão do sistema ------------------------------------------------//
			//-----------------------------------------------------------------------------------------//
			String remetente = PropertiesUtil.readProperty(PropertiesUtil.EMAIL_REMETENTE);
			
			LOGGER.info("Remetente: " + remetente);
			
			//-----------------------------------------------------------------------------------------//
			//------ Converte o VO para objetos JavaMail ----------------------------------------------//
			//-----------------------------------------------------------------------------------------//
			Message message = emailVO.toMimeMessage(mailSession, remetente);
			
			//-----------------------------------------------------------------------------------------//
			//------ Envia o e-mail -------------------------------------------------------------------//
			//-----------------------------------------------------------------------------------------//
			Transport.send(message);
			
			LOGGER.info("E-mail enviado com sucesso!");
			
			return Boolean.TRUE;
			
		} catch (Exception ex) {
			
			LOGGER.error("Ocorreu um erro no envio do e-mail", ex);
			return Boolean.FALSE;
			
		}

	}

}

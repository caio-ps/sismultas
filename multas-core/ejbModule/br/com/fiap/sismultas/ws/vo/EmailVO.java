package br.com.fiap.sismultas.ws.vo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 * Value Object:
 * Representa os dados de um e-mail.
 * 
 */
public class EmailVO {

	private String destinatario;
	private String assunto;
	private String mensagem;
	private String[] anexos;
	
	public EmailVO(String destinatario, String assunto, String mensagem,
			String[] anexos) {
		super();
		this.destinatario = destinatario;
		this.assunto = assunto;
		this.mensagem = mensagem;
		this.anexos = anexos;
	}

	public Message toMimeMessage(Session session, String remetente) throws MessagingException {
		
		//Cria mensagem principal do tipo MimeMessage
		Message message = new MimeMessage(session);
		
		//Dados de envio (Remetente, destinatario)
		message.setFrom(new InternetAddress(remetente));
		message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(this.destinatario));
		
		//Assunto da mensagem
		message.setSubject(this.assunto);

		// Texto da mensagem
		MimeBodyPart bodyPartText = new MimeBodyPart();
		bodyPartText.setText(this.mensagem);
		
		//Anexos
		List<MimeBodyPart> listAnexos = new ArrayList<MimeBodyPart>();
		
		for (String arquivoAnexo : this.anexos) {
			
			MimeBodyPart bodyPartAnexo = new MimeBodyPart();
			FileDataSource fds = new FileDataSource(arquivoAnexo);
			bodyPartAnexo.setDataHandler(new DataHandler(fds));
			bodyPartAnexo.setFileName(fds.getName());
			
			listAnexos.add(bodyPartAnexo);
			
		}
		
		// Data de envio da mensagem
		message.setSentDate(new Date());
		
		// Multipart - Objeto que encapsula texto e anexo das mensagens
		Multipart multiPart = new MimeMultipart();
		multiPart.addBodyPart(bodyPartText);
		
		for (MimeBodyPart bodyPartAnexo : listAnexos) {
			multiPart.addBodyPart(bodyPartAnexo);
		}
		
		// adiciona a Multipart na mensagem
		message.setContent(multiPart);
		
		return message;
		
	}

	public String getDestinatario() {
		return destinatario;
	}

	public void setDestinatario(String destinatario) {
		this.destinatario = destinatario;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String[] getAnexos() {
		return anexos;
	}

	public void setAnexos(String[] anexos) {
		this.anexos = anexos;
	}

}

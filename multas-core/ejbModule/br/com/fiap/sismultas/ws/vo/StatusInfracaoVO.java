package br.com.fiap.sismultas.ws.vo;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.sismultas.enumeration.StatusInfracaoEnum;

/**
 * Value Object:
 * Encapsula os dados do status de uma Infracao
 * 
 * @author caio-pereira
 *
 */
public class StatusInfracaoVO {

	private boolean valido;
	private List<StatusInfracaoEnum> mensagens;

	public void adicionaMensagem(StatusInfracaoEnum mensagem) {
		
		if (this.getMensagens() == null) {
			this.setMensagens(new ArrayList<StatusInfracaoEnum>());
		}
		
		this.getMensagens().add(mensagem);
		
	}
	
	public StatusInfracaoVO(boolean valido) {
		super();
		this.valido = valido;
	}

	public boolean isValido() {
		return valido;
	}

	public void setValido(boolean valido) {
		this.valido = valido;
	}

	public List<StatusInfracaoEnum> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<StatusInfracaoEnum> mensagens) {
		this.mensagens = mensagens;
	}

}

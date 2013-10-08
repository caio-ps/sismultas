package br.com.fiap.sismultas.web.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import br.com.fiap.sismultas.web.facade.ESBFacade;
import br.com.fiap.sismultas.web.util.CryptUtil;
import br.com.fiap.sismultas.web.ws.autentica.PerfilVO;
import br.com.fiap.sismultas.web.ws.autentica.PessoaVO;

@RequestScoped
@ManagedBean(name="loginMB")
public class LoginMB {

	private String usuario;
	private String senha;
	
	/**
	 * Metodo para efetuar login do usuario
	 * 
	 * @return
	 */
	public String login() {
	
		try {
			//Chama o Facade ESB para executar o serviço de login.
			PessoaVO voLogin = ESBFacade.login(usuario, CryptUtil.hashMD5(senha));
			
			//Valida login feito com sucesso
			if (voLogin != null) {
			
				if (voLogin.isSucesso()) {
					
					boolean perfilAdministrador = Boolean.FALSE;
					
					if (voLogin.getPerfis() != null && !voLogin.getPerfis().isEmpty()) {
						for (PerfilVO perfilVO : voLogin.getPerfis()) {
							if (perfilVO.getDescricao().equals("administrador")) {
								perfilAdministrador = Boolean.TRUE;
							}
						}
					}
					
					if (!perfilAdministrador) {
						FacesContext.getCurrentInstance().addMessage(
								null, new FacesMessage(
										FacesMessage.SEVERITY_ERROR,
										"Usuário não contém privilégios de acesso ao sistema.",
										"Usuário não contém privilégios de acesso ao sistema."));
						
						return null;
					}
					
					HttpSession session = 
							(HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(Boolean.TRUE);
					session.setAttribute("pessoaVO", voLogin);
					
					return "pages/inicial";
					
				} else {
					
					FacesContext.getCurrentInstance().addMessage(
							null, new FacesMessage(
									FacesMessage.SEVERITY_ERROR,
									"Usuário e/ou senha inválidos.",
									"Usuário e/ou senha inválidos."));
					
					return null;
					
				}
				
			//Ocorreu alguma exceção na chamada do serviço.
			} else {
			
				FacesContext.getCurrentInstance().addMessage(
						null, new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Ocorreu um erro. Tente novamente mais tarde.",
								"Ocorreu um erro. Tente novamente mais tarde."));
			
				return null;
				
			}
		
		} catch (Exception ex) {
			
			FacesContext.getCurrentInstance().addMessage(
					null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Ocorreu um erro. Tente novamente mais tarde.",
							"Ocorreu um erro. Tente novamente mais tarde."));
			return null;
		}
		
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
}

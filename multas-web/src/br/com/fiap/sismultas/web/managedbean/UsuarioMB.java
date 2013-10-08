package br.com.fiap.sismultas.web.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.sismultas.web.facade.ESBFacade;
import br.com.fiap.sismultas.web.vo.PerfilVO;
import br.com.fiap.sismultas.web.ws.usuario.PessoaVO;

@RequestScoped
@ManagedBean(name = "usuarioMB")
public class UsuarioMB {

	private Long id;
	private String nome;
	private String sobrenome;
	private String nomeUsuario;
	private String cpf;
	private String email;
	private String telefone;
	private String cnh;

	private List<PerfilVO> perfis;
	
	public UsuarioMB() {
		
		List<br.com.fiap.sismultas.web.ws.usuario.PerfilVO> perfisWS = 
				ESBFacade.getPerfis();
		
		this.perfis = new ArrayList<PerfilVO>();
		
		for (br.com.fiap.sismultas.web.ws.usuario.PerfilVO perfilWS : perfisWS) {
			PerfilVO perfilVO = new PerfilVO(perfilWS);
			this.perfis.add(perfilVO);
		}
		
	}
	
	public void cadastra() {
		
		try {
			
			PessoaVO pessoaVO = new PessoaVO();
			
			pessoaVO.setNome(this.nome);
			pessoaVO.setSobrenome(this.sobrenome);
			pessoaVO.setNomeUsuario(this.nomeUsuario);
			pessoaVO.setDocumento(this.cpf);
			pessoaVO.setEmail(this.email);
			pessoaVO.setTelefone(this.telefone);
			pessoaVO.setCnh(this.cnh);
			
			boolean perfilSelecionado = Boolean.FALSE;
			
			for (PerfilVO perfilVO : this.perfis) {
				if(perfilVO.isSelected()) {
					
					br.com.fiap.sismultas.web.ws.usuario.PerfilVO pefilVOWS = 
							new br.com.fiap.sismultas.web.ws.usuario.PerfilVO();
					
					pefilVOWS.setId(perfilVO.getId());
					pessoaVO.getPerfis().add(pefilVOWS);
					
					perfilSelecionado = Boolean.TRUE;
					
				}
			}
			
			if (!perfilSelecionado) {
				FacesContext.getCurrentInstance().addMessage(
						null, new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Ao menos um perfil deve ser selecionado.",
								"Ao menos um perfil deve ser selecionado."));
				return;
			}
			
			PessoaVO cadastrado = ESBFacade.cadastraUsuario(pessoaVO);
			
			FacesContext.getCurrentInstance().addMessage(
					null, new FacesMessage(
							FacesMessage.SEVERITY_INFO,
							cadastrado.getMensagem(),
							cadastrado.getMensagem()));
			
		} catch (Exception e) {
			
			FacesContext.getCurrentInstance().addMessage(
					null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Ocorreu um erro. Tente novamente mais tarde.",
							"Ocorreu um erro. Tente novamente mais tarde."));
		}
		
		
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public List<PerfilVO> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<PerfilVO> perfis) {
		this.perfis = perfis;
	}

}

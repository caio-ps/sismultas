package br.com.fiap.sismultas.ws.vo;

/**
 * Value Object: representa uma pessoa
 */
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.sismultas.domain.Perfil;
import br.com.fiap.sismultas.domain.Pessoa;

public class PessoaVO {

	private Boolean sucesso;
	private String mensagem;
	
	private Long id;
	private String nome;
	private String sobrenome;
	private String nomeUsuario;
	private String email;
	private String documento;
	private String telefone;
	private String cnh;

	private List<PerfilVO> perfis;

	public PessoaVO(){
		this.sucesso = Boolean.FALSE;
	}
	
	public PessoaVO(String mensagem){
		this();
		this.mensagem = mensagem;
	}
	
	public PessoaVO(Pessoa pessoa) {
		
		this.sucesso = Boolean.TRUE;
		this.mensagem = "SUCESSO";
		
		this.id = pessoa.getId();
		this.nome = pessoa.getNome();
		this.sobrenome = pessoa.getSobrenome();
		this.nomeUsuario = pessoa.getUsuario();
		this.email = pessoa.getEmail();
		this.documento = pessoa.getCpf();
		this.telefone = pessoa.getTelefone();
		this.cnh = pessoa.getCnh();

		this.perfis = new ArrayList<PerfilVO>();
		
		for (Perfil perfil : pessoa.getPerfils()) {
			
			PerfilVO perfilVO = new PerfilVO(perfil);
			this.perfis.add(perfilVO);
			
		}
		
	}
	
	public boolean valida() {
		
		if (this.nome == null || this.nome.equals("")) {
			return Boolean.FALSE;
		}

		if (this.sobrenome == null || this.sobrenome.equals("")) {
			return Boolean.FALSE;
		}
		
		if (this.nomeUsuario == null || this.nomeUsuario.equals("")) {
			return Boolean.FALSE;
		}
		
		if (this.email == null || this.email.equals("")) {
			return Boolean.FALSE;
		}
		
		if (this.documento == null || this.documento.equals("")) {
			return Boolean.FALSE;
		}
		
		if (this.telefone == null || this.telefone.equals("")) {
			return Boolean.FALSE;
		}
		
		if (this.cnh == null || this.cnh.equals("")) {
			return Boolean.FALSE;
		}
		
		if (this.perfis == null || this.perfis.isEmpty()) {
			return Boolean.FALSE;
		}
		
		return Boolean.TRUE;
		
	}
	
	public Pessoa toEntity() {
		
		Pessoa retorno = new Pessoa();
		
		retorno.setId(this.id);
		retorno.setNome(this.nome);
		retorno.setSobrenome(this.sobrenome);
		retorno.setUsuario(this.nomeUsuario);
		retorno.setEmail(this.email);
		retorno.setCpf(this.documento);
		retorno.setTelefone(this.telefone);
		retorno.setCnh(this.cnh);
		
		if (this.perfis != null && !this.perfis.isEmpty()) {
			
			retorno.setPerfils(new ArrayList<Perfil>());
			
			for (PerfilVO perfilVO : this.perfis) {
				
				Perfil perfil = new Perfil();
				perfil.setId(perfilVO.getId());
				
				retorno.getPerfils().add(perfil);
				
			}
		}
		
		return retorno;
		
	}
	
	public Boolean getSucesso() {
		return sucesso;
	}

	public void setSucesso(Boolean sucesso) {
		this.sucesso = sucesso;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public List<PerfilVO> getPerfis() {
		return perfis;
	}

	public void setPerfis(List<PerfilVO> perfis) {
		this.perfis = perfis;
	}

	public String getCnh() {
		return cnh;
	}

	public void setCnh(String cnh) {
		this.cnh = cnh;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}

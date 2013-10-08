package br.com.fiap.sismultas.core;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import br.com.fiap.sismultas.domain.Pessoa;
import br.com.fiap.sismultas.util.CryptUtil;
import br.com.fiap.sismultas.ws.vo.PessoaVO;

/**
 * Session Bean que representa um usuário
 */
@Stateless
@LocalBean
public class UsuarioBean implements Usuario {

	private static final Logger LOGGER = Logger.getLogger(Usuario.class);

	@Override
	public Pessoa autentica(String usuario, String senha) {

		try {
		
			LOGGER.info("Iniciando processo de autenticacao. Usuario = " + usuario);
			
			//-----------------------------------------------------------------------------------------//
			//------ Verifica se existe o usuário -----------------------------------------------------//
			//-----------------------------------------------------------------------------------------//
			Pessoa pessoa = Pessoa.buscaPorUsuario(usuario);
			
			if (pessoa == null) {
				LOGGER.info("Usuario " + usuario + " não encontrado na base de dados");
				return null;
			}
			
			//-----------------------------------------------------------------------------------------//
			//------ Verifica senha -------------------------------------------------------------------//
			//-----------------------------------------------------------------------------------------//
			
			//Valida com o que está salvo no banco de dados
			if (pessoa.getSenha().equals(senha)) {
				LOGGER.info("Autenticacao realizada com sucesso! Usuario = " + usuario);
				return pessoa;
			}
			
			LOGGER.info("Falha no processo de autenticacao! Senha incorreta. Usuario = " + usuario);
			return null;
			
		} catch (Exception ex) {
			
			LOGGER.error("Ocorreu um erro no processo de autenticação", ex);
			return null;
			
		}
	}

	@Override
	public PessoaVO cadastra(PessoaVO pessoaVO) {
		
		try {
			
			LOGGER.info("Iniciando processo de cadastro de usuário. Usuario = " + pessoaVO.getNomeUsuario());
			
			//-----------------------------------------------------------------------------------------//
			//------ Valida dados obrigatórios --------------------------------------------------------//
			//-----------------------------------------------------------------------------------------//
			if (!pessoaVO.valida()) {
				
				LOGGER.info("Falha no processo de cadastro de usuário. Usuario = " + pessoaVO.getNomeUsuario());
				LOGGER.info("Dados obrigatórios não preenchidos.");
				
				PessoaVO retornoFalha = new PessoaVO("Erro. Dados obrigatórios não enviados.");
				
				return retornoFalha;
				
			}
			
			//-----------------------------------------------------------------------------------------//
			//------ Verifica se já existe o usuário --------------------------------------------------//
			//-----------------------------------------------------------------------------------------//
			Pessoa usuario = Pessoa.buscaPorUsuario(pessoaVO.getNomeUsuario());
			
			if (usuario != null) {
				
				LOGGER.info("Falha no processo de cadastro de usuário. Usuario = " + pessoaVO.getNomeUsuario());
				LOGGER.info("Usuário já existe.");
				
				PessoaVO retornoFalha = new PessoaVO("Usuário já existe.");
				
				return retornoFalha;
				
			}
			
			//-----------------------------------------------------------------------------------------//
			//------ Cria entidade Pessoa e cadastra com senha padrão = nome de usuário ---------------//
			//-----------------------------------------------------------------------------------------//
			Pessoa pessoa = pessoaVO.toEntity();
			pessoa.setSenha(CryptUtil.hashMD5(pessoa.getUsuario()));
			
			//-----------------------------------------------------------------------------------------//
			//------ Persiste no banco de dados -------------------------------------------------------//
			//-----------------------------------------------------------------------------------------//
			pessoa.persist();
			
			LOGGER.info("Usuario cadastrado com sucesso. Usuario = " + pessoa.getUsuario());
			return new PessoaVO(pessoa);
			
		} catch (Exception ex) {
			
			LOGGER.error("Ocorreu um erro no cadastro de usuário", ex);
			return new PessoaVO("Ocorreu um erro no cadastro de usuário: " + ex.getMessage());
			
		}
		
	}

}

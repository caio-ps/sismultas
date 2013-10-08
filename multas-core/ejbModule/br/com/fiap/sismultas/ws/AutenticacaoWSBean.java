package br.com.fiap.sismultas.ws;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import br.com.fiap.sismultas.core.Usuario;
import br.com.fiap.sismultas.domain.Pessoa;
import br.com.fiap.sismultas.ws.vo.PessoaVO;

/**
 * Session Bean que hospeda os serviços relativos ao processamento das multas.
 * 
 * @author caio-pereira
 *
 */
@Stateless
@WebService(serviceName="AutenticacaoWS")
public class AutenticacaoWSBean implements AutenticacaoWS {

	private static final Logger LOGGER = Logger.getLogger(AutenticacaoWS.class);
	
	@EJB
	Usuario usuario;

	@Override
	public PessoaVO autentica(@WebParam(name = "usuario") String usuario,
			@WebParam(name = "senha") String senha) throws Exception {

		try {
			
			LOGGER.info("Recebida solicitação de autenticação.");
			
			//-----------------------------------------------------------------------------------------//
			//------ Autentica o usuário --------------------------------------------------------------//
			//-----------------------------------------------------------------------------------------//
			Pessoa pessoa = this.usuario.autentica(usuario, senha);
			
			//Atenticacao com sucesso
			if (pessoa != null) {
				return new PessoaVO(pessoa);
			} else {
				return new PessoaVO("Erro na autenticacao.");
			}
			
		} catch (Exception ex) {
			LOGGER.error("Ocorreu um erro no serviço de autenticacao.", ex);
			throw ex;
		}
		
	}
		
}

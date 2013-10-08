package br.com.fiap.sismultas.ws;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;

import org.apache.log4j.Logger;

import br.com.fiap.sismultas.core.Usuario;
import br.com.fiap.sismultas.domain.Perfil;
import br.com.fiap.sismultas.ws.vo.PerfilVO;
import br.com.fiap.sismultas.ws.vo.PessoaVO;

/**
 * Session Bean que hospeda os serviços relativos às operações com usuários.
 * 
 * @author caio-pereira
 * 
 */
@Stateless
@WebService(serviceName = "UsuarioWS")
public class UsuarioWSBean implements UsuarioWS {

	private static final Logger LOGGER = Logger.getLogger(UsuarioWS.class);
	
	@EJB
	private Usuario usuario;

	@Override
	public List<PerfilVO> getPerfis() throws Exception {
		
		try {

			LOGGER.info("Recebida solicitação de consulta de perfis.");

			// -----------------------------------------------------------------------------------------//
			// ------ Consulta perfis ------------------------------------------------------------------//
			// -----------------------------------------------------------------------------------------//
			List<Perfil> perfis = Perfil.buscaTodos();
			
			// -----------------------------------------------------------------------------------------//
			// ------ Converte objeto de retorno -------------------------------------------------------//
			// -----------------------------------------------------------------------------------------//
			List<PerfilVO> perfisVO = new ArrayList<PerfilVO>();
			
			for (Perfil perfil : perfis) {
				
				PerfilVO perfilVO = new PerfilVO(perfil);
				perfisVO.add(perfilVO);
				
			}
			
			return perfisVO;
			
		} catch (Exception ex) {
			LOGGER.error("Ocorreu um erro no serviço de consulta de perfis.", ex);
			throw ex;
		}
		
	}

	@Override
	public PessoaVO cadastra(PessoaVO pessoaVO) throws Exception {
		
		try {

			LOGGER.info("Recebida solicitação de cadastro de usuário. Usuario = " + pessoaVO.getNomeUsuario());

			// -----------------------------------------------------------------------------------------//
			// ------ Cadastra usuário -----------------------------------------------------------------//
			// -----------------------------------------------------------------------------------------//
			PessoaVO pessoaRetornoVO = this.usuario.cadastra(pessoaVO);
			
			// -----------------------------------------------------------------------------------------//
			// ------ Retorna objeto atualizado --------------------------------------------------------//
			// -----------------------------------------------------------------------------------------//
			return pessoaRetornoVO;
			
		} catch (Exception ex) {
			LOGGER.error("Ocorreu um erro no serviço de cadastro de usuário.", ex);
			throw ex;
		}
		
	}

}

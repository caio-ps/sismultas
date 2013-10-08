package br.com.fiap.sismultas.ws;

import java.util.List;

import br.com.fiap.sismultas.mule.user.ws.PerfilVO;
import br.com.fiap.sismultas.mule.user.ws.PessoaVO;
import br.com.fiap.sismultas.mule.user.ws.UsuarioWS;
import br.com.fiap.sismultas.mule.user.ws.UsuarioWSBean;

public class UsuarioService implements Usuario {

	@Override
	public List<PerfilVO> getPerfis() throws Exception {

		UsuarioWSBean usuarioWS = (new UsuarioWS()).getUsuarioWSBeanPort();
		List<PerfilVO> perfis = usuarioWS.getPerfis();
		
		return perfis;
		
	}

	@Override
	public PessoaVO cadastra(PessoaVO pessoaVO) throws Exception {
		
		UsuarioWSBean usuarioWS = (new UsuarioWS()).getUsuarioWSBeanPort();
		PessoaVO pessoaRetornoVO = usuarioWS.cadastra(pessoaVO);
		
		return pessoaRetornoVO;
		
	}

}

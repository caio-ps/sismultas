package br.com.fiap.sismultas.ws;

import br.com.fiap.sismultas.mule.auth.ws.AutenticacaoWS;
import br.com.fiap.sismultas.mule.auth.ws.AutenticacaoWSBean;
import br.com.fiap.sismultas.mule.auth.ws.PessoaVO;

public class AutenticaService implements Autentica {

	@Override
	public PessoaVO autentica(String usuario, String senha) throws Exception {
		
		AutenticacaoWSBean autenticacaoWS = (new AutenticacaoWS()).getAutenticacaoWSBeanPort();
		PessoaVO pessoaVO = autenticacaoWS.autentica(usuario, senha);
		
		return pessoaVO;
		
	}

	

}

package br.com.fiap.sismultas.init;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fiap.sismultas.domain.InfracaoGravidade;
import br.com.fiap.sismultas.domain.ItemCtb;
import br.com.fiap.sismultas.domain.ItemCtbPK;
import br.com.fiap.sismultas.domain.Perfil;
import br.com.fiap.sismultas.domain.Pessoa;
import br.com.fiap.sismultas.domain.StatusNotificacao;
import br.com.fiap.sismultas.domain.Veiculo;
import br.com.fiap.sismultas.domain.VeiculoModelo;
import br.com.fiap.sismultas.util.CryptUtil;

/**
 * Session Bean utilizado para realizar a carga inicial dos dados do sistema
 * no banco de dados.
 * 
 * @author caio-pereira
 *
 */
@Stateless
@WebService(serviceName="CargaInicial")
public class CargaInicialBean implements CargaInicial {

	@PersistenceContext(name="sis-multas-PU")
	EntityManager entityManager;
	
	@Resource
	EJBContext ejbContext;
	
	@Override
	@WebMethod(operationName="executaCargaInicial")
	public String executaCargaInicial() {

		try {
		
			//Pessoas e perfis
			Map<String, Perfil> perfis = this.carregaPerfis();
			Pessoa condutor = this.carregaPessoas(perfis);
			
			//Veículos
			this.carregaVeiculo(condutor);
			
			//Infrações
			this.carregaInfracoes();
			
			//tabela de domínio
			this.carregaStatus();
			
			return "OK";
			
		} catch (Exception e) {
			e.printStackTrace();
			ejbContext.setRollbackOnly();
			return "NOK";
		}
				
	}
	
	/**
	 * Carrega os perfis de acesso (roles)
	 */
	private Map<String, Perfil> carregaPerfis() {
		
		Perfil perfil = new Perfil();
		perfil.setDescricao("administrador");
		
		Perfil perfil1 = new Perfil();
		perfil1.setDescricao("funcionario");
		
		Perfil perfil2 = new Perfil();
		perfil2.setDescricao("fiscal");
		
		Perfil perfil3 = new Perfil();
		perfil3.setDescricao("condutor");
		
		entityManager.persist(perfil);
		entityManager.persist(perfil1);
		entityManager.persist(perfil2);
		entityManager.persist(perfil3);
		
		Map<String, Perfil> mapPerfis = new HashMap<String, Perfil>();
		
		mapPerfis.put("administrador", perfil);
		mapPerfis.put("funcionario", perfil1);
		mapPerfis.put("fiscal", perfil2);
		mapPerfis.put("condutor", perfil3);
		
		return mapPerfis;
		
	}
	
	/**
	 * Carrega pessoas com diferentes perfis
	 * @throws NoSuchAlgorithmException 
	 */
	private Pessoa carregaPessoas(Map<String, Perfil> perfis) throws Exception {
		
		//Administrador do sistema.
		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Administrador");
		pessoa.setSobrenome("do Sistema");
		pessoa.setUsuario("administrador");
		pessoa.setSenha(CryptUtil.hashMD5("administrador"));
		pessoa.setEmail("administrador@sismultas.com");
		pessoa.setTelefone("55 11 2222-3333");
		List<Perfil> perfilPessoa = new ArrayList<Perfil>();
		perfilPessoa.add(perfis.get("administrador"));
		pessoa.setPerfils(perfilPessoa);
		
		//Funcionário do DETRAN.
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("José");
		pessoa1.setSobrenome("Pereira dos Santos");
		pessoa1.setUsuario("jose.pdossantos");
		pessoa1.setSenha(CryptUtil.hashMD5("funcionario"));
		pessoa1.setCpf("44287561945");
		pessoa1.setEmail("jose.pdossantos@sismultas.com");
		pessoa1.setTelefone("55 11 2222-3334");
		List<Perfil> perfilPessoa1 = new ArrayList<Perfil>();
		perfilPessoa1.add(perfis.get("funcionario"));
		pessoa1.setPerfils(perfilPessoa1);
		
		//Fiscal de Trânsito
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("João");
		pessoa2.setSobrenome("de Oliveira");
		pessoa2.setUsuario("joao.oliveira");
		pessoa2.setSenha(CryptUtil.hashMD5("fiscal"));
		pessoa2.setCpf("65783708623");
		pessoa2.setEmail("joao.oliveira@sismultas.com");
		pessoa2.setTelefone("55 11 9222-3335");
		List<Perfil> perfilPessoa2 = new ArrayList<Perfil>();
		perfilPessoa2.add(perfis.get("fiscal"));
		pessoa2.setPerfils(perfilPessoa2);
		
		//Condutor
		Pessoa pessoa3 = new Pessoa();
		pessoa3.setNome("Caio");
		pessoa3.setSobrenome("Pereira de Sousa");
		pessoa3.setUsuario("caio.psw");
		pessoa3.setSenha(CryptUtil.hashMD5("caiofiap"));
		pessoa3.setCpf("55523902705");
		pessoa3.setEmail("caio.psw@gmail.com");
		pessoa3.setTelefone("55 11 9123-3535");
		pessoa3.setCnh("1234567890");
		List<Perfil> perfilPessoa3 = new ArrayList<Perfil>();
		perfilPessoa3.add(perfis.get("condutor"));
		pessoa3.setPerfils(perfilPessoa3);
		
		entityManager.persist(pessoa);
		entityManager.persist(pessoa1);
		entityManager.persist(pessoa2);
		entityManager.persist(pessoa3);
		
		return pessoa3;
		
	}
	
	/**
	 * Carrega um veículo para o condutor cadastrado
	 */
	private void carregaVeiculo(Pessoa condutor) {
		
		VeiculoModelo modelo = new VeiculoModelo();
		modelo.setDescricao("GOL CITY 1.0");
		modelo.setMontadora("Volkswagen");
		modelo.setAno(2012);

		entityManager.persist(modelo);
		
		Veiculo veiculo = new Veiculo();
		veiculo.setChassi("9BWZZZ377ST000011");
		veiculo.setPlaca("ABC-1234");
		veiculo.setCor("PRETA");
		veiculo.setVeiculoModelo(modelo);
		veiculo.setPessoa(condutor);
		
		entityManager.persist(veiculo);
		
	}
	
	/**
	 * Carrega infrações de trânsito
	 */
	private void carregaInfracoes() {

		InfracaoGravidade leve = new InfracaoGravidade();
		leve.setDescricao("LEVE");
		leve.setPontos(3);
		
		InfracaoGravidade media = new InfracaoGravidade();
		media.setDescricao("MÉDIA");
		media.setPontos(4);
		
		InfracaoGravidade grave = new InfracaoGravidade();
		grave.setDescricao("GRAVE");
		grave.setPontos(5);
		
		InfracaoGravidade gravissima = new InfracaoGravidade();
		gravissima.setDescricao("GRAVÍSSIMA");
		gravissima.setPontos(7);
		
		entityManager.persist(leve);
		entityManager.persist(media);
		entityManager.persist(grave);
		entityManager.persist(gravissima);
		
		ItemCtb ctbLeve = new ItemCtb();
		ItemCtbPK pkLeve = new ItemCtbPK();
		pkLeve.setCodigoInfracao("520-7");
		pkLeve.setDesdobramento(0);
		ctbLeve.setPk(pkLeve);
		ctbLeve.setArtigo(169);
		ctbLeve.setParagrafo(1);
		ctbLeve.setDescricaoResumida("Dirigir sem atenção ou sem os cuidados indispensáveis à segurança");
		ctbLeve.setInfracaoGravidade(leve);
		ctbLeve.setValorMulta(53.2);
		
		ItemCtb ctbMedio = new ItemCtb();
		ItemCtbPK pkMedio = new ItemCtbPK();
		pkMedio.setCodigoInfracao("736-6");
		pkMedio.setDesdobramento(2);
		ctbMedio.setPk(pkMedio);
		ctbMedio.setArtigo(252);
		ctbMedio.setParagrafo(6);
		ctbMedio.setDescricaoResumida("Dirigir veículo utilizando-se de telefone celular");
		ctbMedio.setInfracaoGravidade(media);
		ctbMedio.setValorMulta(85.13);
		
		ItemCtb ctbGrave = new ItemCtb();
		ItemCtbPK pkGrave = new ItemCtbPK();
		pkGrave.setCodigoInfracao("518-5");
		pkGrave.setDesdobramento(1);
		ctbGrave.setPk(pkGrave);
		ctbGrave.setArtigo(167);
		ctbGrave.setParagrafo(1);
		ctbGrave.setDescricaoResumida("Deixar o condutor de usar o cinto segurança");
		ctbGrave.setInfracaoGravidade(grave);
		ctbGrave.setValorMulta(127.69);
		
		ItemCtb ctbGravissimo = new ItemCtb();
		ItemCtbPK pkGravissimo = new ItemCtbPK();
		pkGravissimo.setCodigoInfracao("524-0");
		pkGravissimo.setDesdobramento(0);
		ctbGravissimo.setPk(pkGravissimo);
		ctbGravissimo.setArtigo(173);
		ctbGravissimo.setParagrafo(1);
		ctbGravissimo.setDescricaoResumida("Disputar corrida por espírito de emulação");
		ctbGravissimo.setInfracaoGravidade(gravissima);
		ctbGravissimo.setValorMulta(191.54);
		
		entityManager.persist(ctbLeve);
		entityManager.persist(ctbMedio);
		entityManager.persist(ctbGrave);
		entityManager.persist(ctbGravissimo);
		
	}
	
	/**
	 * Carrega tabela de domínio de status das multas
	 */
	private void carregaStatus() {

		StatusNotificacao status = new StatusNotificacao();
		status.setDescricao("Emitida.");
		
		StatusNotificacao status2 = new StatusNotificacao();
		status2.setDescricao("Enviada por e-mail.");
		
		StatusNotificacao status3 = new StatusNotificacao();
		status3.setDescricao("Erro no processamento.");
		
		StatusNotificacao status4 = new StatusNotificacao();
		status4.setDescricao("Erro no envio.");
		
		entityManager.persist(status);
		entityManager.persist(status2);
		entityManager.persist(status3);
		entityManager.persist(status4);
		
	}
		
}

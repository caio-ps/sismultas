package br.com.fiap.sismultas.web.facade;

import java.util.List;

import org.jboss.logging.Logger;

import br.com.fiap.sismultas.web.ws.autentica.Autentica;
import br.com.fiap.sismultas.web.ws.autentica.AutenticaService;
import br.com.fiap.sismultas.web.ws.autentica.PessoaVO;
import br.com.fiap.sismultas.web.ws.consulta.ConsultaMultas;
import br.com.fiap.sismultas.web.ws.consulta.ConsultaMultasService;
import br.com.fiap.sismultas.web.ws.consulta.InfracaoVO;
import br.com.fiap.sismultas.web.ws.consulta.MultaVO;
import br.com.fiap.sismultas.web.ws.ctb.Ctb;
import br.com.fiap.sismultas.web.ws.ctb.CtbService;
import br.com.fiap.sismultas.web.ws.ctb.GravidadeInfracaoVO;
import br.com.fiap.sismultas.web.ws.ctb.ItemCTBVO;
import br.com.fiap.sismultas.web.ws.email.EnviaEmailNotificacao;
import br.com.fiap.sismultas.web.ws.email.EnviaEmailNotificacaoService;
import br.com.fiap.sismultas.web.ws.email.RelatorioVO;
import br.com.fiap.sismultas.web.ws.relatorio.EmiteRelatorio;
import br.com.fiap.sismultas.web.ws.relatorio.EmiteRelatorioService;
import br.com.fiap.sismultas.web.ws.usuario.PerfilVO;
import br.com.fiap.sismultas.web.ws.usuario.Usuario;
import br.com.fiap.sismultas.web.ws.usuario.UsuarioService;
import br.com.fiap.sismultas.web.ws.veiculo.ModeloVO;
import br.com.fiap.sismultas.web.ws.veiculo.Veiculo;
import br.com.fiap.sismultas.web.ws.veiculo.VeiculoService;
import br.com.fiap.sismultas.web.ws.veiculo.VeiculoVO;

public class ESBFacade {

	private static final Logger LOGGER = Logger.getLogger(ESBFacade.class);
	
	/** Serviço de autenticacao */
	private static Autentica autenticaService;
	/** Serviço de operações dos usuários */
	private static Usuario usuarioService;
	/** Serviço de operações dos veículos */
	private static Veiculo veiculoService;
	/** Serviço de operações dos itens do CTB */
	private static Ctb ctbService;
	/** Serviço de consulta de infrações */
	private static ConsultaMultas consultaMultasService;
	/** Serviço de envio de notificacao por e-mail */
	private static EnviaEmailNotificacao enviaEmailNotificacaoService;
	/** Serviço de emissão de relatorios */
	private static EmiteRelatorio emiteRelatorioService;
	
	//Inicialização
	static {
		
		ESBFacade.autenticaService = (new AutenticaService()).getAutenticaPort();
		ESBFacade.usuarioService = (new UsuarioService()).getUsuarioPort(); 
		ESBFacade.veiculoService = (new VeiculoService()).getVeiculoPort();
		ESBFacade.ctbService = (new CtbService()).getCtbPort();
		ESBFacade.consultaMultasService = (new ConsultaMultasService()).getConsultaMultasPort();
		ESBFacade.enviaEmailNotificacaoService = (new EnviaEmailNotificacaoService()).getEnviaEmailNotificacaoPort();
		ESBFacade.emiteRelatorioService = (new EmiteRelatorioService()).getEmiteRelatorioPort();
		
	}
	
	
	/**
	 * Chamada ao serviço do ESB de autenticação
	 * 
	 * @param usuario
	 * @param senha
	 * @return
	 */
	public static PessoaVO login(String usuario, String senhaMD5) {
		
		try {
			return ESBFacade.autenticaService.autentica(usuario, senhaMD5);
		} catch (Exception ex) {
			LOGGER.error(ex,ex);
			return null;
		}
		
	}
	
	/**
	 * Chamada ao serviço ESB para obter os perfis de usuário do sistema
	 * 
	 * @return
	 */
	public static List<PerfilVO> getPerfis() {
		
		try {
			return ESBFacade.usuarioService.getPerfis();
		} catch (Exception ex) {
			LOGGER.error(ex,ex);
			return null;
		}
		
	}
	
	/**
	 * Chamada ao serviço de cadastro de usuário
	 * 
	 * @param pessoaVO
	 * @return
	 */
	public static br.com.fiap.sismultas.web.ws.usuario.PessoaVO cadastraUsuario(br.com.fiap.sismultas.web.ws.usuario.PessoaVO pessoaVO) {
		try {
			return ESBFacade.usuarioService.cadastra(pessoaVO);
		} catch (Exception ex) {
			LOGGER.error(ex,ex);
			return null;
		}
	}
	
	/**
	 * Chamada ao serviço ESB para obter os modelos de veículos cadastrados
	 * 
	 * @return
	 */
	public static List<ModeloVO> getModelosVeiculos() {
		
		try {
			return ESBFacade.veiculoService.getModelos();
		} catch (Exception ex) {
			LOGGER.error(ex,ex);
			return null;
		}
		
	}
	
	/**
	 * Chamada ao serviço de cadastro de veículo
	 * 
	 * @param pessoaVO
	 * @return
	 */
	public static VeiculoVO cadastraVeiculo(VeiculoVO veiculoVO) {
		try {
			return ESBFacade.veiculoService.cadastra(veiculoVO);
		} catch (Exception ex) {
			LOGGER.error(ex,ex);
			return null;
		}
	}
	
	/**
	 * Chamada ao serviço ESB para obter as gravidades possíveis das multas
	 * 
	 * @return
	 */
	public static List<GravidadeInfracaoVO> getGravidadesInfracoes() {
		
		try {
			return ESBFacade.ctbService.getGravidades();
		} catch (Exception ex) {
			LOGGER.error(ex,ex);
			return null;
		}
		
	}
	
	/**
	 * Chamada ao serviço de cadastro de item do CTB
	 * 
	 * @param pessoaVO
	 * @return
	 */
	public static ItemCTBVO cadastraItemCtb(ItemCTBVO itemCTBVO) {
		try {
			return ESBFacade.ctbService.cadastraItemCtb(itemCTBVO);
		} catch (Exception ex) {
			LOGGER.error(ex,ex);
			return null;
		}
	}
	
	/**
	 * Chamada ao serviço ESB para consulta de infrações
	 * 
	 * @return
	 */
	public static List<InfracaoVO> getInfracoes(MultaVO multaVO) {
		
		try {
			return ESBFacade.consultaMultasService.getMultas(multaVO);
		} catch (Exception ex) {
			LOGGER.error(ex,ex);
			return null;
		}
		
	}
	
	/**
	 * Serviço para envio de notificações por e-mail
	 * 
	 * @param relatorioVO
	 * @throws Exception
	 */
	public static void enviaEmailNotificacao(RelatorioVO relatorioVO) throws Exception {
		
		try {
			ESBFacade.enviaEmailNotificacaoService.enviaEmailNotificacao(relatorioVO);
		} catch (Exception ex) {
			LOGGER.error(ex,ex);
			throw ex;
		}
		
	}
	
	/**
	 * Serviço para emissão de relatórios
	 * 
	 * @param relatorioVO
	 * @throws Exception
	 */
	public static br.com.fiap.sismultas.web.ws.relatorio.RelatorioVO emiteRelatorio(br.com.fiap.sismultas.web.ws.relatorio.MultaVO filtro)
			throws Exception {
		
		try {
			return ESBFacade.emiteRelatorioService.emiteRelatorio(filtro);
		} catch (Exception ex) {
			LOGGER.error(ex,ex);
			throw ex;
		}
		
	}
	
}

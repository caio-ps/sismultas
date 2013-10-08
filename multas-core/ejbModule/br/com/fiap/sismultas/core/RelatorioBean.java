package br.com.fiap.sismultas.core;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import org.apache.log4j.Logger;

import br.com.fiap.sismultas.domain.CobrancaReceber;
import br.com.fiap.sismultas.domain.Infracao;
import br.com.fiap.sismultas.domain.Notificacao;
import br.com.fiap.sismultas.enumeration.TipoRelatorioEnum;
import br.com.fiap.sismultas.util.PropertiesUtil;
import br.com.fiap.sismultas.util.ReportUtil;
import br.com.fiap.sismultas.util.XMLUtil;
import br.com.fiap.sismultas.ws.vo.EmailVO;
import br.com.fiap.sismultas.ws.vo.RelatorioVO;
import br.com.fiap.sismultas.xml.NotificacaoXML;
import br.com.fiap.sismultas.xml.RelatorioMultaXML;

/**
 * Session Bean que representa um relatorio
 */
@Stateless
public class RelatorioBean implements Relatorio {

	private static final Logger LOGGER = Logger.getLogger(Relatorio.class);
	
	@EJB
	Email email;
	
	@Override
	public RelatorioVO geraRelatorio(TipoRelatorioEnum tipoRelatorio, Map<String, Object> parametros) {
		
		LOGGER.info("Iniciando geracao de relatorio. Tipo = " + tipoRelatorio.getDescricao());
		
		//Objeto de retorno
		RelatorioVO relatorioVO = null;
		
		//-----------------------------------------------------------------------------------------//
		//------ Gera relatorio de acordo com o tipo informado ------------------------------------//
		//-----------------------------------------------------------------------------------------//
		if (TipoRelatorioEnum.NOTIFICACAO.getDescricao().equals(tipoRelatorio.getDescricao())) {
			relatorioVO = this.geraArquivoNotificacao(parametros);
		} else if (TipoRelatorioEnum.RELATORIO_FISCAL.getDescricao().equals(tipoRelatorio.getDescricao())){
			relatorioVO = this.geraRelatorioInfracao(parametros, tipoRelatorio);
		} else if (TipoRelatorioEnum.RELATORIO_VEICULO.getDescricao().equals(tipoRelatorio.getDescricao())){
			relatorioVO = this.geraRelatorioInfracao(parametros, tipoRelatorio);
		}
		
		return relatorioVO;
		
	}

	/**
	 * Gera relatorio de notificacao de infracao.
	 * 
	 * @param parametros
	 * @return
	 */
	private RelatorioVO geraArquivoNotificacao(Map<String, Object> parametros) {
		
		//-----------------------------------------------------------------------------------------//
		//------ Recupera notificacao pelo ID -----------------------------------------------------//
		//-----------------------------------------------------------------------------------------//
		Long idNotificacao = (Long) parametros.get("idNotificacao");
		
		LOGGER.info("Gerando relatorio de notificacao de multa. Notificacao id = " + idNotificacao);
		
		Notificacao notificacao = Notificacao.find(idNotificacao);
		
		//-----------------------------------------------------------------------------------------//
		//------ Cria XML para geracao do relatorio -----------------------------------------------//
		//-----------------------------------------------------------------------------------------//
		String[][] aliases = 
			{
				{"notificacao", "br.com.fiap.sismultas.xml.NotificacaoXML"},
				{"condutor", 	"br.com.fiap.sismultas.xml.CondutorXML"},
				{"veiculo", 	"br.com.fiap.sismultas.xml.VeiculoXML"},
				{"infracao", 	"br.com.fiap.sismultas.xml.InfracaoXML"},
				{"cobranca",	"br.com.fiap.sismultas.xml.CobrancaXML"}
			};
		
		NotificacaoXML objXml = new NotificacaoXML(notificacao);
		String xml = XMLUtil.marshall(objXml, aliases);
		
		//-----------------------------------------------------------------------------------------//
		//------ Recupera propriedades do sistema -------------------------------------------------//
		//-----------------------------------------------------------------------------------------//
		
		//arquivo jasper
		String pathJasper =
				PropertiesUtil.readProperty(PropertiesUtil.STORAGE_JASPER) +
				File.separator + 
				PropertiesUtil.readProperty(PropertiesUtil.JASPER_MULTA_NOTIFICACAO);
		
		//xpath do relatorio
		String xpath = PropertiesUtil.readProperty(PropertiesUtil.JASPER_MULTA_NOTIFICACAO_XPATH);
		
		//caminho de saída para salvar o arquivo
		String outputFolder =
				PropertiesUtil.readProperty(PropertiesUtil.JASPER_MULTA_NOTIFICACAO_OUTPUTFOLDER) + 
				File.separator + notificacao.getInfracao().getVeiculo().getChassi();				
		
		File outputFolderFile = new File(outputFolder);
		if (!outputFolderFile.exists()) {
			outputFolderFile.mkdirs();
		}
		
		//nome do arquivo
		String nomeArquivo = 
				PropertiesUtil.readProperty(PropertiesUtil.JASPER_MULTA_NOTIFICACAO_FILENAME) + 
				notificacao.getCobrancaRecebers().get(notificacao.getCobrancaRecebers().size() - 1).getId() +
				PropertiesUtil.readProperty(PropertiesUtil.JASPER_MULTA_NOTIFICACAO_EXTENSAO);
		
		//-----------------------------------------------------------------------------------------//
		//------ Gera arquivo do relatorio --------------------------------------------------------//
		//-----------------------------------------------------------------------------------------//
		ReportUtil.gerarRelatorioPDF(xml, pathJasper, xpath, outputFolder, nomeArquivo);
		
		//-----------------------------------------------------------------------------------------//
		//------ Registra caminho do arquivo na tabela de cobranca --------------------------------//
		//-----------------------------------------------------------------------------------------//
		CobrancaReceber cobranca = 
				notificacao.getCobrancaRecebers().get(notificacao.getCobrancaRecebers().size() - 1);
		cobranca.setCaminhoArquivo(outputFolder + File.separator + nomeArquivo);
		
		cobranca.update();
		
		//Objeto de retorno
		RelatorioVO relatorioVO = new RelatorioVO();
		relatorioVO.setId(idNotificacao);
		relatorioVO.setCaminhoArquivo(outputFolder + File.separator + nomeArquivo);
		relatorioVO.setTipoRelatorio(TipoRelatorioEnum.NOTIFICACAO.getDescricao());
		
		return relatorioVO;
		
	}
	
	/**
	 * Gera relatorio de notificacao de infracao.
	 * 
	 * @param parametros
	 * @return
	 */
	@SuppressWarnings("unchecked")
	private RelatorioVO geraRelatorioInfracao(Map<String, Object> parametros, TipoRelatorioEnum tipoRelatorioEnum) {
		
		//-----------------------------------------------------------------------------------------//
		//------ Recupera lista de infracoes ------------------------------------------------------//
		//-----------------------------------------------------------------------------------------//
		List<Infracao> listaInfracao = (List<Infracao>) parametros.get("listaInfracao");
		
		LOGGER.info("Gerando relatorio de multas.");
		
		//-----------------------------------------------------------------------------------------//
		//------ Cria XML para geracao do relatorio -----------------------------------------------//
		//-----------------------------------------------------------------------------------------//
		String[][] aliases = 
			{
				{"relatorio", 	"br.com.fiap.sismultas.xml.RelatorioMultaXML"},
				{"multa", 		"br.com.fiap.sismultas.xml.MultaXML"}
			};
		
		RelatorioMultaXML objXml = new RelatorioMultaXML((String)parametros.get("valor"), listaInfracao, tipoRelatorioEnum);
		String xml = XMLUtil.marshall(objXml, aliases);
		
		//-----------------------------------------------------------------------------------------//
		//------ Recupera propriedades do sistema -------------------------------------------------//
		//-----------------------------------------------------------------------------------------//
		
		SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyykkmmss");
		
		//arquivo jasper
		String pathJasper =
				PropertiesUtil.readProperty(PropertiesUtil.STORAGE_JASPER) +
				File.separator + 
				PropertiesUtil.readProperty(PropertiesUtil.JASPER_MULTA_RELATORIO);
		
		//xpath do relatorio
		String xpath = PropertiesUtil.readProperty(PropertiesUtil.JASPER_MULTA_RELATORIO_XPATH);
		
		//caminho de saída para salvar o arquivo
		String outputFolder =
				PropertiesUtil.readProperty(PropertiesUtil.JASPER_MULTA_RELATORIO_OUTPUTFOLDER);				
		
		File outputFolderFile = new File(outputFolder);
		if (!outputFolderFile.exists()) {
			outputFolderFile.mkdirs();
		}
		
		//nome do arquivo
		String nomeArquivo = 
				PropertiesUtil.readProperty(PropertiesUtil.JASPER_MULTA_RELATORIO_FILENAME) + 
				sdf.format(new Date()) +
				PropertiesUtil.readProperty(PropertiesUtil.JASPER_MULTA_RELATORIO_EXTENSAO);
		
		//-----------------------------------------------------------------------------------------//
		//------ Gera arquivo do relatorio --------------------------------------------------------//
		//-----------------------------------------------------------------------------------------//
		ReportUtil.gerarRelatorioPDF(xml, pathJasper, xpath, outputFolder, nomeArquivo);
		
		//Objeto de retorno
		RelatorioVO relatorioVO = new RelatorioVO();
		relatorioVO.setCaminhoArquivo(outputFolder + File.separator + nomeArquivo);
		relatorioVO.setTipoRelatorio(tipoRelatorioEnum.getDescricao());
		
		return relatorioVO;
		
	}

	@Override
	public boolean enviaPorEmail(RelatorioVO relatorioVO) {
		
		LOGGER.info("Enviando relatorio por e-mail = " + relatorioVO.getCaminhoArquivo());
		
		//-----------------------------------------------------------------------------------------//
		//------ Busca notificacao correspondente ao arquivo --------------------------------------//
		//-----------------------------------------------------------------------------------------//
		Notificacao notificacao = Notificacao.find(relatorioVO.getId());
		
		//-----------------------------------------------------------------------------------------//
		//------ Cria objeto de envio de e-mail ---------------------------------------------------//
		//-----------------------------------------------------------------------------------------//
		String assuntoEmail = PropertiesUtil.readProperty(PropertiesUtil.EMAIL_ASSUNTO);
		String mensagemEmail = PropertiesUtil.readProperty(PropertiesUtil.EMAIL_MENSAGEM);
		
		String[] anexos = {relatorioVO.getCaminhoArquivo()};
		
		EmailVO emailVO = new EmailVO(
				notificacao.getInfracao().getVeiculo().getPessoa().getEmail(),
				assuntoEmail,
				mensagemEmail,
				anexos);
				
		//-----------------------------------------------------------------------------------------//
		//------ Envia e-mail ---------------------------------------------------------------------//
		//-----------------------------------------------------------------------------------------//
		return this.email.envia(emailVO);
		 
	}
	

}

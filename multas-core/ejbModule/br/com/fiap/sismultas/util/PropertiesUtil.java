package br.com.fiap.sismultas.util;

import java.io.InputStream;
import java.util.Properties;

/**
 * Classe utilitaria para acessar os arquivos de propriedades do sistema.
 * 
 * @author caio-pereira
 *
 */
public class PropertiesUtil {

	/** Constantes auxiliares com as principais propriedades */
	public static final String STORAGE_JASPER = "storage.jasper";
	
	public static final String JASPER_MULTA_NOTIFICACAO = "jasper.multa_notificacao";
	public static final String JASPER_MULTA_NOTIFICACAO_XPATH = "jasper.multa_notificacao.xpath";
	public static final String JASPER_MULTA_NOTIFICACAO_OUTPUTFOLDER = "jasper.multa_notificacao.outputfolder";
	public static final String JASPER_MULTA_NOTIFICACAO_FILENAME = "jasper.multa_notificacao.filename";
	public static final String JASPER_MULTA_NOTIFICACAO_EXTENSAO = "jasper.multa_notificacao.extensao";
	
	public static final String JASPER_MULTA_RELATORIO = "jasper.multa_relatorio";
	public static final String JASPER_MULTA_RELATORIO_XPATH = "jasper.multa_relatorio.xpath";
	public static final String JASPER_MULTA_RELATORIO_OUTPUTFOLDER = "jasper.multa_relatorio.outputfolder";
	public static final String JASPER_MULTA_RELATORIO_FILENAME = "jasper.multa_relatorio.filename";
	public static final String JASPER_MULTA_RELATORIO_EXTENSAO = "jasper.multa_relatorio.extensao";

	public static final String EMAIL_REMETENTE = "email.remetente";
	public static final String EMAIL_ASSUNTO = "email.assunto";
	public static final String EMAIL_MENSAGEM = "email.mensagem";
	
	//Arquivo sismultas.properties
	private static Properties properties;
	
	static {
		
		try {
		
			//Acesso ao arquivo de propriedades
			InputStream is = PropertiesUtil.class.getResourceAsStream("/properties/sismultas.properties");
		
			//Carrega as propriedades na memória
			properties = new Properties();
			properties.load(is);
			
		} catch (Exception ex) {
			System.err.println("Erro ao carregar as propriedades do sistema");
		}
		
	}
	
	public static String readProperty(String key) {
		
		return properties.getProperty(key);
		
	}

}

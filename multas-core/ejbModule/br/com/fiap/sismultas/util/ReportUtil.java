package br.com.fiap.sismultas.util;

import java.io.ByteArrayInputStream;
import java.io.File;

import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;

/**
 * Classe utilitaria para geração de relatorios
 * @author caio-pereira
 *
 */
public class ReportUtil {

	public static String gerarRelatorioPDF(String xml, String caminhoJasper, String caminhoXPath,
			String outputFolder, String nomeArquivo) {
		
		ByteArrayInputStream bais = new ByteArrayInputStream(xml.getBytes());
		
		String nomeArquivoSaida = outputFolder + File.separator + nomeArquivo;
		
		JRExporter exporter = null;
		try {
			
			JRXmlDataSource jrxmlds = new JRXmlDataSource(bais, caminhoXPath);
			JasperPrint print = JasperFillManager.fillReport(caminhoJasper, null, jrxmlds);

			exporter = new JRPdfExporter();
			
			exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, nomeArquivoSaida);
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.exportReport();
			
		} catch (Exception e) {		
		}
		
		return nomeArquivoSaida;
	}
	
}

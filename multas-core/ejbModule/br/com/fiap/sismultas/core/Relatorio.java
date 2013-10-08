package br.com.fiap.sismultas.core;

import java.util.Map;

import javax.ejb.Local;

import br.com.fiap.sismultas.enumeration.TipoRelatorioEnum;
import br.com.fiap.sismultas.ws.vo.RelatorioVO;

@Local
public interface Relatorio {
	
	/**
	 * Método para geração de relatorios
	 * 
	 * @param tipoRelatorio
	 * @param parametros
	 * @return
	 */
	RelatorioVO geraRelatorio(TipoRelatorioEnum tipoRelatorio, Map<String, Object> parametros);
	
	/**
	 * Envia um relatorio por e-mail
	 * 
	 * @param relatorioVO
	 */
	boolean enviaPorEmail(RelatorioVO relatorioVO);

}

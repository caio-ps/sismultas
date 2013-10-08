package br.com.fiap.sismultas.ws;

import java.util.List;

import javax.ejb.Remote;

import br.com.fiap.sismultas.ws.vo.ModeloVO;
import br.com.fiap.sismultas.ws.vo.VeiculoVO;

@Remote
public interface VeiculoWS {

	/**
	 * Método que retorna todos os modelos de veículo disponíveis
	 * 
	 * @return
	 * @throws Exception
	 */
	List<ModeloVO> getModelos() throws Exception;
	
	/**
	 * Método que cadastra um novo veículo
	 * 
	 * @param veiculoVO
	 * @return
	 * @throws Exception
	 */
	VeiculoVO cadastra(VeiculoVO veiculoVO) throws Exception;
	
}

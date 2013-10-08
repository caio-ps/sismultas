package br.com.fiap.sismultas.core;

import javax.ejb.Local;

import br.com.fiap.sismultas.ws.vo.VeiculoVO;


@Local
public interface Veiculo {

	/**
	 * Cadastro de veículo
	 * 
	 * @param veiculoVO
	 * @return
	 */
	VeiculoVO cadastra(VeiculoVO veiculoVO);
	
}

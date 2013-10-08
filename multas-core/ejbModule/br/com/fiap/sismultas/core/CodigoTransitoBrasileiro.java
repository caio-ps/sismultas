package br.com.fiap.sismultas.core;

import javax.ejb.Local;

import br.com.fiap.sismultas.ws.vo.ItemCTBVO;


@Local
public interface CodigoTransitoBrasileiro {

	/**
	 * Cadastro de item ctb
	 * 
	 * @param itemCTBVO
	 * @return
	 */
	ItemCTBVO cadastraItemCTB(ItemCTBVO itemCTBVO);
	
}

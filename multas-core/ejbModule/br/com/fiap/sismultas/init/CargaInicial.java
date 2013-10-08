package br.com.fiap.sismultas.init;

import javax.ejb.Remote;

@Remote
public interface CargaInicial {

	String executaCargaInicial();
	
}

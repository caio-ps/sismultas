package br.com.fiap.sismultas.mobile;

import java.util.Hashtable;

import org.ksoap2.serialization.KvmSerializable;
import org.ksoap2.serialization.PropertyInfo;

public class MultaWSObject implements KvmSerializable {

	private String cepLocalOcorrencia;
	private String codigoInfracaoCtb;
	private String dataOcorrencia;
	private String desdobramentoCtb;
	private String idFiscal;
	private String placaVeiculo;
	
	@Override
	public Object getProperty(int arg0) {
		
		switch (arg0) {
	        case 0:
	            return cepLocalOcorrencia;
	        case 1:
	            return codigoInfracaoCtb;
	        case 2:
	            return dataOcorrencia;
	        case 3:
	            return desdobramentoCtb;
	        case 4:
	            return idFiscal;
	        case 5:
	            return placaVeiculo;
	    }

		return null;
	}

	@Override
	public int getPropertyCount() {
		return 6;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void getPropertyInfo(int arg0, Hashtable arg1, PropertyInfo arg2) {
		
		String name = null;
        Class<?> type = null;
 
        switch (arg0) {
	        case 0:
	            type = String.class;
	            name = "cepLocalOcorrencia";
	            break;
	        case 1:
	            type = String.class;
	            name = "codigoInfracaoCtb";
	            break;
	        case 2:
	            type = String.class;
		        name = "dataOcorrencia";
		        break;
			case 3:
		        type = String.class;
		        name = "desdobramentoCtb";
		        break;
		    case 4:
		        type = String.class;
		        name = "idFiscal";
		        break;
		    case 5:
		        type = String.class;
		        name = "placaVeiculo";
		        break;
		}
 
        arg2.type = type;
        arg2.name = name;

	}

	@Override
	public void setProperty(int arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	public String getCepLocalOcorrencia() {
		return cepLocalOcorrencia;
	}

	public void setCepLocalOcorrencia(String cepLocalOcorrencia) {
		this.cepLocalOcorrencia = cepLocalOcorrencia;
	}

	public String getCodigoInfracaoCtb() {
		return codigoInfracaoCtb;
	}

	public void setCodigoInfracaoCtb(String codigoInfracaoCtb) {
		this.codigoInfracaoCtb = codigoInfracaoCtb;
	}

	public String getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(String dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	public String getDesdobramentoCtb() {
		return desdobramentoCtb;
	}

	public void setDesdobramentoCtb(String desdobramentoCtb) {
		this.desdobramentoCtb = desdobramentoCtb;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public String getIdFiscal() {
		return idFiscal;
	}

	public void setIdFiscal(String idFiscal) {
		this.idFiscal = idFiscal;
	}

}

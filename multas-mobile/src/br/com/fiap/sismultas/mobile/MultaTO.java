package br.com.fiap.sismultas.mobile;

import android.annotation.SuppressLint;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MultaTO {

	public Integer cod;
	public String cepLocalOcorrencia;
	public String codigoInfracaoCtb;
	public String dataOcorrencia;
	public String desdobramentoCtb;
	public String idFiscal;
	public String placaVeiculo;

	public MultaTO() {
	}

	@SuppressLint("SimpleDateFormat")
	public MultaTO(String cepLocalOcorrencia, String codigoInfracaoCtb,
			Date dataOcorrencia, String desdobramentoCtb, String idFiscal,
			String placaVeiculo) {

		String placaRegEx = "(\\S{3})(\\d{4})";
		String placaRegExAfter = "$1-$2";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'kk:mm:ss");
		
		this.cepLocalOcorrencia = cepLocalOcorrencia;
		this.codigoInfracaoCtb = codigoInfracaoCtb;
		this.dataOcorrencia = sdf.format(dataOcorrencia);
		this.desdobramentoCtb = desdobramentoCtb;
		this.idFiscal = idFiscal;
		this.placaVeiculo = placaVeiculo.replaceAll(placaRegEx, placaRegExAfter);
		
	}
	
}

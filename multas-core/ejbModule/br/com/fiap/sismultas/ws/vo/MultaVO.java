package br.com.fiap.sismultas.ws.vo;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Value Object:
 * Encapsula os dados de uma multa a ser emitida.
 * 
 * @author caio-pereira
 *
 */
public class MultaVO {

	private String placaVeiculo;
	private Date dataOcorrencia;
	private String cepLocalOcorrencia;
	private BigDecimal idFiscal;
	private String codigoInfracaoCtb;
	private BigDecimal desdobramentoCtb;
	
	public MultaVO() {
	}
	
	public MultaVO(String placaVeiculo, Date dataOcorrencia,
			String cepLocalOcorrencia, BigDecimal idFiscal,
			String codigoInfracaoCtb, BigDecimal desdobramentoCtb) {
		super();
		this.placaVeiculo = placaVeiculo;
		this.dataOcorrencia = dataOcorrencia;
		this.cepLocalOcorrencia = cepLocalOcorrencia;
		this.idFiscal = idFiscal;
		this.codigoInfracaoCtb = codigoInfracaoCtb;
		this.desdobramentoCtb = desdobramentoCtb;
	}



	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(Date dataOcorrência) {
		this.dataOcorrencia = dataOcorrência;
	}

	public String getCepLocalOcorrencia() {
		return cepLocalOcorrencia;
	}

	public void setCepLocalOcorrencia(String cepLocalOcorrencia) {
		this.cepLocalOcorrencia = cepLocalOcorrencia;
	}

	public BigDecimal getIdFiscal() {
		return idFiscal;
	}

	public void setIdFiscal(BigDecimal idFiscal) {
		this.idFiscal = idFiscal;
	}

	public String getCodigoInfracaoCtb() {
		return codigoInfracaoCtb;
	}

	public void setCodigoInfracaoCtb(String codigoInfracaoCtb) {
		this.codigoInfracaoCtb = codigoInfracaoCtb;
	}

	public BigDecimal getDesdobramentoCtb() {
		return desdobramentoCtb;
	}

	public void setDesdobramentoCtb(BigDecimal desdobramentoCtb) {
		this.desdobramentoCtb = desdobramentoCtb;
	}

	@Override
	public String toString() {
		return "DadosMultaVO [placaVeiculo=" + placaVeiculo
				+ ", dataOcorrencia=" + dataOcorrencia
				+ ", cepLocalOcorrencia=" + cepLocalOcorrencia + ", idFiscal="
				+ idFiscal + ", codigoInfracaoCtb=" + codigoInfracaoCtb
				+ ", desdobramentoCtb=" + desdobramentoCtb + "]";
	}
	
}

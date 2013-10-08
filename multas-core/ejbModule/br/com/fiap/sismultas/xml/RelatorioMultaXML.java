package br.com.fiap.sismultas.xml;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.sismultas.domain.Infracao;
import br.com.fiap.sismultas.enumeration.TipoRelatorioEnum;

public class RelatorioMultaXML {

	private FiltroXML filtro;
	private List<MultaXML> multas;

	public RelatorioMultaXML() {
	}

	public RelatorioMultaXML(String valorFiltro, List<Infracao> listaInfracao, TipoRelatorioEnum tipoRelatorioEnum) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
		this.filtro = new FiltroXML(tipoRelatorioEnum.getDescricao(), valorFiltro);
		this.multas = new ArrayList<MultaXML>();
		
		for (Infracao infracao : listaInfracao) {
			
			MultaXML multaXML = new MultaXML(
					infracao.getVeiculo() != null ? infracao.getVeiculo().getPlaca() : "Veículo não encontrado.",
					infracao.getVeiculo() != null ? infracao.getVeiculo().getVeiculoModelo().getDescricao() : "Veículo não encontrado.",
					sdf.format(infracao.getDataOcorrencia()),
					infracao.getItemCtb() != null ? infracao.getItemCtb().getPk().getCodigoInfracao() : "Infracao não encontrada", 
					infracao.getItemCtb() != null ? infracao.getItemCtb().getDescricaoResumida() : "Infracao não encontrada");
			
			this.multas.add(multaXML);
			
		}
		
	}
	
	public FiltroXML getFiltro() {
		return filtro;
	}

	public void setFiltro(FiltroXML filtro) {
		this.filtro = filtro;
	}

	public List<MultaXML> getMultas() {
		return multas;
	}

	public void setMultas(List<MultaXML> multas) {
		this.multas = multas;
	}

	

}

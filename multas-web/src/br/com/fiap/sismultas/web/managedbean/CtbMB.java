package br.com.fiap.sismultas.web.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.sismultas.web.facade.ESBFacade;
import br.com.fiap.sismultas.web.vo.GravidadeVO;
import br.com.fiap.sismultas.web.ws.ctb.GravidadeInfracaoVO;
import br.com.fiap.sismultas.web.ws.ctb.ItemCTBVO;

@RequestScoped
@ManagedBean(name = "ctbMB")
public class CtbMB {

	private Integer artigo;
	private String codigoInfracao;
	private String descricaoResumida;
	private Integer desdobramento;
	private Integer paragrafo;
	private Double valorMulta;

	private List<GravidadeVO> gravidades;

	public CtbMB() {

		this.gravidades = new ArrayList<GravidadeVO>();

		List<GravidadeInfracaoVO> gravidadesWS = ESBFacade.getGravidadesInfracoes();

		for (GravidadeInfracaoVO gravidadeWS : gravidadesWS) {
			GravidadeVO gravidadeVO = new GravidadeVO(gravidadeWS);
			this.gravidades.add(gravidadeVO);
		}

	}

	public void cadastra() {

		try {

			ItemCTBVO itemCTBVO = new ItemCTBVO();

			itemCTBVO.setArtigo(this.artigo);
			itemCTBVO.setCodigoInfracao(this.codigoInfracao);
			itemCTBVO.setDescricaoResumida(this.descricaoResumida);
			itemCTBVO.setDesdobramento(this.desdobramento);
			itemCTBVO.setParagrafo(this.paragrafo);
			itemCTBVO.setValorMulta(this.valorMulta);
			
			int gravidadeSelecionada = 0;

			for (GravidadeVO gravidadeVO : this.gravidades) {
				if (gravidadeVO.isSelected()) {

					GravidadeInfracaoVO gravidadeInfracaoVO = new GravidadeInfracaoVO();

					gravidadeInfracaoVO.setId(gravidadeInfracaoVO.getId());
					gravidadeInfracaoVO.setDescricao(gravidadeInfracaoVO.getDescricao());
					gravidadeInfracaoVO.setPontos(gravidadeInfracaoVO.getPontos());

					itemCTBVO.setGravidade(gravidadeInfracaoVO);

					++gravidadeSelecionada;

				}
			}

			if (gravidadeSelecionada == 0) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Selecione a gravidade.", "Selecione a gravidade."));
				return;
			}

			if (gravidadeSelecionada > 1) {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Selecione somente uma gravidade.",
								"Selecione somente uma gravidade."));
				return;
			}

			ItemCTBVO cadastrado = ESBFacade.cadastraItemCtb(itemCTBVO);

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_INFO, cadastrado
							.getMensagem(), cadastrado.getMensagem()));

		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Ocorreu um erro. Tente novamente mais tarde.",
							"Ocorreu um erro. Tente novamente mais tarde."));
		}

	}

	public Integer getArtigo() {
		return artigo;
	}

	public void setArtigo(Integer artigo) {
		this.artigo = artigo;
	}

	public String getCodigoInfracao() {
		return codigoInfracao;
	}

	public void setCodigoInfracao(String codigoInfracao) {
		this.codigoInfracao = codigoInfracao;
	}

	public String getDescricaoResumida() {
		return descricaoResumida;
	}

	public void setDescricaoResumida(String descricaoResumida) {
		this.descricaoResumida = descricaoResumida;
	}

	public Integer getDesdobramento() {
		return desdobramento;
	}

	public void setDesdobramento(Integer desdobramento) {
		this.desdobramento = desdobramento;
	}

	public Integer getParagrafo() {
		return paragrafo;
	}

	public void setParagrafo(Integer paragrafo) {
		this.paragrafo = paragrafo;
	}

	public Double getValorMulta() {
		return valorMulta;
	}

	public void setValorMulta(Double valorMulta) {
		this.valorMulta = valorMulta;
	}

	public List<GravidadeVO> getGravidades() {
		return gravidades;
	}

	public void setGravidades(List<GravidadeVO> gravidades) {
		this.gravidades = gravidades;
	}

}

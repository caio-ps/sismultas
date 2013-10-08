package br.com.fiap.sismultas.ws.vo;

import br.com.fiap.sismultas.domain.ItemCtb;
import br.com.fiap.sismultas.domain.ItemCtbPK;

/**
 * Value object - representa um ítem do código de trânsito brasileiro
 * 
 * @author caio-pereira
 * 
 */
public class ItemCTBVO {

	private Boolean sucesso;
	private String mensagem;

	private String codigoInfracao;
	private Integer desdobramento;
	
	private Integer artigo;
	private String descricaoResumida;
	private Integer paragrafo;
	private GravidadeInfracaoVO gravidade;
	private Double valorMulta;

	public ItemCTBVO() {
		this.sucesso = Boolean.FALSE;
	}

	public ItemCTBVO(String mensagem) {
		this();
		this.mensagem = mensagem;
	}

	public ItemCTBVO(ItemCtb itemCtb) {

		this.sucesso = Boolean.TRUE;
		this.mensagem = "SUCESSO";

		this.codigoInfracao = itemCtb.getPk().getCodigoInfracao();
		this.desdobramento = itemCtb.getPk().getDesdobramento();
		
		this.artigo = itemCtb.getArtigo();
		this.descricaoResumida = itemCtb.getDescricaoResumida();
		this.paragrafo = itemCtb.getParagrafo();
		this.gravidade = new GravidadeInfracaoVO(itemCtb.getInfracaoGravidade());
		this.valorMulta = itemCtb.getValorMulta();

	}

	public ItemCtbPK toEntityPk() {

		ItemCtbPK pk = new ItemCtbPK();

		pk.setCodigoInfracao(this.codigoInfracao);
		pk.setDesdobramento(this.desdobramento);
		
		return pk;

	}
	
	public ItemCtb toEntity() {

		ItemCtb entity = new ItemCtb();

		entity.setPk(this.toEntityPk());
		entity.setArtigo(this.artigo);
		entity.setDescricaoResumida(this.descricaoResumida);
		entity.setInfracaoGravidade(this.gravidade.toEntity());
		entity.setParagrafo(this.paragrafo);
		entity.setValorMulta(this.valorMulta);
		
		return entity;

	}

	public boolean valida() {

		if (this.codigoInfracao == null || this.codigoInfracao.equals("")) {
			return Boolean.FALSE;
		}

		if (this.desdobramento == null) {
			return Boolean.FALSE;
		}

		if (this.artigo == null) {
			return Boolean.FALSE;
		}

		if (this.descricaoResumida == null || this.descricaoResumida.equals("")) {
			return Boolean.FALSE;
		}

		if (this.paragrafo == null) {
			return Boolean.FALSE;
		}
		
		if (this.gravidade == null || this.gravidade.getId() == null) {
			return Boolean.FALSE;
		}
		
		if (this.valorMulta == null) {
			return Boolean.FALSE;
		}

		return Boolean.TRUE;

	}

	public Boolean getSucesso() {
		return sucesso;
	}

	public void setSucesso(Boolean sucesso) {
		this.sucesso = sucesso;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getCodigoInfracao() {
		return codigoInfracao;
	}

	public void setCodigoInfracao(String codigoInfracao) {
		this.codigoInfracao = codigoInfracao;
	}

	public Integer getDesdobramento() {
		return desdobramento;
	}

	public void setDesdobramento(Integer desdobramento) {
		this.desdobramento = desdobramento;
	}

	public Integer getArtigo() {
		return artigo;
	}

	public void setArtigo(Integer artigo) {
		this.artigo = artigo;
	}

	public String getDescricaoResumida() {
		return descricaoResumida;
	}

	public void setDescricaoResumida(String descricaoResumida) {
		this.descricaoResumida = descricaoResumida;
	}

	public Integer getParagrafo() {
		return paragrafo;
	}

	public void setParagrafo(Integer paragrafo) {
		this.paragrafo = paragrafo;
	}

	public GravidadeInfracaoVO getGravidade() {
		return gravidade;
	}

	public void setGravidade(GravidadeInfracaoVO gravidade) {
		this.gravidade = gravidade;
	}

	public Double getValorMulta() {
		return valorMulta;
	}

	public void setValorMulta(Double valorMulta) {
		this.valorMulta = valorMulta;
	}

}

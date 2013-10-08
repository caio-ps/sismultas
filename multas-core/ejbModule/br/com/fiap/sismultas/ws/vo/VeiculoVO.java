package br.com.fiap.sismultas.ws.vo;

import br.com.fiap.sismultas.domain.Veiculo;

/**
 * Value object - representa um veículo
 * 
 * @author caio-pereira
 * 
 */
public class VeiculoVO {

	private Boolean sucesso;
	private String mensagem;

	private String chassi;
	private String placa;
	private String cor;
	private String usuario;
	private ModeloVO modeloVO;

	public VeiculoVO() {
		this.sucesso = Boolean.FALSE;
	}

	public VeiculoVO(String mensagem) {
		this();
		this.mensagem = mensagem;
	}

	public VeiculoVO(Veiculo veiculo) {

		this.sucesso = Boolean.TRUE;
		this.mensagem = "SUCESSO";

		if (veiculo != null) {
			this.chassi = veiculo.getChassi();
			this.placa = veiculo.getPlaca();
			this.cor = veiculo.getCor();
			this.usuario = veiculo.getPessoa().getUsuario();
			this.modeloVO = new ModeloVO(veiculo.getVeiculoModelo());
		}

	}

	public Veiculo toEntity() {

		Veiculo entity = new Veiculo();

		entity.setChassi(this.chassi);
		entity.setCor(this.cor);
		entity.setPlaca(this.placa);
		entity.setVeiculoModelo(this.modeloVO.toEntity());

		return entity;

	}

	public boolean valida() {

		if (this.chassi == null || this.chassi.equals("")) {
			return Boolean.FALSE;
		}

		if (this.placa == null || this.placa.equals("")) {
			return Boolean.FALSE;
		}

		if (this.cor == null || this.cor.equals("")) {
			return Boolean.FALSE;
		}

		if (this.usuario == null || this.usuario.equals("")) {
			return Boolean.FALSE;
		}

		if (this.modeloVO == null || this.modeloVO.getId() == null) {
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

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public ModeloVO getModeloVO() {
		return modeloVO;
	}

	public void setModeloVO(ModeloVO modeloVO) {
		this.modeloVO = modeloVO;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

}

package br.com.fiap.sismultas.web.managedbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import br.com.fiap.sismultas.web.facade.ESBFacade;
import br.com.fiap.sismultas.web.vo.ModeloVO;
import br.com.fiap.sismultas.web.ws.veiculo.VeiculoVO;

@RequestScoped
@ManagedBean(name = "veiculoMB")
public class VeiculoMB {

	private String chassi;
	private String cor;
    private String placa;
    private String usuario;

	private List<ModeloVO> modelos;
	
	public VeiculoMB() {
		
		this.modelos = new ArrayList<ModeloVO>();
		
		List<br.com.fiap.sismultas.web.ws.veiculo.ModeloVO> modelosWS = 
				ESBFacade.getModelosVeiculos();
		
		for (br.com.fiap.sismultas.web.ws.veiculo.ModeloVO modeloWS : modelosWS) {
			ModeloVO modeloVO = new ModeloVO(modeloWS);
			this.modelos.add(modeloVO);
		}
		
	}
	
	public void cadastra() {
		
		try {
			
			VeiculoVO veiculoVO = new VeiculoVO();
			
			veiculoVO.setChassi(this.chassi);
			veiculoVO.setCor(this.cor);
			veiculoVO.setPlaca(this.placa);
			veiculoVO.setUsuario(this.usuario);
			
			int modeloSelecionado = 0;
			
			for (ModeloVO modeloVO : this.modelos) {
				if(modeloVO.isSelected()) {
					
					br.com.fiap.sismultas.web.ws.veiculo.ModeloVO modeloVOWS = 
							new br.com.fiap.sismultas.web.ws.veiculo.ModeloVO();
					
					modeloVOWS.setId(modeloVO.getId());
					modeloVOWS.setAno(modeloVO.getAno());
					modeloVOWS.setDescricao(modeloVO.getDescricao());
					modeloVOWS.setMontadora(modeloVO.getMontadora());

					veiculoVO.setModeloVO(modeloVOWS);
					
					++modeloSelecionado;
					
				}
			}
			
			if (modeloSelecionado == 0) {
				FacesContext.getCurrentInstance().addMessage(
						null, new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Selecione o modelo.",
								"Selecione o modelo."));
				return;
			}
			
			if (modeloSelecionado > 1) {
				FacesContext.getCurrentInstance().addMessage(
						null, new FacesMessage(
								FacesMessage.SEVERITY_ERROR,
								"Selecione somente um modelo.",
								"Selecione somente um modelo."));
				return;
			}
			
			VeiculoVO cadastrado = ESBFacade.cadastraVeiculo(veiculoVO);
			
			FacesContext.getCurrentInstance().addMessage(
					null, new FacesMessage(
							FacesMessage.SEVERITY_INFO,
							cadastrado.getMensagem(),
							cadastrado.getMensagem()));
			
		} catch (Exception e) {
			
			FacesContext.getCurrentInstance().addMessage(
					null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Ocorreu um erro. Tente novamente mais tarde.",
							"Ocorreu um erro. Tente novamente mais tarde."));
		}
		
		
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public List<ModeloVO> getModelos() {
		return modelos;
	}

	public void setModelos(List<ModeloVO> modelos) {
		this.modelos = modelos;
	}
	

}

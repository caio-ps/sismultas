package br.com.fiap.sismultas.web.managedbean;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.math.BigDecimal;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import br.com.fiap.sismultas.web.facade.ESBFacade;
import br.com.fiap.sismultas.web.ws.relatorio.MultaVO;
import br.com.fiap.sismultas.web.ws.relatorio.RelatorioVO;

@RequestScoped
@ManagedBean(name = "relatorioMB")
public class RelatorioMB {

	private Integer idFiscal;
	private String placaVeiculo;

	public RelatorioMB() {
	}

	public void emitePorFiscal() {
		
		try {
		
			MultaVO multaVO = new MultaVO();
			multaVO.setIdFiscal(new BigDecimal(this.idFiscal));
			
			RelatorioVO relatorioVO = ESBFacade.emiteRelatorio(multaVO);
			
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ExternalContext context = facesContext.getExternalContext();    
	        String path = relatorioVO.getCaminhoArquivo();    
	        File file = new File(path);
	    
	        HttpServletResponse response = (HttpServletResponse) context.getResponse();    
	        response.setHeader("Content-Disposition", "attachment;filename=\"relatorio.pdf\"");    
	        response.setContentLength((int) file.length());    
	        response.setContentType("application/pdf");    
	    
            FileInputStream in = new FileInputStream(file);    
            OutputStream out = response.getOutputStream();    

            byte[] buf = new byte[(int)file.length()];    
            int count;
            
            while ((count = in.read(buf)) >= 0) {    
                out.write(buf, 0, count);    
            }
            
            in.close();    
            out.flush();    
            out.close();
            
            facesContext.responseComplete();

		} catch (Exception ex) {
			
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Ocorreu um erro. Tente novamente mais tarde.",
							"Ocorreu um erro. Tente novamente mais tarde."));
			
		}
		
	}
	
	public void emitePorVeiculo() {
		
		try {
			
			MultaVO multaVO = new MultaVO();
			multaVO.setPlacaVeiculo(this.placaVeiculo);
			
			RelatorioVO relatorioVO = ESBFacade.emiteRelatorio(multaVO);
			
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ExternalContext context = facesContext.getExternalContext();    
	        String path = relatorioVO.getCaminhoArquivo();    
	        File file = new File(path);
	    
	        HttpServletResponse response = (HttpServletResponse) context.getResponse();    
	        response.setHeader("Content-Disposition", "attachment;filename=\"relatorio.pdf\"");    
	        response.setContentLength((int) file.length());    
	        response.setContentType("application/pdf");    
	    
            FileInputStream in = new FileInputStream(file);    
            OutputStream out = response.getOutputStream();    

            byte[] buf = new byte[(int)file.length()];    
            int count;
            
            while ((count = in.read(buf)) >= 0) {    
                out.write(buf, 0, count);    
            }
            
            in.close();    
            out.flush();    
            out.close();
            
            facesContext.responseComplete();

		} catch (Exception ex) {
			
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Ocorreu um erro. Tente novamente mais tarde.",
							"Ocorreu um erro. Tente novamente mais tarde."));
			
		}
		
	}
	
	public Integer getIdFiscal() {
		return idFiscal;
	}

	public void setIdFiscal(Integer idFiscal) {
		this.idFiscal = idFiscal;
	}

	public String getPlacaVeiculo() {
		return placaVeiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placaVeiculo = placaVeiculo;
	}

}

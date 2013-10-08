package br.com.fiap.sismultas.web.managedbean;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import br.com.fiap.sismultas.web.facade.ESBFacade;
import br.com.fiap.sismultas.web.vo.InfracaoConsultaVO;
import br.com.fiap.sismultas.web.ws.consulta.InfracaoVO;
import br.com.fiap.sismultas.web.ws.consulta.MultaVO;
import br.com.fiap.sismultas.web.ws.email.RelatorioVO;

@ViewScoped
@ManagedBean(name = "multaMB")
public class MultaMB {

	private String cepLocalOcorrencia;
    private String codigoInfracaoCtb;
    private Date dataOcorrencia;
    private Integer desdobramentoCtb;
    private Integer idFiscal;
    private String placaVeiculo;
    
    private Locale locale;

	private List<InfracaoConsultaVO> infracaoConsultaVOs;

	public MultaMB() {

		locale = new Locale("pt", "BR");

	}

	public void pesquisa() {

		try {

			this.infracaoConsultaVOs = null;
			MultaVO multaVO = new MultaVO();
			
			if (this.cepLocalOcorrencia != null && !this.cepLocalOcorrencia.equals("")) {
				multaVO.setCepLocalOcorrencia(this.cepLocalOcorrencia);
			}
			if (this.codigoInfracaoCtb != null && !this.codigoInfracaoCtb.equals("")) {
				multaVO.setCodigoInfracaoCtb(this.codigoInfracaoCtb);
			}
			if (this.dataOcorrencia != null) {
				GregorianCalendar c = new GregorianCalendar();
				c.setTime(this.dataOcorrencia);
				XMLGregorianCalendar xmlDataOcorrencia = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
				multaVO.setDataOcorrencia(xmlDataOcorrencia);
			}
			if (this.desdobramentoCtb != null && this.desdobramentoCtb.intValue() != 0) {
				multaVO.setDesdobramentoCtb(new BigDecimal(this.desdobramentoCtb));
			}
			if (this.idFiscal != null && this.idFiscal.intValue() != 0) {
				multaVO.setIdFiscal(new BigDecimal(this.idFiscal));
			}
			if (this.placaVeiculo != null && !this.placaVeiculo.equals("")) {
				multaVO.setPlacaVeiculo(this.placaVeiculo);
			}
			
			List<InfracaoVO> infracaoVOs = ESBFacade.getInfracoes(multaVO);
			
			if (infracaoVOs != null && !infracaoVOs.isEmpty()) {
				
				this.infracaoConsultaVOs = new ArrayList<InfracaoConsultaVO>();
				
				for (InfracaoVO infracaoVO : infracaoVOs) {
					
					InfracaoConsultaVO infracaoConsultaVO = new InfracaoConsultaVO(infracaoVO);
					this.infracaoConsultaVOs.add(infracaoConsultaVO);
					
				}
				
			} else {
				FacesContext.getCurrentInstance().addMessage(
						null,
						new FacesMessage(FacesMessage.SEVERITY_INFO,
								"Nenhum resultado encontrado.", "Nenhum resultado encontrado."));
			}

		} catch (Exception e) {

			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Ocorreu um erro. Tente novamente mais tarde.",
							"Ocorreu um erro. Tente novamente mais tarde."));
		}

	}
	
	public void downloadPDF() {
		
		InfracaoConsultaVO docDownload = null;
		int documentoSelecionado = 0;
		
		for (InfracaoConsultaVO infracaoConsultaVO : this.infracaoConsultaVOs) {
			if(infracaoConsultaVO.isSelected()) {
				
				docDownload = infracaoConsultaVO;
				++documentoSelecionado;
				
			}
		}
		
		if (docDownload == null) {
			FacesContext.getCurrentInstance().addMessage(
					null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Selecione o documento para download.",
							"Selecione o documento para download."));
			return;
		}
		
		if (documentoSelecionado > 1) {
			FacesContext.getCurrentInstance().addMessage(
					null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Selecione somente um documento.",
							"Selecione somente um documento."));
			return;
		}
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		ExternalContext context = facesContext.getExternalContext();    
        String path = docDownload.getNotificacaoVO().getCaminhoArquivo();    
        File file = new File(path);
    
        HttpServletResponse response = (HttpServletResponse) context.getResponse();    
        response.setHeader("Content-Disposition", "attachment;filename=\"notificacao.pdf\"");    
        response.setContentLength((int) file.length());    
        response.setContentType("application/pdf");    
    
        try {

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

        } catch (IOException ex) {    
        	FacesContext.getCurrentInstance().addMessage(
					null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Erro no download.",
							"Erro no download."));
			return;   
        }    
		
	}
	
	public void enviaEmail() {
		
		int documentoSelecionado = 0;
		List<InfracaoVO> infracaoEmailVOs = new ArrayList<InfracaoVO>();
		
		for (InfracaoConsultaVO infracaoConsultaVO : this.infracaoConsultaVOs) {
			if(infracaoConsultaVO.isSelected()) {
				
				infracaoEmailVOs.add(infracaoConsultaVO);
				++documentoSelecionado;
				
			}
		}
		
		if (documentoSelecionado == 0) {
			FacesContext.getCurrentInstance().addMessage(
					null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Selecione os documentos para envio.",
							"Selecione os documentos para envio."));
			return;
		}
		
		try {
			
		
			for (InfracaoVO infracaoVO : infracaoEmailVOs) {
				
				RelatorioVO relatorioVO = new RelatorioVO();
				relatorioVO.setId(infracaoVO.getNotificacaoVO().getId());
				relatorioVO.setCaminhoArquivo(infracaoVO.getNotificacaoVO().getCaminhoArquivo());
				
				ESBFacade.enviaEmailNotificacao(relatorioVO);
				
			}
			
		} catch (Exception ex) {
			FacesContext.getCurrentInstance().addMessage(
					null, new FacesMessage(
							FacesMessage.SEVERITY_ERROR,
							"Ocorreu um erro no envio. Tente novamente mais tarde.",
							"Ocorreu um erro no envio. Tente novamente mais tarde."));
			return;
		}
		
		FacesContext.getCurrentInstance().addMessage(
				null, new FacesMessage(
						FacesMessage.SEVERITY_INFO,
						"Enviado com sucesso.",
						"Enviado com sucesso."));
		
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

	public Date getDataOcorrencia() {
		return dataOcorrencia;
	}

	public void setDataOcorrencia(Date dataOcorrencia) {
		this.dataOcorrencia = dataOcorrencia;
	}

	public Integer getDesdobramentoCtb() {
		return desdobramentoCtb;
	}

	public void setDesdobramentoCtb(Integer desdobramentoCtb) {
		this.desdobramentoCtb = desdobramentoCtb;
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

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public List<InfracaoConsultaVO> getInfracaoConsultaVOs() {
		return infracaoConsultaVOs;
	}

	public void setInfracaoConsultaVOs(List<InfracaoConsultaVO> infracaoConsultaVOs) {
		this.infracaoConsultaVOs = infracaoConsultaVOs;
	}
	
}

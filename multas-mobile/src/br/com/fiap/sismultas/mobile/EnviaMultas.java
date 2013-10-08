package br.com.fiap.sismultas.mobile;

import java.util.List;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.util.Log;


public class EnviaMultas extends Thread {

	private MultaDAO dao;
	
	public String URL = null;
	private String methodName = "emiteMulta";
	private String soapAction = "http://ws.sismultas.fiap.com.br/emiteMulta";
	private String namespace = "http://ws.sismultas.fiap.com.br/";

	public EnviaMultas(MultaDAO dao, String url) {
		this.dao = dao;
		this.URL = url;
	}

	@Override
	public void run() {

		while (!isInterrupted()) {
			
			try {
				
				Thread.sleep(5000);
				
				//Lê multas gravadas
				List<MultaTO> multas = this.dao.consultaTodos();
				
				if (multas.size() > 0) {
					
					//Para cada multa gravada envia para o ESB
					for (MultaTO multa : multas) {
						
						try {
							
							//Objeto SOAP
							SoapObject request = new SoapObject(namespace, methodName);
						
							//Parametros passados para o Envelope SOAP
							MultaWSObject obj = new MultaWSObject();
							obj.setCepLocalOcorrencia(multa.cepLocalOcorrencia);
							obj.setCodigoInfracaoCtb(multa.codigoInfracaoCtb);
							obj.setDataOcorrencia(multa.dataOcorrencia);
							obj.setDesdobramentoCtb(multa.desdobramentoCtb);
							obj.setIdFiscal(multa.idFiscal);
							obj.setPlacaVeiculo(multa.placaVeiculo);
							
							//Informações sobre parametros enviados
							PropertyInfo info = new PropertyInfo();
							info.name = "dadosMulta";
							info.type = MultaWSObject.class;
							
							request.addProperty(info, obj);
							
							//Envelope SOAP
							SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
							envelope.setOutputSoapObject(request);

							//Objeto TransportHTTP
							HttpTransportSE transport = new HttpTransportSE(URL);
							
							//Chamada ao serviço
							transport.call(soapAction, envelope);
							
							//Exclui multa enviada
							this.dao.exclui(multa);
							
						} catch (Exception ex) {
							ex.printStackTrace();
							//Erro ao enviar para o ESB. Não toma nenhuma ação. Tentará enviar novamente mais tarde.
						}
					}
				}
				
			} catch (Exception ex) {
				Log.e("EnviaMultas", "Erro ao enviar multas para o servidor: " + ex.getMessage());
			}
			
		}
		
	}
	
}


package br.com.fiap.sismultas.mule.car.ws;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6
 * Generated source version: 2.1
 * 
 */
@WebServiceClient(name = "VeiculoWS", targetNamespace = "http://ws.sismultas.fiap.com.br/", wsdlLocation = "http://localhost:8080/multas-core/VeiculoWS/VeiculoWSBean?wsdl")
public class VeiculoWS
    extends Service
{

    private final static URL VEICULOWS_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(br.com.fiap.sismultas.mule.car.ws.VeiculoWS.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = br.com.fiap.sismultas.mule.car.ws.VeiculoWS.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8080/multas-core/VeiculoWS/VeiculoWSBean?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8080/multas-core/VeiculoWS/VeiculoWSBean?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        VEICULOWS_WSDL_LOCATION = url;
    }

    public VeiculoWS(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public VeiculoWS() {
        super(VEICULOWS_WSDL_LOCATION, new QName("http://ws.sismultas.fiap.com.br/", "VeiculoWS"));
    }

    /**
     * 
     * @return
     *     returns VeiculoWSBean
     */
    @WebEndpoint(name = "VeiculoWSBeanPort")
    public VeiculoWSBean getVeiculoWSBeanPort() {
        return super.getPort(new QName("http://ws.sismultas.fiap.com.br/", "VeiculoWSBeanPort"), VeiculoWSBean.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns VeiculoWSBean
     */
    @WebEndpoint(name = "VeiculoWSBeanPort")
    public VeiculoWSBean getVeiculoWSBeanPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.sismultas.fiap.com.br/", "VeiculoWSBeanPort"), VeiculoWSBean.class, features);
    }

}

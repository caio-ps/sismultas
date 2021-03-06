
package br.com.fiap.sismultas.mule.user.ws;

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
@WebServiceClient(name = "UsuarioWS", targetNamespace = "http://ws.sismultas.fiap.com.br/", wsdlLocation = "http://localhost:8080/multas-core/UsuarioWS/UsuarioWSBean?wsdl")
public class UsuarioWS
    extends Service
{

    private final static URL USUARIOWS_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(br.com.fiap.sismultas.mule.user.ws.UsuarioWS.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = br.com.fiap.sismultas.mule.user.ws.UsuarioWS.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8080/multas-core/UsuarioWS/UsuarioWSBean?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8080/multas-core/UsuarioWS/UsuarioWSBean?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        USUARIOWS_WSDL_LOCATION = url;
    }

    public UsuarioWS(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UsuarioWS() {
        super(USUARIOWS_WSDL_LOCATION, new QName("http://ws.sismultas.fiap.com.br/", "UsuarioWS"));
    }

    /**
     * 
     * @return
     *     returns UsuarioWSBean
     */
    @WebEndpoint(name = "UsuarioWSBeanPort")
    public UsuarioWSBean getUsuarioWSBeanPort() {
        return super.getPort(new QName("http://ws.sismultas.fiap.com.br/", "UsuarioWSBeanPort"), UsuarioWSBean.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UsuarioWSBean
     */
    @WebEndpoint(name = "UsuarioWSBeanPort")
    public UsuarioWSBean getUsuarioWSBeanPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.sismultas.fiap.com.br/", "UsuarioWSBeanPort"), UsuarioWSBean.class, features);
    }

}

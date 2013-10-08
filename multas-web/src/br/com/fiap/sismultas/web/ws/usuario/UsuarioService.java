
package br.com.fiap.sismultas.web.ws.usuario;

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
@WebServiceClient(name = "UsuarioService", targetNamespace = "http://ws.sismultas.fiap.com.br/", wsdlLocation = "http://localhost:8081/Usuario?wsdl")
public class UsuarioService
    extends Service
{

    private final static URL USUARIOSERVICE_WSDL_LOCATION;
    private final static Logger logger = Logger.getLogger(br.com.fiap.sismultas.web.ws.usuario.UsuarioService.class.getName());

    static {
        URL url = null;
        try {
            URL baseUrl;
            baseUrl = br.com.fiap.sismultas.web.ws.usuario.UsuarioService.class.getResource(".");
            url = new URL(baseUrl, "http://localhost:8081/Usuario?wsdl");
        } catch (MalformedURLException e) {
            logger.warning("Failed to create URL for the wsdl Location: 'http://localhost:8081/Usuario?wsdl', retrying as a local file");
            logger.warning(e.getMessage());
        }
        USUARIOSERVICE_WSDL_LOCATION = url;
    }

    public UsuarioService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UsuarioService() {
        super(USUARIOSERVICE_WSDL_LOCATION, new QName("http://ws.sismultas.fiap.com.br/", "UsuarioService"));
    }

    /**
     * 
     * @return
     *     returns Usuario
     */
    @WebEndpoint(name = "UsuarioPort")
    public Usuario getUsuarioPort() {
        return super.getPort(new QName("http://ws.sismultas.fiap.com.br/", "UsuarioPort"), Usuario.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns Usuario
     */
    @WebEndpoint(name = "UsuarioPort")
    public Usuario getUsuarioPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://ws.sismultas.fiap.com.br/", "UsuarioPort"), Usuario.class, features);
    }

}

package br.com.fiap.sismultas.web.ws.email;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.fiap.sismultas.web.ws.email package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EnviaEmailNotificacao_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "enviaEmailNotificacao");
    private final static QName _EnviaEmailNotificacaoResponse_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "enviaEmailNotificacaoResponse");
    private final static QName _Exception_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.fiap.sismultas.web.ws.email
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link RelatorioVO }
     * 
     */
    public RelatorioVO createRelatorioVO() {
        return new RelatorioVO();
    }

    /**
     * Create an instance of {@link EnviaEmailNotificacaoResponse }
     * 
     */
    public EnviaEmailNotificacaoResponse createEnviaEmailNotificacaoResponse() {
        return new EnviaEmailNotificacaoResponse();
    }

    /**
     * Create an instance of {@link EnviaEmailNotificacao_Type }
     * 
     */
    public EnviaEmailNotificacao_Type createEnviaEmailNotificacao_Type() {
        return new EnviaEmailNotificacao_Type();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnviaEmailNotificacao_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sismultas.fiap.com.br/", name = "enviaEmailNotificacao")
    public JAXBElement<EnviaEmailNotificacao_Type> createEnviaEmailNotificacao(EnviaEmailNotificacao_Type value) {
        return new JAXBElement<EnviaEmailNotificacao_Type>(_EnviaEmailNotificacao_QNAME, EnviaEmailNotificacao_Type.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnviaEmailNotificacaoResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sismultas.fiap.com.br/", name = "enviaEmailNotificacaoResponse")
    public JAXBElement<EnviaEmailNotificacaoResponse> createEnviaEmailNotificacaoResponse(EnviaEmailNotificacaoResponse value) {
        return new JAXBElement<EnviaEmailNotificacaoResponse>(_EnviaEmailNotificacaoResponse_QNAME, EnviaEmailNotificacaoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sismultas.fiap.com.br/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

}

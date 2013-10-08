
package br.com.fiap.sismultas.web.ws.autentica;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.fiap.sismultas.web.ws.autentica package. 
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

    private final static QName _AutenticaResponse_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "autenticaResponse");
    private final static QName _Autentica_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "autentica");
    private final static QName _Exception_QNAME = new QName("http://ws.sismultas.fiap.com.br/", "Exception");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.fiap.sismultas.web.ws.autentica
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PessoaVO }
     * 
     */
    public PessoaVO createPessoaVO() {
        return new PessoaVO();
    }

    /**
     * Create an instance of {@link PerfilVO }
     * 
     */
    public PerfilVO createPerfilVO() {
        return new PerfilVO();
    }

    /**
     * Create an instance of {@link Autentica_Type }
     * 
     */
    public Autentica_Type createAutentica_Type() {
        return new Autentica_Type();
    }

    /**
     * Create an instance of {@link AutenticaResponse }
     * 
     */
    public AutenticaResponse createAutenticaResponse() {
        return new AutenticaResponse();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AutenticaResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sismultas.fiap.com.br/", name = "autenticaResponse")
    public JAXBElement<AutenticaResponse> createAutenticaResponse(AutenticaResponse value) {
        return new JAXBElement<AutenticaResponse>(_AutenticaResponse_QNAME, AutenticaResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Autentica_Type }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.sismultas.fiap.com.br/", name = "autentica")
    public JAXBElement<Autentica_Type> createAutentica(Autentica_Type value) {
        return new JAXBElement<Autentica_Type>(_Autentica_QNAME, Autentica_Type.class, null, value);
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

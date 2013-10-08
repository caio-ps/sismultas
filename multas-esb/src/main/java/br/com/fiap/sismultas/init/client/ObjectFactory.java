
package br.com.fiap.sismultas.init.client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.fiap.sismultas.init.client package. 
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

    private final static QName _ExecutaCargaInicialResponse_QNAME = new QName("http://init.sismultas.fiap.com.br/", "executaCargaInicialResponse");
    private final static QName _ExecutaCargaInicial_QNAME = new QName("http://init.sismultas.fiap.com.br/", "executaCargaInicial");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.fiap.sismultas.init.client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExecutaCargaInicialResponse }
     * 
     */
    public ExecutaCargaInicialResponse createExecutaCargaInicialResponse() {
        return new ExecutaCargaInicialResponse();
    }

    /**
     * Create an instance of {@link ExecutaCargaInicial }
     * 
     */
    public ExecutaCargaInicial createExecutaCargaInicial() {
        return new ExecutaCargaInicial();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecutaCargaInicialResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://init.sismultas.fiap.com.br/", name = "executaCargaInicialResponse")
    public JAXBElement<ExecutaCargaInicialResponse> createExecutaCargaInicialResponse(ExecutaCargaInicialResponse value) {
        return new JAXBElement<ExecutaCargaInicialResponse>(_ExecutaCargaInicialResponse_QNAME, ExecutaCargaInicialResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExecutaCargaInicial }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://init.sismultas.fiap.com.br/", name = "executaCargaInicial")
    public JAXBElement<ExecutaCargaInicial> createExecutaCargaInicial(ExecutaCargaInicial value) {
        return new JAXBElement<ExecutaCargaInicial>(_ExecutaCargaInicial_QNAME, ExecutaCargaInicial.class, null, value);
    }

}


package br.com.fiap.sismultas.web.ws.autentica;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "Autentica", targetNamespace = "http://ws.sismultas.fiap.com.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface Autentica {


    /**
     * 
     * @param usuario
     * @param senha
     * @return
     *     returns br.com.fiap.sismultas.web.ws.autentica.PessoaVO
     * @throws Exception_Exception
     */
    @WebMethod(action = "autentica")
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "autentica", targetNamespace = "http://ws.sismultas.fiap.com.br/", className = "br.com.fiap.sismultas.web.ws.autentica.Autentica_Type")
    @ResponseWrapper(localName = "autenticaResponse", targetNamespace = "http://ws.sismultas.fiap.com.br/", className = "br.com.fiap.sismultas.web.ws.autentica.AutenticaResponse")
    public PessoaVO autentica(
        @WebParam(name = "usuario", targetNamespace = "")
        String usuario,
        @WebParam(name = "senha", targetNamespace = "")
        String senha)
        throws Exception_Exception
    ;

}
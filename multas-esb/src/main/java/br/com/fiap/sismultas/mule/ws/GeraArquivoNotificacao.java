
package br.com.fiap.sismultas.mule.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for geraArquivoNotificacao complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="geraArquivoNotificacao">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idNotificacao" type="{http://ws.sismultas.fiap.com.br/}idOperacaoVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "geraArquivoNotificacao", propOrder = {
    "idNotificacao"
})
public class GeraArquivoNotificacao {

    protected IdOperacaoVO idNotificacao;

    /**
     * Gets the value of the idNotificacao property.
     * 
     * @return
     *     possible object is
     *     {@link IdOperacaoVO }
     *     
     */
    public IdOperacaoVO getIdNotificacao() {
        return idNotificacao;
    }

    /**
     * Sets the value of the idNotificacao property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdOperacaoVO }
     *     
     */
    public void setIdNotificacao(IdOperacaoVO value) {
        this.idNotificacao = value;
    }

}

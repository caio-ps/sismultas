
package br.com.fiap.sismultas.mule.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for emiteNotificacao complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="emiteNotificacao">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="idInfracao" type="{http://ws.sismultas.fiap.com.br/}idOperacaoVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "emiteNotificacao", propOrder = {
    "idInfracao"
})
public class EmiteNotificacao {

    protected IdOperacaoVO idInfracao;

    /**
     * Gets the value of the idInfracao property.
     * 
     * @return
     *     possible object is
     *     {@link IdOperacaoVO }
     *     
     */
    public IdOperacaoVO getIdInfracao() {
        return idInfracao;
    }

    /**
     * Sets the value of the idInfracao property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdOperacaoVO }
     *     
     */
    public void setIdInfracao(IdOperacaoVO value) {
        this.idInfracao = value;
    }

}

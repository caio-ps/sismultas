
package br.com.fiap.sismultas.web.ws.relatorio;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for infracaoVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="infracaoVO">
 *   &lt;complexContent>
 *     &lt;extension base="{http://ws.sismultas.fiap.com.br/}multaVO">
 *       &lt;sequence>
 *         &lt;element name="notificacaoVO" type="{http://ws.sismultas.fiap.com.br/}notificacaoVO" minOccurs="0"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="veiculo" type="{http://ws.sismultas.fiap.com.br/}veiculoVO" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "infracaoVO", propOrder = {
    "notificacaoVO",
    "status",
    "veiculo"
})
public class InfracaoVO
    extends MultaVO
{

    protected NotificacaoVO notificacaoVO;
    protected String status;
    protected VeiculoVO veiculo;

    /**
     * Gets the value of the notificacaoVO property.
     * 
     * @return
     *     possible object is
     *     {@link NotificacaoVO }
     *     
     */
    public NotificacaoVO getNotificacaoVO() {
        return notificacaoVO;
    }

    /**
     * Sets the value of the notificacaoVO property.
     * 
     * @param value
     *     allowed object is
     *     {@link NotificacaoVO }
     *     
     */
    public void setNotificacaoVO(NotificacaoVO value) {
        this.notificacaoVO = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the veiculo property.
     * 
     * @return
     *     possible object is
     *     {@link VeiculoVO }
     *     
     */
    public VeiculoVO getVeiculo() {
        return veiculo;
    }

    /**
     * Sets the value of the veiculo property.
     * 
     * @param value
     *     allowed object is
     *     {@link VeiculoVO }
     *     
     */
    public void setVeiculo(VeiculoVO value) {
        this.veiculo = value;
    }

}

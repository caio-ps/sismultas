
package br.com.fiap.sismultas.mule.ws;

import java.math.BigDecimal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for multaVO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="multaVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cepLocalOcorrencia" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="codigoInfracaoCtb" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dataOcorrencia" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="desdobramentoCtb" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="idFiscal" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="placaVeiculo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "multaVO", propOrder = {
    "cepLocalOcorrencia",
    "codigoInfracaoCtb",
    "dataOcorrencia",
    "desdobramentoCtb",
    "idFiscal",
    "placaVeiculo"
})
public class MultaVO {

    protected String cepLocalOcorrencia;
    protected String codigoInfracaoCtb;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataOcorrencia;
    protected BigDecimal desdobramentoCtb;
    protected BigDecimal idFiscal;
    protected String placaVeiculo;

    /**
     * Gets the value of the cepLocalOcorrencia property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCepLocalOcorrencia() {
        return cepLocalOcorrencia;
    }

    /**
     * Sets the value of the cepLocalOcorrencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCepLocalOcorrencia(String value) {
        this.cepLocalOcorrencia = value;
    }

    /**
     * Gets the value of the codigoInfracaoCtb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCodigoInfracaoCtb() {
        return codigoInfracaoCtb;
    }

    /**
     * Sets the value of the codigoInfracaoCtb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCodigoInfracaoCtb(String value) {
        this.codigoInfracaoCtb = value;
    }

    /**
     * Gets the value of the dataOcorrencia property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataOcorrencia() {
        return dataOcorrencia;
    }

    /**
     * Sets the value of the dataOcorrencia property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataOcorrencia(XMLGregorianCalendar value) {
        this.dataOcorrencia = value;
    }

    /**
     * Gets the value of the desdobramentoCtb property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDesdobramentoCtb() {
        return desdobramentoCtb;
    }

    /**
     * Sets the value of the desdobramentoCtb property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDesdobramentoCtb(BigDecimal value) {
        this.desdobramentoCtb = value;
    }

    /**
     * Gets the value of the idFiscal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIdFiscal() {
        return idFiscal;
    }

    /**
     * Sets the value of the idFiscal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIdFiscal(BigDecimal value) {
        this.idFiscal = value;
    }

    /**
     * Gets the value of the placaVeiculo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    /**
     * Sets the value of the placaVeiculo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlacaVeiculo(String value) {
        this.placaVeiculo = value;
    }

}


package cbpi.fit.saa.ws.usuarioportal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de dadosClienteVO complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="dadosClienteVO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cdPess" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cdPessDv" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cdPtov" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cdTipoPess" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nmPess" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dadosClienteVO", propOrder = {
    "cdPess",
    "cdPessDv",
    "cdPtov",
    "cdTipoPess",
    "nmPess"
})
@XmlSeeAlso({
    DadosClienteRIVO.class
})
public class DadosClienteVO {

    protected String cdPess;
    protected String cdPessDv;
    protected String cdPtov;
    protected String cdTipoPess;
    protected String nmPess;

    /**
     * Obtém o valor da propriedade cdPess.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdPess() {
        return cdPess;
    }

    /**
     * Define o valor da propriedade cdPess.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdPess(String value) {
        this.cdPess = value;
    }

    /**
     * Obtém o valor da propriedade cdPessDv.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdPessDv() {
        return cdPessDv;
    }

    /**
     * Define o valor da propriedade cdPessDv.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdPessDv(String value) {
        this.cdPessDv = value;
    }

    /**
     * Obtém o valor da propriedade cdPtov.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdPtov() {
        return cdPtov;
    }

    /**
     * Define o valor da propriedade cdPtov.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdPtov(String value) {
        this.cdPtov = value;
    }

    /**
     * Obtém o valor da propriedade cdTipoPess.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdTipoPess() {
        return cdTipoPess;
    }

    /**
     * Define o valor da propriedade cdTipoPess.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdTipoPess(String value) {
        this.cdTipoPess = value;
    }

    /**
     * Obtém o valor da propriedade nmPess.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNmPess() {
        return nmPess;
    }

    /**
     * Define o valor da propriedade nmPess.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNmPess(String value) {
        this.nmPess = value;
    }

}

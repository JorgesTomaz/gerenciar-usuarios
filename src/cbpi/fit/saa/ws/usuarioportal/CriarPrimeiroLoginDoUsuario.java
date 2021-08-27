
package cbpi.fit.saa.ws.usuarioportal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de criarPrimeiroLoginDoUsuario complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conte�do esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="criarPrimeiroLoginDoUsuario">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="cdEmpr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cdPtov" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cnpj" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cdEmail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usuarioAutenticado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criarPrimeiroLoginDoUsuario", propOrder = {
    "cdEmpr",
    "cdPtov",
    "cnpj",
    "cdEmail",
    "usuarioAutenticado"
})
public class CriarPrimeiroLoginDoUsuario {

    protected String cdEmpr;
    protected String cdPtov;
    protected String cnpj;
    protected String cdEmail;
    protected String usuarioAutenticado;

    /**
     * Obt�m o valor da propriedade cdEmpr.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdEmpr() {
        return cdEmpr;
    }

    /**
     * Define o valor da propriedade cdEmpr.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdEmpr(String value) {
        this.cdEmpr = value;
    }

    /**
     * Obt�m o valor da propriedade cdPtov.
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
     * Obt�m o valor da propriedade cnpj.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCnpj() {
        return cnpj;
    }

    /**
     * Define o valor da propriedade cnpj.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCnpj(String value) {
        this.cnpj = value;
    }

    /**
     * Obt�m o valor da propriedade cdEmail.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCdEmail() {
        return cdEmail;
    }

    /**
     * Define o valor da propriedade cdEmail.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCdEmail(String value) {
        this.cdEmail = value;
    }

    /**
     * Obt�m o valor da propriedade usuarioAutenticado.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuarioAutenticado() {
        return usuarioAutenticado;
    }

    /**
     * Define o valor da propriedade usuarioAutenticado.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuarioAutenticado(String value) {
        this.usuarioAutenticado = value;
    }

}

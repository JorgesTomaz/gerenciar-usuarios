
package cbpi.fit.saa.ws.usuarioportal;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de incluir complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="incluir">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="usuarioMaster" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usuarioPortal" type="{http://usuarioportal.ws.saa.fit.cbpi/}usuarioPortalVO" minOccurs="0"/>
 *         &lt;element name="cdPerfis" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="pontosDeVenda" type="{http://usuarioportal.ws.saa.fit.cbpi/}dadosClienteRIVO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "incluir", propOrder = {
    "usuarioMaster",
    "usuarioPortal",
    "cdPerfis",
    "pontosDeVenda"
})
public class Incluir {

    protected String usuarioMaster;
    protected UsuarioPortalVO usuarioPortal;
    @XmlElement(nillable = true)
    protected List<String> cdPerfis;
    @XmlElement(nillable = true)
    protected List<DadosClienteRIVO> pontosDeVenda;

    /**
     * Obtém o valor da propriedade usuarioMaster.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuarioMaster() {
        return usuarioMaster;
    }

    /**
     * Define o valor da propriedade usuarioMaster.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuarioMaster(String value) {
        this.usuarioMaster = value;
    }

    /**
     * Obtém o valor da propriedade usuarioPortal.
     * 
     * @return
     *     possible object is
     *     {@link UsuarioPortalVO }
     *     
     */
    public UsuarioPortalVO getUsuarioPortal() {
        return usuarioPortal;
    }

    /**
     * Define o valor da propriedade usuarioPortal.
     * 
     * @param value
     *     allowed object is
     *     {@link UsuarioPortalVO }
     *     
     */
    public void setUsuarioPortal(UsuarioPortalVO value) {
        this.usuarioPortal = value;
    }

    /**
     * Gets the value of the cdPerfis property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cdPerfis property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCdPerfis().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getCdPerfis() {
        if (cdPerfis == null) {
            cdPerfis = new ArrayList<String>();
        }
        return this.cdPerfis;
    }

    /**
     * Gets the value of the pontosDeVenda property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the pontosDeVenda property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPontosDeVenda().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DadosClienteRIVO }
     * 
     * 
     */
    public List<DadosClienteRIVO> getPontosDeVenda() {
        if (pontosDeVenda == null) {
            pontosDeVenda = new ArrayList<DadosClienteRIVO>();
        }
        return this.pontosDeVenda;
    }

}

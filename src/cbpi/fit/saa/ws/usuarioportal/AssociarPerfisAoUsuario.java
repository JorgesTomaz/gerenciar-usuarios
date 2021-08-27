
package cbpi.fit.saa.ws.usuarioportal;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de associarPerfisAoUsuario complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="associarPerfisAoUsuario">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="usuarioMaster" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usuario" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="usuarioAutenticado" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cdPerfis" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "associarPerfisAoUsuario", propOrder = {
    "usuarioMaster",
    "usuario",
    "usuarioAutenticado",
    "cdPerfis"
})
public class AssociarPerfisAoUsuario {

    protected String usuarioMaster;
    protected String usuario;
    protected String usuarioAutenticado;
    @XmlElement(nillable = true)
    protected List<String> cdPerfis;

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
     * Obtém o valor da propriedade usuario.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * Define o valor da propriedade usuario.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsuario(String value) {
        this.usuario = value;
    }

    /**
     * Obtém o valor da propriedade usuarioAutenticado.
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

}

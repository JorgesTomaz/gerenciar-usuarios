
package cbpi.fit.saa.ws.usuarioportal;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de listarUsuariosVinculadosAoUsuarioMaster complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="listarUsuariosVinculadosAoUsuarioMaster">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="usuarioMaster" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "listarUsuariosVinculadosAoUsuarioMaster", propOrder = {
    "usuarioMaster"
})
public class ListarUsuariosVinculadosAoUsuarioMaster {

    protected String usuarioMaster;

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

}

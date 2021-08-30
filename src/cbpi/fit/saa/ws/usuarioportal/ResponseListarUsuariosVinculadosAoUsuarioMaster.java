
package cbpi.fit.saa.ws.usuarioportal;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de responseListarUsuariosVinculadosAoUsuarioMaster complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="responseListarUsuariosVinculadosAoUsuarioMaster">
 *   &lt;complexContent>
 *     &lt;extension base="{http://usuarioportal.ws.saa.fit.cbpi/}responseServices">
 *       &lt;sequence>
 *         &lt;element name="listaDeUsuarios" type="{http://usuarioportal.ws.saa.fit.cbpi/}usuarioPortalVO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseListarUsuariosVinculadosAoUsuarioMaster", propOrder = {
    "listaDeUsuarios"
})
public class ResponseListarUsuariosVinculadosAoUsuarioMaster
    extends ResponseServices
{

    @XmlElement(nillable = true)
    protected List<UsuarioPortalVO> listaDeUsuarios;

    /**
     * Gets the value of the listaDeUsuarios property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaDeUsuarios property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaDeUsuarios().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UsuarioPortalVO }
     * 
     * 
     */
    public List<UsuarioPortalVO> getListaDeUsuarios() {
        if (listaDeUsuarios == null) {
            listaDeUsuarios = new ArrayList<UsuarioPortalVO>();
        }
        return this.listaDeUsuarios;
    }

}


package cbpi.fit.saa.ws.usuarioportal;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de responseListarClientesAssociadosAoUsuario complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="responseListarClientesAssociadosAoUsuario">
 *   &lt;complexContent>
 *     &lt;extension base="{http://usuarioportal.ws.saa.fit.cbpi/}responseServices">
 *       &lt;sequence>
 *         &lt;element name="listaDeClientes" type="{http://usuarioportal.ws.saa.fit.cbpi/}dadosClienteRIVO" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "responseListarClientesAssociadosAoUsuario", propOrder = {
    "listaDeClientes"
})
public class ResponseListarClientesAssociadosAoUsuario
    extends ResponseServices
{

    @XmlElement(nillable = true)
    protected List<DadosClienteRIVO> listaDeClientes;

    /**
     * Gets the value of the listaDeClientes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listaDeClientes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListaDeClientes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DadosClienteRIVO }
     * 
     * 
     */
    public List<DadosClienteRIVO> getListaDeClientes() {
        if (listaDeClientes == null) {
            listaDeClientes = new ArrayList<DadosClienteRIVO>();
        }
        return this.listaDeClientes;
    }

}

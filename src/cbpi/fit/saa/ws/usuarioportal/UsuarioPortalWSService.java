
package cbpi.fit.saa.ws.usuarioportal;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "UsuarioPortalWSService", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", wsdlLocation = "WEB-INF/wsdl/wsdl/UsuarioPortalWSService.wsdl")
public class UsuarioPortalWSService
    extends Service
{

    private final static URL USUARIOPORTALWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException USUARIOPORTALWSSERVICE_EXCEPTION;
    private final static QName USUARIOPORTALWSSERVICE_QNAME = new QName("http://usuarioportal.ws.saa.fit.cbpi/", "UsuarioPortalWSService");

    static {
            USUARIOPORTALWSSERVICE_WSDL_LOCATION = cbpi.fit.saa.ws.usuarioportal.UsuarioPortalWSService.class.getResource("/WEB-INF/wsdl/wsdl/UsuarioPortalWSService.wsdl");
        WebServiceException e = null;
        if (USUARIOPORTALWSSERVICE_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find 'WEB-INF/wsdl/wsdl/UsuarioPortalWSService.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        USUARIOPORTALWSSERVICE_EXCEPTION = e;
    }

    public UsuarioPortalWSService() {
        super(__getWsdlLocation(), USUARIOPORTALWSSERVICE_QNAME);
    }

    public UsuarioPortalWSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), USUARIOPORTALWSSERVICE_QNAME, features);
    }

    public UsuarioPortalWSService(URL wsdlLocation) {
        super(wsdlLocation, USUARIOPORTALWSSERVICE_QNAME);
    }

    public UsuarioPortalWSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, USUARIOPORTALWSSERVICE_QNAME, features);
    }

    public UsuarioPortalWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public UsuarioPortalWSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns UsuarioPortalWS
     */
    @WebEndpoint(name = "UsuarioPortalWSPort")
    public UsuarioPortalWS getUsuarioPortalWSPort() {
        return super.getPort(new QName("http://usuarioportal.ws.saa.fit.cbpi/", "UsuarioPortalWSPort"), UsuarioPortalWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns UsuarioPortalWS
     */
    @WebEndpoint(name = "UsuarioPortalWSPort")
    public UsuarioPortalWS getUsuarioPortalWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://usuarioportal.ws.saa.fit.cbpi/", "UsuarioPortalWSPort"), UsuarioPortalWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (USUARIOPORTALWSSERVICE_EXCEPTION!= null) {
            throw USUARIOPORTALWSSERVICE_EXCEPTION;
        }
        return USUARIOPORTALWSSERVICE_WSDL_LOCATION;
    }

}

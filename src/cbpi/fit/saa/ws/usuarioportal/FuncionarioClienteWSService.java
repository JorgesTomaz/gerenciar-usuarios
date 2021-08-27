
package cbpi.fit.saa.ws.usuarioportal;

import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;

@WebServiceClient(name = "FuncionarioClienteWSService", targetNamespace = "http://usuarioportal.ws.saa.fit.cbpi/", wsdlLocation = "WEB-INF/wsdl/wsdl/FuncionarioClienteWSService.wsdl")
public class FuncionarioClienteWSService
    extends Service
{

    private final static URL FUNCIONARIOCLIENTEWSSERVICE_WSDL_LOCATION;
    private final static WebServiceException FUNCIONARIOCLIENTEWSSERVICE_EXCEPTION;
    private final static QName FUNCIONARIOCLIENTEWSSERVICE_QNAME = new QName("http://usuarioportal.ws.saa.fit.cbpi/", "FuncionarioClienteWSService");

    static {
            FUNCIONARIOCLIENTEWSSERVICE_WSDL_LOCATION = cbpi.fit.saa.ws.usuarioportal.FuncionarioClienteWSService.class.getResource("/WEB-INF/wsdl/wsdl/FuncionarioClienteWSService.wsdl");
        WebServiceException e = null;
        if (FUNCIONARIOCLIENTEWSSERVICE_WSDL_LOCATION == null) {
            e = new WebServiceException("Cannot find 'WEB-INF/wsdl/wsdl/FuncionarioClienteWSService.wsdl' wsdl. Place the resource correctly in the classpath.");
        }
        FUNCIONARIOCLIENTEWSSERVICE_EXCEPTION = e;
    }

    public FuncionarioClienteWSService() {
        super(__getWsdlLocation(), FUNCIONARIOCLIENTEWSSERVICE_QNAME);
    }

    public FuncionarioClienteWSService(WebServiceFeature... features) {
        super(__getWsdlLocation(), FUNCIONARIOCLIENTEWSSERVICE_QNAME, features);
    }

    public FuncionarioClienteWSService(URL wsdlLocation) {
        super(wsdlLocation, FUNCIONARIOCLIENTEWSSERVICE_QNAME);
    }

    public FuncionarioClienteWSService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, FUNCIONARIOCLIENTEWSSERVICE_QNAME, features);
    }

    public FuncionarioClienteWSService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public FuncionarioClienteWSService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns FuncionarioClienteWS
     */
    @WebEndpoint(name = "FuncionarioClienteWSPort")
    public FuncionarioClienteWS getFuncionarioClienteWSPort() {
        return super.getPort(new QName("http://usuarioportal.ws.saa.fit.cbpi/", "FuncionarioClienteWSPort"), FuncionarioClienteWS.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns FuncionarioClienteWS
     */
    @WebEndpoint(name = "FuncionarioClienteWSPort")
    public FuncionarioClienteWS getFuncionarioClienteWSPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://usuarioportal.ws.saa.fit.cbpi/", "FuncionarioClienteWSPort"), FuncionarioClienteWS.class, features);
    }

    private static URL __getWsdlLocation() {
        if (FUNCIONARIOCLIENTEWSSERVICE_EXCEPTION!= null) {
            throw FUNCIONARIOCLIENTEWSSERVICE_EXCEPTION;
        }
        return FUNCIONARIOCLIENTEWSSERVICE_WSDL_LOCATION;
    }

}

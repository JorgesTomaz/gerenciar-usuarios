package cbpi.fit.saa.ws.usuarioportal;

import java.net.URL;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

import br.com.ipiranga.logging.logger.IPPLogger;

public class UsuarioPortalWSPortProxy{

    protected Descriptor _descriptor;

    public class Descriptor {
        private cbpi.fit.saa.ws.usuarioportal.UsuarioPortalWSService _service = null;
        private cbpi.fit.saa.ws.usuarioportal.UsuarioPortalWS _proxy = null;
        private Dispatch<Source> _dispatch = null;
        private boolean _useJNDIOnly = false;

        public Descriptor() {
            init();
        }

        public Descriptor(URL wsdlLocation, QName serviceName) {
            _service = new cbpi.fit.saa.ws.usuarioportal.UsuarioPortalWSService(wsdlLocation, serviceName);
            initCommon();
        }

        public void init() {
            _service = null;
            _proxy = null;
            _dispatch = null;
            try
            {
                InitialContext ctx = new InitialContext();
                _service = (cbpi.fit.saa.ws.usuarioportal.UsuarioPortalWSService)ctx.lookup("java:comp/env/service/UsuarioPortalWSService");
            }
            catch (NamingException e)
            {
                if ("true".equalsIgnoreCase(System.getProperty("DEBUG_PROXY"))) {
                    System.out.println("JNDI lookup failure: javax.naming.NamingException: " + e.getMessage());
                    e.printStackTrace(System.out);
                }
            }

            if (_service == null && !_useJNDIOnly)
                _service = new cbpi.fit.saa.ws.usuarioportal.UsuarioPortalWSService();
            initCommon();
        }

        private void initCommon() {
            _proxy = _service.getUsuarioPortalWSPort();
        }

        public cbpi.fit.saa.ws.usuarioportal.UsuarioPortalWS getProxy() {
            return _proxy;
        }

        public void useJNDIOnly(boolean useJNDIOnly) {
            _useJNDIOnly = useJNDIOnly;
            init();
        }

        public Dispatch<Source> getDispatch() {
            if (_dispatch == null ) {
                QName portQName = new QName("", "UsuarioPortalWSPort");
                _dispatch = _service.createDispatch(portQName, Source.class, Service.Mode.MESSAGE);

                String proxyEndpointUrl = getEndpoint();
                BindingProvider bp = (BindingProvider) _dispatch;
                String dispatchEndpointUrl = (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
                if (!dispatchEndpointUrl.equals(proxyEndpointUrl))
                    bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, proxyEndpointUrl);
            }
            return _dispatch;
        }

        public String getEndpoint() {
            BindingProvider bp = (BindingProvider) _proxy;
            return (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
        }

		public void setEndpoint(String endpointUrl) {
			try {
				InitialContext ctx = new InitialContext();

				URL server = (URL) ctx.lookup("url/endpointSAA");
				IPPLogger.singleton().finest(server.toString());
				System.out.println("Servidor: ");
				System.out.println(server.toString());

				BindingProvider bp = (BindingProvider) _proxy;
				bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, server.toString());

				if (_dispatch != null) {
					bp = (BindingProvider) _dispatch;
					bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, server.toString());
				}

			} catch (NamingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        public void setMTOMEnabled(boolean enable) {
            SOAPBinding binding = (SOAPBinding) ((BindingProvider) _proxy).getBinding();
            binding.setMTOMEnabled(enable);
        }
    }

    public UsuarioPortalWSPortProxy() {
        _descriptor = new Descriptor();
        _descriptor.setMTOMEnabled(false);
    }

    public UsuarioPortalWSPortProxy(URL wsdlLocation, QName serviceName) {
        _descriptor = new Descriptor(wsdlLocation, serviceName);
        _descriptor.setMTOMEnabled(false);
    }

    public Descriptor _getDescriptor() {
        return _descriptor;
    }

    public ResponsePrimeiroAcessoDoUsuario primeiroLogin(String usuario) {
        return _getDescriptor().getProxy().primeiroLogin(usuario);
    }

    public ResponseListarClientesAssociadosAoUsuario listarClientesAssociadosAoUsuario(String usuario) {
        return _getDescriptor().getProxy().listarClientesAssociadosAoUsuario(usuario);
    }

    public ResponseServices reativar(String usuario, String usuarioAutenticado) {
        return _getDescriptor().getProxy().reativar(usuario,usuarioAutenticado);
    }

    public ResponseServices criarPrimeiroLoginDoUsuario(String cdEmpr, String cdPtov, String cnpj, String cdEmail, String usuarioAutenticado) {
        return _getDescriptor().getProxy().criarPrimeiroLoginDoUsuario(cdEmpr,cdPtov,cnpj,cdEmail,usuarioAutenticado);
    }

    public ResponseServices inativar(String usuario, String usuarioAutenticado) {
        return _getDescriptor().getProxy().inativar(usuario,usuarioAutenticado);
    }

    public ResponseListarPerfisDoUsuario listarPerfisDoUsuario(String usuario) {
        return _getDescriptor().getProxy().listarPerfisDoUsuario(usuario);
    }

}
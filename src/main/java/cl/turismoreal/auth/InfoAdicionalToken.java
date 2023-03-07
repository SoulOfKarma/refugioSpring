package cl.turismoreal.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import cl.turismoreal.models.entity.Cliente;
import cl.turismoreal.models.entity.Empleado;
import cl.turismoreal.models.services.ClienteService;
import cl.turismoreal.models.services.EmpleadoService;

@Component
public class InfoAdicionalToken implements TokenEnhancer {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EmpleadoService empleadoService;
	
	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
 
		String clientId = authentication.getOAuth2Request().getClientId();
 
		Cliente cliente = clienteService.findByUsername(authentication.getName());
		Empleado empleado = empleadoService.findByUsername(authentication.getName());
 
		Map<String, Object> info = new HashMap<>();
		
		if(clientId.equals("refugio-angular")){
			info.put("ID", cliente.getIdCliente());
			info.put("Nombre", cliente.getNombreCliente());
			info.put("Apellido", cliente.getApellidoCliente());
		}
 
		if(clientId.equals("refugio-ionic")){
			info.put("ID", empleado.getIdEmpleado());
			info.put("Nombre", empleado.getNombreEmpleado());
			info.put("Apellido", empleado.getApellidoEmpleado());
		}
 
		((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(info);
 
		return accessToken;
	}
}

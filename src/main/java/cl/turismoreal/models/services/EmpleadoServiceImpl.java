package cl.turismoreal.models.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.turismoreal.models.dao.EmpleadoDao;
import cl.turismoreal.models.entity.Empleado;

@Service
@Qualifier("empleadoServiceImpl")
public class EmpleadoServiceImpl implements EmpleadoService, UserDetailsService {
	
	private Logger logger = LoggerFactory.getLogger(EmpleadoServiceImpl.class);
	
	@Autowired
	private EmpleadoDao empleadoDao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Empleado empleado = empleadoDao.findByUsername(username);
		
		if(empleado == null) {
			logger.error("Error en el inicio de sesión: no existe el usuario '"+empleado+"' en el sistema");
			throw new UsernameNotFoundException("Error en el inicio de sesión: no existe el usuario '"+empleado+"' en el sistema");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(); 

		return new User(empleado.getUsername(), empleado.getPassword(), empleado.getEnable(), true, true, true, authorities);
	}

	@Override
	public Empleado findByUsername(String username) {
		return empleadoDao.findByUsername(username);
	}

	@Override
	public Empleado findById(Long id) {
		return empleadoDao.findById(id).orElse(null);
	}

}

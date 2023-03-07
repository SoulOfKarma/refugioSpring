package cl.turismoreal.models.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.turismoreal.models.dao.ClienteDao;
import cl.turismoreal.models.entity.Cliente;
import cl.turismoreal.models.entity.Comuna;
import cl.turismoreal.models.entity.Genero;
import cl.turismoreal.models.entity.Nacionalidad;

@Service
@Qualifier("clienteServiceImpl")
public class ClienteServiceImpl implements ClienteService, UserDetailsService {
	
	private Logger logger = LoggerFactory.getLogger(ClienteServiceImpl.class);
	
	@Autowired
	private ClienteDao clienteDao;

	@Override
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}
	
	@Override
	@Transactional(readOnly = true)
	public Page<Cliente> findAll(Pageable pageable) {
		return clienteDao.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Cliente save(Cliente cliente) {
		return clienteDao.save(cliente);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Comuna> findAllComunas() {
		return clienteDao.findAllComunas();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Nacionalidad> findAllNacionalidades() {
		return clienteDao.findAllNacionalidades();
	}

	@Override
	@Transactional(readOnly = true)
	public List<Genero> findAllGeneros() {
		return clienteDao.findAllGeneros();
	}

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Cliente cliente = clienteDao.findByUsername(username);
		
		if(cliente == null) {
			logger.error("Error en el inicio de sesión: no existe el usuario '"+cliente+"' en el sistema");
			throw new UsernameNotFoundException("Error en el inicio de sesión: no existe el usuario '"+cliente+"' en el sistema");
		}
		
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>(); 

		return new User(cliente.getUsername(), cliente.getPassword(), cliente.getEnable(), true, true, true, authorities);
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findByUsername(String username) {
		return clienteDao.findByUsername(username);
	}
}

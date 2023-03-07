package cl.turismoreal.models.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import cl.turismoreal.models.entity.Cliente;
import cl.turismoreal.models.entity.Comuna;
import cl.turismoreal.models.entity.Genero;
import cl.turismoreal.models.entity.Nacionalidad;

public interface ClienteService {
	
	public List<Cliente> findAll();
	
	public Page<Cliente> findAll(Pageable pageable);
	
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	
	public void delete(Long id);
	
	public List<Comuna> findAllComunas();
	
	public List<Nacionalidad> findAllNacionalidades();
	
	public List<Genero> findAllGeneros();
	
	public Cliente findByUsername(String username);
}

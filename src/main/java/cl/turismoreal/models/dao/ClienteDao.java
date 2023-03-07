package cl.turismoreal.models.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cl.turismoreal.models.entity.Cliente;
import cl.turismoreal.models.entity.Comuna;
import cl.turismoreal.models.entity.Genero;
import cl.turismoreal.models.entity.Nacionalidad;

@Repository
public interface ClienteDao extends JpaRepository<Cliente, Long>{
	
	@Query("FROM Comuna ORDER BY nombreComuna ASC")
	public List<Comuna> findAllComunas();
	
	@Query("FROM Nacionalidad ORDER BY nombreNacionalidad ASC")
	public List<Nacionalidad> findAllNacionalidades();
	
	@Query("FROM Genero ORDER BY idGenero ASC")
	public List<Genero> findAllGeneros();
	
	public Cliente findByUsername(String username);
}

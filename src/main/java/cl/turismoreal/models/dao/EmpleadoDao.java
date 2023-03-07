package cl.turismoreal.models.dao;

import org.springframework.data.repository.CrudRepository;

import cl.turismoreal.models.entity.Empleado;

public interface EmpleadoDao extends CrudRepository<Empleado, Long> {

	public Empleado findByUsername(String username);
}

package cl.turismoreal.models.services;

import cl.turismoreal.models.entity.Empleado;

public interface EmpleadoService {
	
	public Empleado findById(Long id);

	//@Query("SELECT e FROM Empleado e WHERE e.username=?1")
	public Empleado findByUsername(String username);
}

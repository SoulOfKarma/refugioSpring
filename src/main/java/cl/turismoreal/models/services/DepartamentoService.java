package cl.turismoreal.models.services;

import java.util.List;

import cl.turismoreal.models.entity.Departamento;

public interface DepartamentoService {

	public List<Departamento> findAll();
	
	public Departamento findById(Long id);
}

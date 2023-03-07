package cl.turismoreal.models.services;

import java.util.List;

import cl.turismoreal.models.entity.Cliente;
import cl.turismoreal.models.entity.Reserva;

public interface ReservaService {
	
	public List<Reserva> findAll();
	
	public Reserva findById(Long id);
	
	public Reserva save(Reserva codigo);
	
	public void delete(Long id);
	
	public Reserva findFirstByCliente(Cliente cliente);
	
	public Reserva findByCodigo(String codigo);
}	

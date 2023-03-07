package cl.turismoreal.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cl.turismoreal.models.entity.Cliente;
import cl.turismoreal.models.entity.Reserva;;

public interface ReservaDao extends JpaRepository<Reserva, Long>{
	
	public Reserva findFirstByCliente(Cliente cliente);
	
	@Query("SELECT r FROM Reserva r WHERE r.codigoReserva=?1")
	public Reserva findByCodigo(String codigo);
}

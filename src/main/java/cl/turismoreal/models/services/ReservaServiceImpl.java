package cl.turismoreal.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.turismoreal.models.dao.ReservaDao;
import cl.turismoreal.models.entity.Cliente;
import cl.turismoreal.models.entity.Reserva;

@Service
public class ReservaServiceImpl implements ReservaService{
	
	@Autowired
	private ReservaDao reservaDao;

	@Override
	@Transactional(readOnly = true)
	public List<Reserva> findAll() {
		return (List<Reserva>) reservaDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Reserva findById(Long id) {
		return reservaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public Reserva save(Reserva codigo) {
		return reservaDao.save(codigo);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		// TODO Auto-generated method stub
	}

	@Override
	@Transactional(readOnly = true)
	public Reserva findFirstByCliente(Cliente cliente) {
		return reservaDao.findFirstByCliente(cliente);
	}

	@Override
	@Transactional(readOnly = true)
	public Reserva findByCodigo(String codigo) {
		return reservaDao.findByCodigo(codigo);
	}
}

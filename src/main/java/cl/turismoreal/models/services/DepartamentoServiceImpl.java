package cl.turismoreal.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cl.turismoreal.models.dao.DepartamentoDao;
import cl.turismoreal.models.entity.Departamento;

@Service
public class DepartamentoServiceImpl implements DepartamentoService{
	
	@Autowired
	private DepartamentoDao departamentoDao;

	@Override
	@Transactional(readOnly = true)
	public List<Departamento> findAll() {
		return (List<Departamento>) departamentoDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Departamento findById(Long id) {
		return departamentoDao.findById(id).orElse(null);
	}

}

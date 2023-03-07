package cl.turismoreal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import cl.turismoreal.models.entity.Departamento;
import cl.turismoreal.models.services.DepartamentoService;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins= "*")
public class DepartamentoController {
	
	@Autowired
	private DepartamentoService departamentoService;
	
	@GetMapping("/departamentos")
	public ResponseEntity<List<Departamento>> all() {
		List<Departamento> departamentos = this.departamentoService.findAll();
		return new ResponseEntity<>(departamentos, HttpStatus.OK);
	}
	
	@GetMapping("/departamentos/{id}")
	public ResponseEntity<Departamento> byId(@PathVariable Long id) {
		Departamento departamentoPorId = this.departamentoService.findById(id);
		return new ResponseEntity<>(departamentoPorId, HttpStatus.OK);
	}
}

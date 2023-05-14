package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Autowired
	private Interface dao;
	
	@PostMapping("/registroMatricula")
	public String registrarMatricula(@RequestBody matricula matricula) {
	dao.altamatricula(matricula.getEntrada(), matricula.getMatricula());
    
    return "Los datos se han recibido con éxito";
	}
	
	@GetMapping(value="/coste/{matricula}")
	public double coste(@PathVariable(value="matricula") String matricula) {
		
		double coste = dao.consultamatricula(matricula);
		return coste;
		
	}
}

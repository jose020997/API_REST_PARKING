package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@Autowired
	private Interface dao;
	
	
	//Hacemos un Insert
	@PostMapping("/jabg0014/registroMatricula")
	//var urlrest = 'registroMatricula'; del html
	public ResponseEntity<String> registrarMatricula(@RequestBody matricula matricula) {
		
		ResponseEntity<String> respuetaHTTP;
		
		dao.altamatricula(matricula.getEntrada(), matricula.getMatricula());
    
		respuetaHTTP = new ResponseEntity<String>("Usuario Creado Correctamente",HttpStatus.OK);
		
		return respuetaHTTP;
	}
	
	
	//Hacemos un select
	@GetMapping(value="/jabg0014/coste/{matricula}")
	// del fichero var urlrest = 'coste/' + $('#matricula').val();
	public double coste(@PathVariable(value="matricula") String matricula) {
		
		double coste = dao.consultamatricula(matricula);
		
		return coste;
		
	}
	
	
	//hacemos un update
	/*@PostMapping("/registroMatricula")
	public void updatedeentradaosalida(@RequestBody matricula matricula) {
		//pillamos la matricula introducida
		dao.modificar(matricula.getMatricula(),matricula.getEntrada());
		}
	
	*/
	
	//hacemos un delete
	
}

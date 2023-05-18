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
	
	
	//Hacemos un Insert
	/*@PostMapping("/registroMatricula")
	//var urlrest = 'registroMatricula'; del html
	public String registrarMatricula(@RequestBody matricula matricula) {
		//Solicitamos matricula declarada como matricula
	dao.altamatricula(matricula.getEntrada(), matricula.getMatricula());
    
    return "Los datos se han recibido con éxito";
	}
	*/
	
	
	//Hacemos un select
	@GetMapping(value="/coste/{matricula}")
	// del fichero var urlrest = 'coste/' + $('#matricula').val();
	public double coste(@PathVariable(value="matricula") String matricula) {
		//Das la matricula
		double coste = dao.consultamatricula(matricula);
		//con la matricula que pillas haces la consulta
		return coste;
		
	}
	
	
	//hacemos un update
	@PostMapping("/registroMatricula")
	public void updatedeentradaosalida(@RequestBody matricula matricula) {
		//pillamos la matricula introducida
		dao.modificar(matricula.getMatricula(),matricula.getEntrada());
		}
	
	
	
	//hacemos un delete
	
}

package com.example.demo;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class Daojabg implements Interface {

private JdbcTemplate jdbctemplate;
	
	@Autowired
	public void setDataSource(DataSource datasource) { 
		this.jdbctemplate =  new JdbcTemplate(datasource);
	}
	
	private final RowMapper<matricula> mapper = (rs,numRow) -> {
		matricula usuario = new matricula();
		usuario.setEntrada(rs.getString("entrada"));
		usuario.setMatricula(rs.getString("matricula"));
		usuario.setHora(rs.getString("hora"));
		return usuario;
	};
	
	public void altamatricula(String entrada, String matricula) {
	    String sql = "INSERT INTO datos (entrada, matricula, hora) VALUES (?, ?, TIME(NOW()))";
	    jdbctemplate.update(sql, entrada, matricula);
	}
	
	public int consultamatricula(String matricula) {
		
		
		  String sql = "Select * from datos where matricula = ? ORDER BY hora DESC";	
		  List<matricula> datos = this.jdbctemplate.query(sql,mapper, matricula);
		  
		  matricula datosMatriculaEntrada = datos.get(1);
		  matricula datosMatriculaS = datos.get(0);
		  String tiempoSalida = datosMatriculaS.hora;
		  String tiempoEntrada = datosMatriculaEntrada.hora;
		  
		  String[] partes = tiempoSalida.split(":");
	        int horas = Integer.parseInt(partes[0]);
	        int minutos = Integer.parseInt(partes[1]);
	        int segundos = Integer.parseInt(partes[2]);
	       String[] partes1 = tiempoEntrada.split(":");
	        int horas1 = Integer.parseInt(partes1[0]);
	        int minutos1 = Integer.parseInt(partes1[1]);
	        int segundos1 = Integer.parseInt(partes1[2]);
		
	        int coste = 2*((horas*60+minutos*60+segundos)-(horas1*60+minutos1*60+segundos1));
		return coste;
	}
}

package com.example.demo;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class Daojabg implements Interface {

private JdbcTemplate jdbctemplate;
	
	@Autowired
	public void setDataSource(DataSource datasource) { 
		this.jdbctemplate =  new JdbcTemplate(datasource);
	}
	
	public void altamatricula(String entrada, String matricula) {
	    String sql = "INSERT INTO datos (entrada, matricula, hora) VALUES (?, ?,  NOW())";
	    jdbctemplate.update(sql, entrada, matricula);
	}
}

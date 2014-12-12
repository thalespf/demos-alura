/**
 * 
 */
package com.thalespf.demos.livraria.modelo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
@Entity
public class Autor {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;

	public Autor() {
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}

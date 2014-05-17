/**
 * 
 */
package com.thalespf.demos.jpa.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/**
 * @author thales pordeus (l.thales.x@gmail.com)
 * 
 * 05/05/2014
 */
@Entity
public class Editora {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	
	private String email;

	public Editora() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}

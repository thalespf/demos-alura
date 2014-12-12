package com.thalespf.demo.domain;

import java.io.Serializable;

/**
 * 
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
public class Student implements Serializable {

	private Long id;
	private String nome;
	private String telefone;
	private String endereco;
	private String site;
	private String foto;
	private double nota;
	
	@Override
	public String toString() {
		return nome;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o == null)
			return false;
		if(o.getClass() != Student.class) 
			return false;
		Student s = (Student) o;
		Long id = s.getId();
		if(id != null && this.id != null && 
				id.equals(this.getId()))
			return true;
		if(o != this)
			return false;
		return false;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

}
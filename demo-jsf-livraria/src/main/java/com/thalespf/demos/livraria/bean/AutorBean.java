/**
 * 
 */
package com.thalespf.demos.livraria.bean;

import javax.faces.bean.ManagedBean;

import org.apache.log4j.Logger;

import com.thalespf.demos.livraria.dao.DAO;
import com.thalespf.demos.livraria.modelo.Autor;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
@ManagedBean
public class AutorBean {
	
	private Autor autor = new Autor();
	
	private DAO<Autor> dao = new DAO<Autor>(Autor.class);
	
	private static final Logger logger = Logger
			.getLogger(AutorBean.class);
	
	public Autor getAutor() {
		return autor;
	}
	
	public void salvar() {
		logger.info("Salvando autor: " + autor.getNome());
		
		if(autor.getNome().isEmpty()) {
			throw new RuntimeException("Deve ter pelo menos o nome do autor");
		}
		
		dao.adiciona(autor);
		
		autor = new Autor();
	}

}

/**
 * 
 */
package com.thalespf.demos.livraria.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.apache.log4j.Logger;

import com.thalespf.demos.livraria.dao.DAO;
import com.thalespf.demos.livraria.modelo.Autor;
import com.thalespf.demos.livraria.modelo.Livro;

/**
 * @author Thales Ferreira / l.thales.x@gmail.com
 *
 */
@ManagedBean
@ViewScoped
public class LivroBean {
	
	private Livro livro = new Livro();
	
	private DAO<Livro> daoLivro = new DAO<Livro>(Livro.class);
	
	private DAO<Autor> daoAutor = new DAO<Autor>(Autor.class);
	
	private List<Autor> autores;
	
	private Long autorSelecionado;
	
	private static final Logger logger = Logger
			.getLogger(LivroBean.class);
	
	public Livro getLivro() {
		return livro;
	}
	
	public List<Livro> getLivros() {
		return daoLivro.listaTodos();
	}
	
	public Long getAutorSelecionado() {
		return autorSelecionado;
	}

	public void setAutorSelecionado(Long autorSelecionado) {
		this.autorSelecionado = autorSelecionado;
	}

	@PostConstruct
	public void loadAutores() {
	    autores = daoAutor.listaTodos();
	}
	
	public List<Autor> getAutores() {
		return autores;
	}
	
	public List<Autor> getAutoresDoLivro() {
		return livro.getAutores();
	}	
	
	public void escolheAutor() {
		Autor autor = daoAutor.buscaPorId(autorSelecionado);
		livro.adicionaAutor(autor);
		logger.info("Autor escolhido: " + autor.getNome());
	}

	public void gravar() {
		logger.info("Gravando o livro: " + this.livro.getTitulo());
		
		if(livro.getAutores().isEmpty()) {
			FacesContext.getCurrentInstance().addMessage("autor",
					new FacesMessage("Livro deve ter pelo menos um autor"));
			return;
		}
		
		daoLivro.adiciona(livro);
		
		livro = new Livro();
	}
	
	public String autorView() {
		return "autor";
	}
	
	public void validateISBN(FacesContext context, UIComponent uiComponent, 
			Object value) throws ValidatorException {
		String valueString = value.toString();
		if(!valueString.startsWith("1")) {
			throw new ValidatorException(new FacesMessage("Deveria começar com 1"));
		}
	}
	
}

package com.arquitecturajava.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Test;

import com.arquitecturajava.bo.Noticia;

public class NoticiaTest extends JPAUnitTest {
	
//	@Test
	public void seleccionarNoticiaInicial() {
		Noticia noticia = em.find(Noticia.class, "java 9 ha salido");
		assertEquals("cecilio", noticia.getAutor());
	}
	
//	@Test
	public void borrarNoticiaInicial() {
		Noticia noticia = em.find(Noticia.class, "java 9 ha salido");
		em.getTransaction().begin();
		em.remove(noticia);
		em.getTransaction().commit();
		Noticia sinNoticia = em.find(Noticia.class, "java 9 ha salido");
		assertNull(sinNoticia);
	}
	
//	@Test
	public void borrarNoticiaSinConsulta() {
		// Se indico que se eliminen los registros que hacen referencia al registro que se esta eliminando
		// añadiendo a la anotacion orphanRemoval=true
		// @OneToMany(mappedBy="noticia", cascade=CascadeType.ALL, orphanRemoval=true)
		Noticia noticia = new Noticia("java 9 ha salido");
		em.getTransaction().begin();
		noticia = em.merge(noticia);
		em.remove(noticia);
		em.getTransaction().commit();
		Noticia sinNoticia = em.find(Noticia.class, "java 9 ha salido");
		assertNull(sinNoticia);
	}
	
//	@Test
	public void actualizarNoticiaSinConsulta() {
		Noticia noticia = new Noticia("java 9 ha salido", "pedro", new Date());
		em.getTransaction().begin();
		em.persist(noticia);
		em.getTransaction().commit();
		System.out.println("**********");
	}
	
//	@Test
	public void insertarNoticia() {
		Noticia noticiaNueva = new Noticia("java 8 y streams", "Cecilio", new Date());
		em.getTransaction().begin();
		em.persist(noticiaNueva);
		em.getTransaction().commit();
		Noticia noticiaInsertada = em.find(Noticia.class, "java 8 y streams");
		assertNotNull(noticiaInsertada);
	}
	

}

package com.arquitecturajava.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Date;

import org.junit.Test;

import com.arquitecturajava.bo.Noticia;

public class NoticiaTest extends JPAUnitTest {
	
	@Test
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
	public void insertarNoticia() {
		Noticia noticiaNueva = new Noticia("java 8 y streams", "Cecilio", new Date());
		em.getTransaction().begin();
		em.persist(noticiaNueva);
		em.getTransaction().commit();
		Noticia noticiaInsertada = em.find(Noticia.class, "java 8 y streams");
		assertNotNull(noticiaInsertada);
	}
	

}

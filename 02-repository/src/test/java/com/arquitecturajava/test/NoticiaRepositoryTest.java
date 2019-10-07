package com.arquitecturajava.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.arquitecturajava.bo.Noticia;
import com.arquitecturajava.repositorios.jpa.NoticiaRepositoryJPA;

public class NoticiaRepositoryTest extends JPAUnitTest {
	
	NoticiaRepositoryJPA repositorio;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		repositorio = new NoticiaRepositoryJPA();
		repositorio.setEntityManager(em);
	}

//	@Test
	public void inyectarEntityManager() {
		assertEquals(em, repositorio.getEntityManager());
	}
	
//	@Test
	public void seleccionarTodasLasNoticias() {
		Noticia noticia = repositorio.findAll().iterator().next();
		assertNotNull(noticia);
	}
	
	@Test
	public void insertarNoticia() {
		repositorio.getEntityManager().getTransaction().begin();
		Noticia noticiaNueva = new Noticia("lo nuevo de java 8");
		repositorio.save(noticiaNueva);
		repositorio.getEntityManager().getTransaction().commit();
		Noticia noticia = repositorio.findOne("lo nuevo de java 8");
		assertEquals(noticiaNueva, noticia);
	}

}

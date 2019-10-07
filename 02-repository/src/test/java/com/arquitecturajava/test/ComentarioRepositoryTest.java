package com.arquitecturajava.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import com.arquitecturajava.bo.Comentario;
import com.arquitecturajava.repositorios.jpa.ComentarioRepositoryJPA;

public class ComentarioRepositoryTest extends JPAUnitTest {

	ComentarioRepositoryJPA repositorio;
	
	@Before
	public void setUp() throws Exception {
		super.setUp();
		repositorio = new ComentarioRepositoryJPA();
		repositorio.setEntityManager(em);
	}

//	@Test
	public void inyectarEntityManager() {
		assertEquals(em, repositorio.getEntityManager());
	}
	
//	@Test
	public void seleccionarTodosLosComentarios() {
		Comentario comentario = repositorio.findAll().iterator().next();
		assertNotNull(comentario);
	}
	
	@Test
	public void seleccionarUnComentario() {
		Comentario comentario = repositorio.findOne(1);
		assertNotNull(comentario);
	}
	

}

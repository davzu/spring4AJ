package com.arquitecturajava.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.arquitecturajava.bo.Comentario;
import com.arquitecturajava.bo.Noticia;

public class ComentarioTest extends JPAUnitTest {
	
	@Test
	public void seleccionarComentarioInicial() {
		Comentario comentario = em.find(Comentario.class, 1);
		assertNotNull(comentario);
	}
	
//	@Test
	public void seleccionarComentarioInicialConsulta() {
		// si no se añade la anotacion
//		int total = em.createQuery("select c from Comentario c join fetch c.noticia").getResultList().size();
		
		int total = em.createQuery("select c from Comentario c").getResultList().size();		
		assertEquals(total, 2);
	}
	
//	@Test
	public void seleccionarComentarioDeNoticia() {
		Noticia noticia = em.find(Noticia.class, "java 9 ha salido");
		Comentario comentario = noticia.getComentarios().get(0);
		assertNotNull(comentario);
	}
	

}

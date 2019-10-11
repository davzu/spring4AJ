package com.arquitecturajava.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.arquitecturajava.bo.Noticia;
import com.arquitecturajava.repositorios.NoticiaRepository;
import com.arquitecturajava.test.config.ConfiguracionSpringTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ConfiguracionSpringTest.class)
public class NoticiaRepositorySpringTest {
	
	@Autowired
	NoticiaRepository repositorio;

	@Test
	public void inyectarRepositorio() {
		assertNotNull(repositorio);
	}
	
//	@Test
	public void seleccionarTodasLasNoticias() {
		Noticia noticia = repositorio.findAll().iterator().next();
		assertNotNull(noticia);
	}
	
	@Test
	public void insertarNoticia() {
//		repositorio.getEntityManager().getTransaction().begin();
		Noticia noticiaNueva = new Noticia("lo nuevo de java 8");
		repositorio.save(noticiaNueva);
//		repositorio.getEntityManager().getTransaction().commit();
		Noticia noticia = repositorio.findOne("lo nuevo de java 8");
		assertEquals(noticiaNueva, noticia);
	}

}

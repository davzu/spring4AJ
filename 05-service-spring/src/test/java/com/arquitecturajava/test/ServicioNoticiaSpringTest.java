package com.arquitecturajava.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.arquitecturajava.bo.Noticia;
import com.arquitecturajava.config.ConfiguracionSpring;
import com.arquitecturajava.repositorios.ComentarioRepository;
import com.arquitecturajava.repositorios.NoticiaRepository;
import com.arquitecturajava.servicios.ServicioNoticia;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=ConfiguracionSpring.class)
public class ServicioNoticiaSpringTest {
	
	@Autowired
	private NoticiaRepository noticiaRepository;
	@Autowired
	private ComentarioRepository comentarioRepository;
	@Autowired
	private ServicioNoticia servicioNoticia;

	@Test
	public void test() {
		assertEquals(noticiaRepository, servicioNoticia.getNoticiaRepository());
		assertEquals(comentarioRepository, servicioNoticia.getComentarioRepository());
	}
	
	@Test
	public void buscarTodasLasNoticias() {
		Iterable<Noticia> it = servicioNoticia.findAllNoticias();
		Noticia noticia = it.iterator().next();
		assertEquals("java 9 ha salido", noticia.getTitulo());
	}

	

}

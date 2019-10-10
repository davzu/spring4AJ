package com.arquitecturajava.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.arquitecturajava.bo.Noticia;
import com.arquitecturajava.repositorios.jpa.ComentarioRepositoryJPA;
import com.arquitecturajava.repositorios.jpa.NoticiaRepositoryJPA;
import com.arquitecturajava.servicios.jpa.ServicioNoticiaJPA;

public class ServicioNoticiaTest extends JPAUnitTest {
	
	private NoticiaRepositoryJPA noticiaRepository;
	private ComentarioRepositoryJPA comentarioRepository;
	private ServicioNoticiaJPA servicioNoticia;

	@Before
	public void setUp() throws Exception {
		super.setUp();
		noticiaRepository = new NoticiaRepositoryJPA();
		noticiaRepository.setEntityManager(em);
		comentarioRepository = new ComentarioRepositoryJPA();
		comentarioRepository.setEntityManager(em);
		servicioNoticia = new ServicioNoticiaJPA();
		
		servicioNoticia.setNoticiaRepository(noticiaRepository);
		servicioNoticia.setComentarioRepository(comentarioRepository);
	}

//	@Test
	public void test() {
		assertEquals(noticiaRepository, servicioNoticia.getNoticiaRepository());
		assertEquals(comentarioRepository, servicioNoticia.getComentarioRepository());
	}
	
//	@Test
	public void buscarTodasLasNoticias() {
		Iterable<Noticia> it = servicioNoticia.findAllNoticias();
		Noticia noticia = it.iterator().next();
		assertEquals("java 9 ha salido", noticia.getTitulo());
	}
	
	// en el servicio no se desea testear el acceso a base de datos, lo que se requiere es 
	// saber si se ha delegado correctamente en el repositorio
	

}

package com.arquitecturajava.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.arquitecturajava.bo.Noticia;
import com.arquitecturajava.repositorios.jpa.ComentarioRepositoryJPA;
import com.arquitecturajava.repositorios.jpa.NoticiaRepositoryJPA;
import com.arquitecturajava.servicios.jpa.ServicioNoticiaJPA;

public class ServicioNoticiaTestMock {
	
	private NoticiaRepositoryJPA noticiaRepository;
	private ComentarioRepositoryJPA comentarioRepository;
	private ServicioNoticiaJPA servicioNoticia;
	
	@Before
	public void setUp() throws Exception {
		servicioNoticia = new ServicioNoticiaJPA();
	}

	// en el servicio no se desea testear el acceso a base de datos, lo que se requiere es 
	// saber si se ha delegado correctamente en el repositorio
	
	@Test
	public void buscarTodasLasNoticias() {
		NoticiaRepositoryJPA noticiaRepositoryMock = mock(NoticiaRepositoryJPA.class);
		when(noticiaRepositoryMock.findAll()).thenReturn(Arrays.asList(new Noticia("java 9 ha salido")));
		servicioNoticia.setNoticiaRepository(noticiaRepositoryMock);
		Iterable<Noticia> it = servicioNoticia.findAllNoticias();
		Noticia noticia = it.iterator().next();
		assertEquals("java 9 ha salido", noticia.getTitulo());
	}
	

}

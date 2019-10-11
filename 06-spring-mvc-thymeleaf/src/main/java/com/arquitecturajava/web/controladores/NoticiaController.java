package com.arquitecturajava.web.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.arquitecturajava.bo.Noticia;
import com.arquitecturajava.servicios.ServicioNoticia;

@Controller
@RequestMapping("/noticias")
public class NoticiaController {
	
	@Autowired
	ServicioNoticia servicioNoticia;

	@RequestMapping("/lista")
	public String inicio(Model model) {
		
		// envia a la vista (plantilla) todas las noticias
		model.addAttribute("noticias", servicioNoticia.findAllNoticias());
		
		return "noticiaLista";
	}
	
	@RequestMapping("/noticiaFormulario")
	public String insertar(Model model) {
		model.addAttribute(new Noticia());
		
		return "noticiaFormulario";
	}
	
	@RequestMapping(value="/insertar", method=RequestMethod.POST)
	public String insertarNoticia(@ModelAttribute Noticia noticia, Model model) {
		servicioNoticia.saveNoticia(noticia);
		model.addAttribute("noticias", servicioNoticia.findAllNoticias());
		
		return "noticiaLista";
	}
	
	@RequestMapping(value="/borrarNoticia")
	public String borrarNoticia(@RequestParam("titulo") String titulo, Model model) {
		Noticia noticia = new Noticia(titulo);
		servicioNoticia.deleteNoticia(noticia);
		model.addAttribute("noticias", servicioNoticia.findAllNoticias());
		
		return "noticiaLista";
	}
	
	
}

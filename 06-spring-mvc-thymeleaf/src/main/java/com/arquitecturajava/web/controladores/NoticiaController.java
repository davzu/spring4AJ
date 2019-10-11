package com.arquitecturajava.web.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/noticias")
public class NoticiaController {

	@RequestMapping("/inicio")
	public String inicio() {
		return "inicio";
	}
	
}

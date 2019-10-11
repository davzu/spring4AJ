package com.arquitecturajava.init;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.arquitecturajava.config.ConfiguracionSpring;

public class SpringWebInicializador implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext contexto = new AnnotationConfigWebApplicationContext();
		contexto.register(ConfiguracionSpring.class);
		// spring con la web
		contexto.setServletContext(servletContext);
		
		ServletRegistration.Dynamic servlet = servletContext.addServlet("dispatcher", new DispatcherServlet(contexto));
		servlet.setLoadOnStartup(1);
		servlet.addMapping("/");
	}

}

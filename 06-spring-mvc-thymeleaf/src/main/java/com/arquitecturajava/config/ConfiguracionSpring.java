package com.arquitecturajava.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.arquitecturajava")
@Import({ConfiguracionPersistencia.class, ConfiguracionMVC.class})
public class ConfiguracionSpring  {


}

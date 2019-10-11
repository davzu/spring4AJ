package com.arquitecturajava.test.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan({"com.arquitecturajava.servicios", "com.arquitecturajava.repositorios"})
@Import({ConfiguracionPersistenciaTest.class})
public class ConfiguracionSpringTest  {


}

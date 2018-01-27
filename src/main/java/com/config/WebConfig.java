// Replacement for spring-servlet.xml

package com.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@Import(JpaConfig.class)
@EnableWebMvc
@ComponentScan(basePackages = { "com.*" })
public class WebConfig extends WebMvcConfigurerAdapter {
	
   @Override
   public void configureViewResolvers(ViewResolverRegistry registry) {
       InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
       viewResolver.setViewClass(JstlView.class);
       viewResolver.setPrefix("/WEB-INF/views/");
       viewResolver.setSuffix(".jsp");
       registry.viewResolver(viewResolver);
   }
}
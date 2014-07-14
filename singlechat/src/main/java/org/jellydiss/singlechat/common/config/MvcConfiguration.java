package org.jellydiss.singlechat.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = "org.jellydiss.singlechat")
public class MvcConfiguration extends WebMvcConfigurerAdapter {
	@Bean
	public InternalResourceViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/view/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		  registry.addResourceHandler("/assets/**")
		    .addResourceLocations("classpath:WEB-INF/assets/");
		  registry.addResourceHandler("/css/**")
		    .addResourceLocations("/css/");
		  registry.addResourceHandler("/img/**")
		    .addResourceLocations("/img/");
		  registry.addResourceHandler("/js/**")
		    .addResourceLocations("/js/");
		}
}
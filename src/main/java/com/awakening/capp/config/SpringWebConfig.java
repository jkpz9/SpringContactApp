package com.awakening.capp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 *
 * @author hoangit
 */
@Configuration
@ComponentScan(basePackages= {"com.awakening"})
@EnableWebMvc
public class SpringWebConfig extends WebMvcConfigurerAdapter{
    
    public void addResourceHanders(ResourceHandlerRegistry register)
    {
     
        register.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
    
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver vr = new InternalResourceViewResolver();
        vr.setViewClass(JstlView.class);
        vr.setPrefix("WEB-INF/view/");
        vr.setSuffix(".jsp");
        return vr;
        
    }
}

package ie.murph.sports.clinic.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    
	 private static final String[] CLASSSPATH_RESOURCE_LOCATIONS = {
	    		"classpath:/images",
	    		"classpath:/resources/images",
	    		"classpath:/css",
	    		"classpath:/resources/css"
	 };
	
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	registry.addViewController("/person").setViewName("login");
    }
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
    	registry.addResourceHandler("/**")
    			.addResourceLocations(CLASSSPATH_RESOURCE_LOCATIONS);
	}
}
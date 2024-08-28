package uz.cherevichenko.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MapModuleConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/map").setViewName("map");
        registry.addViewController("/object-details").setViewName("object-details");
        registry.addViewController("/object-3d").setViewName("object-3d");
        registry.addViewController("/object-photos").setViewName("object-photos");
        registry.addViewController("/object-videos").setViewName("object-videos");
        registry.addViewController("/object-scheme").setViewName("object-scheme");
    }
}


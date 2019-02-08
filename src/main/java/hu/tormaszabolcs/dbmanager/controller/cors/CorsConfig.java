
package hu.tormaszabolcs.dbmanager.controller.cors;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {
    private final String devUrl = "http://localhost:8080";
    private final String prodUrl= "https://front-sztorma.herokuapp.com";
    @Bean
    public FilterRegistrationBean corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration configAuthentication = new CorsConfiguration();
        configAuthentication.setAllowCredentials(true);
        //Changed from this.allowOrigin to "*" (Every domain will be allowed !!!)
        configAuthentication.addAllowedOrigin("*");
        //configAuthentication.addAllowedOrigin(devUrl);
        //configAuthentication.addAllowedOrigin(prodUrl);
        configAuthentication.addAllowedHeader("Authorization");
        configAuthentication.addAllowedHeader("Content-Type");
        configAuthentication.addAllowedHeader("Accept");
        configAuthentication.addAllowedMethod("POST");
        configAuthentication.addAllowedMethod("GET");
        configAuthentication.addAllowedMethod("DELETE");
        configAuthentication.addAllowedMethod("PUT");
        configAuthentication.addAllowedMethod("OPTIONS");
        configAuthentication.setMaxAge(3600L);

        // source.registerCorsConfiguration("/oauth/token", configAuthentication);
        source.registerCorsConfiguration("/**", configAuthentication); // Global 
        FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }

}

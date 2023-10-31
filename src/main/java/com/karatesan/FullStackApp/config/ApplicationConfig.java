package com.karatesan.FullStackApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApplicationConfig
{

    //This is global CORS config, u can also do it on method, class levels (@CrosOrigin)
    //if I add security (jwtAuthentication) I should also include :
   //         if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
    // For preflight requests, set the CORS headers and allow the request to continue without authentication.
//    response.setStatus(HttpServletResponse.SC_OK);
//    response.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");
//    response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//    response.setHeader("Access-Control-Allow-Headers", "*");
//    response.setHeader("Access-Control-Allow-Credentials", "true");
//    return;
//}
//so preflight filters won't be blocked by security
    //Links:
// https://spring.io/guides/gs/rest-service-cors/

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")
                        .allowedOrigins("http://localhost:5173")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed HTTP methods
                        .allowedHeaders("*") // Allowed request headers
                        .allowCredentials(true);
            }
        };
    }

}

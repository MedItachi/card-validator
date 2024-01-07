package org.java.mql.config;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
@Component
public class MyCorsFilter /*implements ContainerResponseFilter*/  {
//	final String HEADERS = "Origin, Content-Type, Accept";
//    final String ALLOW_ORIGIN = "Access-Control-Allow-Origin";
//    final String ALLOW_HEADERS = "Access-Control-Allow-Headers";
//    final String ALLOW_METHODS = "Access-Control-Allow-Methods";
//	 @Bean
//	    public CorsFilter corsFilter() {
//		 System.out.println("-------Corse config---------");
//	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	        CorsConfiguration config = new CorsConfiguration();
//	        // Set allowed origins, methods, and headers
//	        config.addAllowedOrigin("*");
//	        config.addAllowedMethod("*");
//	        config.addAllowedHeader("*");
//	        source.registerCorsConfiguration("/**", config);
//	        return new CorsFilter(source);
//	    }
//
//	@Override
//	public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
//			throws IOException {
//	    responseContext.getHeaders().add(ALLOW_ORIGIN, "*");
//	    responseContext.getHeaders().add(ALLOW_HEADERS, HEADERS);
//	    responseContext.getHeaders().add(ALLOW_METHODS, "GET, POST, PUT, DELETE, OPTIONS, HEAD");
//	    
//	}
	
	 @Bean
	    public CorsFilter corsFilter() {
	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	        CorsConfiguration config = new CorsConfiguration();
	     //   config.addAllowedOrigin("http://localhost:3000"); 
	        config.addAllowedOrigin("*");
	        config.addAllowedMethod("*");
	        config.addAllowedHeader("*");
	        source.registerCorsConfiguration("/**", config);
	        return new CorsFilter(source);
	    }

}

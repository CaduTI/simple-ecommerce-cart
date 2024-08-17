package br.com.carlos.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.carlos.serialization.converter.YamlJacksonToHttpMessageConverter;

public class WebConfig implements WebMvcConfigurer{
	
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new YamlJacksonToHttpMessageConverter());
	}

	private static final MediaType MEDIA_TYPE_APPLICATION_YML = MediaType.valueOf("application/x-yaml");
	
	@Value("${cors.originPatterns:default}")
	private String corsOriginPatterns = "";
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		var allowedOrigins = corsOriginPatterns.split(",");
		registry.addMapping("/**")
			//.allowedMethods("GET", "POST", "PUT")
			.allowedMethods("*")
			.allowedOrigins(allowedOrigins)
		.allowCredentials(true);
	}
	public void configurerContentNegotiation(ContentNegotiationConfigurer configurer) {
		//Via Query param na url da API Exemplo GET: http://localhost:8080/pessoa/d45ff35f-c0d3-4a1b-b1e6-80f1c96a24a5?MediaType=xml
		/*configurer.favorParameter(true)
		.parameterName("mediaType").ignoreAcceptHeader(true)
		.useRegisteredExtensionsOnly(false)
		.defaultContentType(MediaType.APPLICATION_JSON)
		.mediaType("json", MediaType.APPLICATION_JSON)
		.mediaType("xml", MediaType.APPLICATION_XML); */
	
		
		//Via Header param na url da API 
		configurer.favorParameter(false)
		.ignoreAcceptHeader(false)
		.useRegisteredExtensionsOnly(false)
		.defaultContentType(MediaType.APPLICATION_JSON)
			.mediaType("json", MediaType.APPLICATION_JSON)
			.mediaType("xml", MediaType.APPLICATION_XML)
			.mediaType("x-yaml", MEDIA_TYPE_APPLICATION_YML);
	}

}

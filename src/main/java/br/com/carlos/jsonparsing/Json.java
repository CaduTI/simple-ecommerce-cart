package br.com.carlos.jsonparsing;

import java.io.IOException;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class Json {
	private static ObjectMapper objectMapper =  getDefaultObJectMapper();
	
	public static ObjectMapper getDefaultObJectMapper() {
		ObjectMapper defaultObjectMapper = new ObjectMapper();
		return defaultObjectMapper;
	}
	
	public static JsonNode parse(String src) throws IOException{
		return objectMapper.readTree(src);
	}
	
	public static <A> A fromJson(JsonNode node, Class<A> absClass) throws JsonProcessingException{
		return objectMapper.treeToValue(node, absClass);
		
	}
	
	public JsonNode toJson(Object stringList) {
	return objectMapper.valueToTree(stringList);
	}
}

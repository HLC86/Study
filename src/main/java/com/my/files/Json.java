package com.my.files;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class Json {

	class A {
		public int i = 0;
	}

	public static void main(String[] args) {
		A a = new Json().new A();
		Object o = a;
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter typedWriter = mapper.writerWithType(mapper.getTypeFactory().constructType(o.getClass()));
		try {
			String sdiJson = typedWriter.writeValueAsString(o);
			System.out.println(sdiJson);
		} catch (JsonGenerationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}

}

package com.exam.petstore.testdata;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.exam.petstore.autobject.Pet;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class PetDataFactory {
	

	
	public Pet getPetInfo()
	{
		
		  Pet pet; 
		  try { 
			  
			  ObjectMapper objectMapper = new ObjectMapper();
		  pet = objectMapper.readValue(new File("src/test/java/com/exam/petstore/testdata/dog.json"), Pet.class);
		  
		  } catch(JsonParseException e) { 
			  System.out.println(e.getMessage()); return
		  null;
		  
		  } catch(JsonMappingException e) { 
			  System.out.println(e.getMessage()); return
		  null;
		  
		  } catch(IOException e) { 
			  System.out.println(e.getMessage()); return null;
		  
		  }
		  
		  return pet;
		 
	}
}

package com.exam.petstore.testdata;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.exam.petstore.autobject.Pet;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import com.poiji.option.PoijiOptions.PoijiOptionsBuilder;

public class PetDataFactory {
	
	public List<PetExcel> getPetInformation()
	{
		String filePath = "src/test/java/com/exam/petstore/testdata/PetStore.xlsx";
		File file = new File(filePath);
		List<PetExcel> petList = getSheet(file,PetExcel.class,"PetInformation");	

		return petList;
		
	}
	
	private <T> List<T> getSheet(File excellFile, Class<T> clazz, String sheetName) {
		PoijiOptions option = PoijiOptionsBuilder.settings().sheetName(sheetName).preferNullOverDefault(true).build();
		List<T> listFromNamedSheet = Poiji.fromExcel(excellFile, clazz, option);
		return listFromNamedSheet;
	}
	
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

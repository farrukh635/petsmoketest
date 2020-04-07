package com.exam.petstore.testcases;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.exam.petstore.autinterface.PetStoreClient;
import com.exam.petstore.autobject.Pet;
import com.exam.petstore.testdata.PetDataFactory;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;



public class Validate_UpdatePetInfo_Test {
	
	  PetDataFactory petDataFactory;
	  Pet pet;
	  Pet petResponse;
	  
	  @Before
	  public void setup()
	  {
		  RestAssured.baseURI = "https://petstore.swagger.io";
		  petDataFactory = new PetDataFactory();
		  pet = petDataFactory.getPetInfo();
		 
		 
	  }
	
	@Test
	public void validate_update_pet_info()
	{		
		 petResponse =  RestAssured.given().body(pet).contentType(ContentType.JSON).request("PUT","/v2/pet").then().assertThat().extract().as(Pet.class);
		 Response response = RestAssured.given().body(changepetInfo()).contentType(ContentType.JSON).request("PUT","/v2/pet");
		 
		 assertEquals("Wrong response status returned",200,response.getStatusCode());
		 assertTrue(pet.equals(response.getBody().as(Pet.class)));
						
	}
	
	
	@Test
	public void validate_update_pet_info_validation_failure()
	{		
		 
		 Response response = RestAssured.given().body("").contentType(ContentType.JSON).request("PUT","/v2/pet");
		 
		 assertEquals("Wrong response status returned",405,response.getStatusCode());
						
	}
	
	
	@Test
	public void validate_update_pet_info_invalid_pet_info()
	{		
		pet.setId(787878448);
		
		 Response response = RestAssured.given().body(pet).contentType(ContentType.JSON).request("PUT","/v2/pet");
		 
		 assertEquals("Test for invalid request to update pet info failed",400,response.getStatusCode());
						
	}
	

	private Pet changepetInfo() {
		 pet.setStatus("unavailable");
		return pet;
	}


}

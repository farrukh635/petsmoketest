package com.exam.petstore.testcases;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import com.exam.petstore.autobject.Pet;
import com.exam.petstore.testdata.PetDataFactory;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;




public class Feature_AddPet_Test {

	
	  PetDataFactory petDataFactory;
	  Pet pet;
	  
	  @Before
	  public void setup()
	  {
		  RestAssured.baseURI = "https://petstore.swagger.io";
		  petDataFactory = new PetDataFactory();
		  pet = petDataFactory.getPetInfo();
	  }
	  
	  
	  @Test 
	  public void verify_Add_Pet_To_Store() {
		  assertNotNull("There is no pet information",pet);
		  Response response =  RestAssured.given().body(pet).contentType(ContentType.JSON).when().request("POST","/v2/pet");
		  assertEquals("Validation for status code failed.",200,response.getStatusCode());
	  }
	  
	  @Test 
	  public void verify_Invalid_request_Add_Pet_To_Store() {
		 
		  Response response =  RestAssured.given().body("").contentType(ContentType.JSON).when().request("POST","/v2/pet");
		  assertEquals("Validation for status code failed.",405,response.getStatusCode());
	  }

}

package com.exam.petstore.testcases;


import java.io.IOException;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.exam.petstore.autinterface.PetStoreClient;
import com.exam.petstore.autobject.Pet;
import com.exam.petstore.testdata.PetDataFactory;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Validate_AddPet_Test {

	PetDataFactory petDataFactory;
	@Autowired
	PetStoreClient petStoreClient;
	Pet pet;
	
	@Before
	public void setup()
	{
		petDataFactory = new PetDataFactory();
		pet = petDataFactory.getPetInfo();
	}

	@Test
	//@DisplayName("Validating: Adding a new Pet information to the store")
	public void verify_Add_Pet_To_Store() throws JsonParseException, JsonMappingException, IOException {
		
		// @Given: A user has a new pet information
		assertNotNull(pet);
		// @When: User submit pet information to the store
		Pet petResponse = petStoreClient.postPetInfo(pet);
		// @Then: Pet information added to the pet store     
        assertTrue( petResponse.equals(pet));
	}

}

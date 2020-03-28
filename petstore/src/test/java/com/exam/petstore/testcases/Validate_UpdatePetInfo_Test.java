package com.exam.petstore.testcases;


import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.exam.petstore.autinterface.PetStoreClient;
import com.exam.petstore.autobject.Pet;
import com.exam.petstore.testdata.PetDataFactory;


@RunWith(SpringRunner.class)
@SpringBootTest
public class Validate_UpdatePetInfo_Test {
	
	PetDataFactory petDataFactory;
	Pet pet;
	Pet petResponse;
	@Autowired
	PetStoreClient petStoreClient;
	
	@Before
	public void setup()
	{
		petDataFactory = new PetDataFactory();
		pet = petDataFactory.getPetInfo();
		pet.setId(300);
		petResponse = petStoreClient.postPetInfo(pet);
	}
	
	@Test
	public void validate_update_pet_info()
	{
		//@Given: A pet already added to the store
		assertNotNull(petResponse);
		
		//@When: User update the pet status and update the store information
		pet.setStatus("unavailable");
		petStoreClient.updatePetInfo(pet);
		
		//@Then: The store information should be updated for the pet
		Pet petUpdateResponse = getUpdatedResponse(pet.getId());
		assertNotNull(petUpdateResponse);
		assertTrue(petUpdateResponse.equals(pet));
	}

	private Pet getUpdatedResponse(Integer id) {
		Pet petUpdateRespone = petStoreClient.getPetInfo(id.toString());
		assertNotNull(petUpdateRespone);
		return petUpdateRespone;
	}

}

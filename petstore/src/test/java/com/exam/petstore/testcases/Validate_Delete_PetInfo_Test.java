package com.exam.petstore.testcases;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import com.exam.petstore.autinterface.PetStoreClient;
import com.exam.petstore.autobject.Pet;
import com.exam.petstore.testdata.PetDataFactory;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Validate_Delete_PetInfo_Test {
	
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
		pet.setId(400);
		petResponse = petStoreClient.postPetInfo(pet);
	}
	
	
	@Test
	public void validate_delete_petinfo()
	{
		//@Given: A pet already added to the store
		assertNotNull(petResponse);
		
		//@When: User delete the pet information
		petStoreClient.deletePetInfo(Integer.toString(pet.getId()));
		
		//@Then: the pet information should be delted from the store
		Pet petUpdateResponse = getUpdatedResponse(pet.getId());
		
		assertNull(petUpdateResponse);
	}
	
	private Pet getUpdatedResponse(Integer id) {
		// TODO Auto-generated method stub
		Pet petUpdateRespone = petStoreClient.getPetInfo(id.toString());
		return petUpdateRespone;
	}

}

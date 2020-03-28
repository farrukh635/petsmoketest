package com.exam.petstore.autinterface;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import com.exam.petstore.autobject.Pet;


@Service
public class PetStoreClient {
	
	RestTemplate restTemplate = new RestTemplate();
	
	public Pet postPetInfo(Pet pet) {
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> httpEntity = new HttpEntity<>(pet, httpHeaders);
		String URL = "https://petstore.swagger.io/v2/pet";
		Pet petResponse = restTemplate.postForObject(URL, httpEntity, Pet.class);
		return petResponse;
		
	}
	
	
	public void updatePetInfo(Pet pet) {
		String URL = "https://petstore.swagger.io/v2/pet";
		restTemplate.put(URL, pet);
	}
	
	
	public Pet getPetInfo(String petId) {
		String URL = "https://petstore.swagger.io/v2/pet/";
		HttpEntity<String> entity = new HttpEntity<>(null);
		
		try {
			ResponseEntity<Pet> petResponse = restTemplate.exchange("https://petstore.swagger.io/v2/pet/".concat(petId), HttpMethod.GET,entity,Pet.class);
			return petResponse.getBody();	
		}
		catch(HttpClientErrorException clientError)
		{
			return null;
			
		}
		
		
	}
	
	
	public void deletePetInfo(String petId) {
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.set("api_key", "api_key");
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		String URL = "https://petstore.swagger.io/v2/pet/".concat(petId);
		restTemplate.delete(URL);
	}
	
}

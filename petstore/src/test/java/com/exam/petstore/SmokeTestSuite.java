package com.exam.petstore;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

import com.exam.petstore.testcases.Validate_AddPet;
import com.exam.petstore.testcases.Validate_Delete_PetInfo;
import com.exam.petstore.testcases.Validate_UpdatePetInfo;

@RunWith(Suite.class)
@Suite.SuiteClasses({Validate_AddPet.class,Validate_Delete_PetInfo.class,Validate_UpdatePetInfo.class})
@SpringBootTest
public class SmokeTestSuite 
{
	
}


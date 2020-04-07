package com.exam.petstore;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.springframework.boot.test.context.SpringBootTest;

import com.exam.petstore.testcases.Feature_AddPet_Test;
import com.exam.petstore.testcases.Validate_Delete_PetInfo_Test;
import com.exam.petstore.testcases.Validate_UpdatePetInfo_Test;

@RunWith(Suite.class)
@Suite.SuiteClasses({Feature_AddPet_Test.class,Validate_Delete_PetInfo_Test.class,Validate_UpdatePetInfo_Test.class})
@SpringBootTest
public class SmokeTestSuite 
{
	
}


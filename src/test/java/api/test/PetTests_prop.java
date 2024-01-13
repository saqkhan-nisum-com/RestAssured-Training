package api.test;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetEndPoints_prop;
import api.payload.Pet;
import api.payload.Pet.Status;
import io.restassured.response.Response;



public class PetTests_prop {
	
	Faker faker;
	Pet petPayload;
		
//	public Logger logger_pet;
	@BeforeTest
	public void setup() {
		
		faker = new Faker();
		petPayload = new Pet();
		
		petPayload.setId(faker.idNumber().hashCode());
		petPayload.setCategory_id(faker.idNumber().hashCode());
		petPayload.setCategory_name(faker.name().name());
		petPayload.setName(faker.name().name());
		petPayload.setPhoto_url(faker.file().fileName());
		petPayload.setTag_id(faker.idNumber().hashCode());
		petPayload.setTag_name(faker.name().name());
		petPayload.setStatus(Status.available);
		
		
//		logger_pet = LogManager.getLogger(this.getClass());	
	}

	@Test(priority=1)
	public void testPostPet() {
//		logger_pet.info("*****Creating Pet*****");
		Response response = PetEndPoints_prop.createPet(petPayload);
		System.out.println(response);
		response.then().log().all();	
		AssertJUnit.assertEquals(response.getStatusCode(),200);	
//		logger_pet.info("*****Pet Created*****");
	}
	
	@Test(priority=2)
	public void testGetPet() {
//		logger_pet.info("*****Reading Pet Info*****");
		Response response = PetEndPoints_prop.readPet(this.petPayload.getId());
		System.out.println("Id is: "+this.petPayload.getId());
		System.out.println("Id is 2: "+petPayload.getId());
		System.out.println(response);
		System.out.println(petPayload.getCategory_name());
		
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(),200);	
//		logger_pet.info("*****Pet Info Displayed*****");
	}
	
	@Test(priority=3)
	public void testDeletePet() {
//		logger_pet.info("*****Deleting Pet Info*****");
		Response response = PetEndPoints_prop.deletePet(this.petPayload.getId());
		AssertJUnit.assertEquals(response.getStatusCode(),200);	
//		logger_pet.info("*****Pet Info Deleted*****");
	}
}

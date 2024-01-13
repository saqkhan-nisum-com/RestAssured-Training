package api.test;

import java.util.ArrayList;
import java.util.List;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.PetEndPoints_prop;
import api.endpoints.PetEndPoints_prop2;
import api.payload.Category_pet;
import api.payload.Pet;
import api.payload.Pet.Status;
import api.payload.Pet2;
import api.payload.Tag_pet;
import io.restassured.response.Response;



public class PetTests_prop2 {
	
	Faker faker;
	Pet2 petPayload2;
	Category_pet category;
	Tag_pet tag;
		
//	public Logger logger_pet;
	@BeforeTest
	public void setup() {
		
		faker = new Faker();
		petPayload2 = new Pet2();
		category = new Category_pet();
		tag = new Tag_pet();
		
		
		category.setId(faker.number().randomNumber());
        category.setName(faker.lorem().word());
        tag.setId(faker.number().randomNumber());
        tag.setName(faker.lorem().word());
        
        List<Tag_pet> tagsList = new ArrayList<Tag_pet>();
        tagsList.add(tag);

        List<String> photoUrls = new ArrayList<String>();
        photoUrls.add(faker.internet().image());
        
        petPayload2.setId(faker.number().randomNumber());
        petPayload2.setCategory(category);
        petPayload2.setName(faker.animal().name());
        petPayload2.setPhotoUrls(photoUrls);
        petPayload2.setTags(tagsList);
        petPayload2.setStatus(faker.options().option("available", "pending", "sold"));

        
		
		
//		logger_pet = LogManager.getLogger(this.getClass());	
	}

	@Test(priority=1)
	public void testPostPet() {
//		logger_pet.info("*****Creating Pet*****");
		Response response = PetEndPoints_prop2.createPet(petPayload2);
		System.out.println(response);
		response.then().log().all();	
		AssertJUnit.assertEquals(response.getStatusCode(),200);	
//		logger_pet.info("*****Pet Created*****");
	}
	
	@Test(priority=2)
	public void testGetPet() {
//		logger_pet.info("*****Reading Pet Info*****");
		Response response = PetEndPoints_prop2.readPet(this.petPayload2.getId());
		System.out.println("Id is: "+this.petPayload2.getId());
		System.out.println("Id is 2: "+petPayload2.getId());
		System.out.println(response);
		System.out.println(petPayload2.getCategory());
		
		response.then().log().all();
		AssertJUnit.assertEquals(response.getStatusCode(),200);	
//		logger_pet.info("*****Pet Info Displayed*****");
	}
	
	@Test(priority=3)
	public void testDeletePet() {
//		logger_pet.info("*****Deleting Pet Info*****");
		Response response = PetEndPoints_prop2.deletePet(this.petPayload2.getId());
		AssertJUnit.assertEquals(response.getStatusCode(),200);	
//		logger_pet.info("*****Pet Info Deleted*****");
	}
}

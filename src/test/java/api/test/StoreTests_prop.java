package api.test;

import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndpoints_prop;
import api.payload.Pet;

import api.payload.Store;
import io.restassured.response.Response;


public class StoreTests_prop {

	Faker faker;
	Store storePayload;
	Pet petPayload;
	
	@BeforeTest
	public void setup() {
		
		faker = new Faker();
		petPayload = new Pet();
		storePayload = new Store();
		
		storePayload.setId(faker.number().randomDigit());
		petPayload.setId(faker.number().randomDigit());
		storePayload.setQuantity(faker.number().randomDigit());
//		storePayload.setShipDate(faker.date().future(30, java.util.concurrent.TimeUnit.DAYS).toInstant()
//                .atZone(java.time.ZoneId.systemDefault()).toLocalDateTime());
		storePayload.setStatus(faker.options().option("placed","approved","delivered"));
		storePayload.setisComplete(faker.bool().bool());
		
	}
	
	@Test(priority=1)
	public void testPostStore() {
		Response response = StoreEndpoints_prop.createStore(storePayload);
		response.then().log().all();	
		AssertJUnit.assertEquals(response.getStatusCode(),200);	
	}
	
	@Test(priority=2)
	public void testGetStore() {
		Response response = StoreEndpoints_prop.readStore(this.storePayload.getId());
		response.then().log().all();	
		AssertJUnit.assertEquals(response.getStatusCode(),200);	
	}
	
	@Test(priority=3)
	public void testDeleteStore() {
		Response response = StoreEndpoints_prop.deleteStore(this.storePayload.getId());		
		AssertJUnit.assertEquals(response.getStatusCode(),200);	
	}
	
}

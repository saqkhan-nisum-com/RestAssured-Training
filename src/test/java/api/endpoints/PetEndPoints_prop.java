package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.Pet;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetEndPoints_prop {

	public static ResourceBundle getURL() {
		
		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	public static Response createPet(Pet pet_payload) {

		String post_pet_url = getURL().getString("post_pet_url");
		System.out.println(post_pet_url);
		System.out.println(pet_payload);
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(pet_payload)
				.when()
				.post(post_pet_url);
		
		return response;
	}

	public static Response readPet(int petId) {

		String get_pet_url = getURL().getString("get_pet_url");
		System.out.println(petId);
		Response response = given()
				.pathParam("petId", petId)
				.when()
				.get(get_pet_url);

		return response;
	}
	
	public static Response deletePet(int petId){

		String delete_pet_url = getURL().getString("delete_pet_url");
		
		Response response = given()
				.pathParam("petId", petId)
				.when()
				.delete(delete_pet_url);

		return response;

	}
	
	
}

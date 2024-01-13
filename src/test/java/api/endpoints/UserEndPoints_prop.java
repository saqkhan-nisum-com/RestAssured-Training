package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;

//For CRUD operations Create, Read, Update and Delete

public class UserEndPoints_prop {

		//Load properties file
	
		static ResourceBundle getURl(){
			
		//load properties file -> exact location not required as it will directly look into src/test/resources
			ResourceBundle routes = ResourceBundle.getBundle("routes"); 
			return routes;
		}
		
		public static Response createUser(User payload){
			
			String post_url = getURl().getString("post_url");
			System.out.println(payload);

			Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(payload)
			.when()
				.post(post_url);
			
			return response;
			
		}
		
		public static Response readUser(String username){

			String get_url = getURl().getString("get_url");
			
			Response response = given()
					.pathParam("username", username)
					.when()
					.get(get_url);

			return response;

		}
		
		public static Response updateUser(String username, User payload){

			String put_url = getURl().getString("put_url");
			
			Response response = given()
					.contentType(ContentType.JSON)
					.accept(ContentType.JSON)
					.pathParam("username", username)
					.body(payload)
				.when()
					.put(put_url);
				
				return response;

		}
		
		public static Response deleteUser(String username){

			String delete_url = getURl().getString("delete_url");
			
			Response response = given()
					.pathParam("username", username)
					.when()
					.delete(delete_url);

			return response;

		}
	
}

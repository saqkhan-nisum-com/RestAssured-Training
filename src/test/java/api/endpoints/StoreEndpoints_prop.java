package api.endpoints;

import java.util.ResourceBundle;

import api.payload.Store;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;


import io.restassured.http.ContentType;

public class StoreEndpoints_prop {

	public static ResourceBundle getURL() {

		ResourceBundle routes = ResourceBundle.getBundle("routes");
		return routes;
	}
	
	public static Response createStore(Store store_payload) {
		
		String post_store_url = getURL().getString("post_store_url");
		
		Response response = given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
				.body(store_payload)
				.when()
				.post(post_store_url);
		
		return response;
	}
	
	public static Response readStore(int orderId) {
		
		String get_store_url = getURL().getString("get_store_url");
		
		Response response = given()
				.pathParam("orderId", orderId)
				.when()
				.get(get_store_url);
		
		return response;
	}
	
	public static Response deleteStore(int orderId) {
		
		String delete_store_url = getURL().getString("delete_store_url");
		Response response = given()
				.pathParam("orderId", orderId)
				.when()
				.delete(delete_store_url);
		
		return response;
	}
	
}

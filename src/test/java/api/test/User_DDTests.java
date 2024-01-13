package api.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class User_DDTests {
	
	@Test(priority = 1, dataProvider = "Data", dataProviderClass = DataProviders.class)
	public void testPostUser(String userId, String userName, String	firstName, String lastName, String email, String password, String phone) 
	
	{	
		//Creating the payload
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userId));
		userPayload.setUsername(userName);
		userPayload.setFirstName(firstName);
		userPayload.setLastName(lastName);
		userPayload.setEmail(email);
		userPayload.setPassword(password);
		userPayload.setPhone(phone);
		
		//Sending the request
		Response response = UserEndPoints.createUser(userPayload);	
		AssertJUnit.assertEquals(response.getStatusCode(),200);			
	}
	
	
	@Test(priority = 2, dataProvider = "UserNames", dataProviderClass = DataProviders.class)
	public void testDeleteUserByName(String userName) 
	
	{	
		//Sending the request
		Response response = UserEndPoints.deleteUser(userName);
		AssertJUnit.assertEquals(response.getStatusCode(),200);	
	}

}

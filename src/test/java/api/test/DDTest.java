package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDTest {

	@Test(priority = 1 , dataProvider = "Data" , dataProviderClass = DataProviders.class)
	public void testPostuser(String id , String name , String tname) {
		
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(id));
		userPayload.setName(name);
		userPayload.setTname(tname);
		
		Response response = UserEndPoints.createUser(userPayload);
		Assert.assertEquals(response.getStatusCode(), 201);
	}
	
	@Test(priority = 2 , dataProvider = "userId" , dataProviderClass = DataProviders.class)
	public void testgetuser(Integer id) {
		
		Response response = UserEndPoints.readUser(id);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 3 , dataProvider = "userId" , dataProviderClass = DataProviders.class)
	public void testdeleteuser(Integer id) {
		
		Response response = UserEndPoints.deleteUser(id);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
}

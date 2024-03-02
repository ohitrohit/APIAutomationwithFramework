package api.test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest {

	Faker faker;
	User userPayload;
	
	@BeforeClass
	public void setupData() {
		
		faker = new Faker();
		userPayload = new User();
		
		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setName(faker.animal().name());
		userPayload.setTname(faker.name().username());
		
	}
	
	@Test(priority = 1)
	public void testpostUser() {
		
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 201);
		
	}
	@Test(priority = 2)
	public void testgetUser() {
		
		Response response = UserEndPoints.readUser(this.userPayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	@Test(priority = 3)
	public void testupdateUser() {
		
		userPayload.setTname(faker.name().username());
		Response response = UserEndPoints.updateUser(this.userPayload.getId(),userPayload );
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		Response responseAfterUpdate = UserEndPoints.readUser(this.userPayload.getId());
		response.then().log().all();
		Assert.assertEquals(responseAfterUpdate.getStatusCode(), 200);
				
	}
	@Test(priority = 4)
	public void testdeleteUser() {
		Response response = UserEndPoints.deleteUser(this.userPayload.getId());
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}

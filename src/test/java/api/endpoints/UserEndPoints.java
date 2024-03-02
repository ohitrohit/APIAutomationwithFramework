package api.endpoints;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class UserEndPoints {

	public static Response createUser(User payload) {
		
	     Response response = given()
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .body(payload)
		  
		.when()
		  .post(Routes.base_url);
	     
	    return response;
	}
	
	public static Response readUser(int id) {
		
	     Response response = given()
		      .pathParam("id", id)
		  
		.when()
		  .get(Routes.get_url);
	     
	    return response;
	}
	
	public static Response updateUser(int id,User payload) {
		
	     Response response = given()
		  .contentType(ContentType.JSON)
		  .accept(ContentType.JSON)
		  .pathParam("id", id)
		  .body(payload)
		  
		.when()
		  .put(Routes.put_url);
	     
	    return response;
	}
	
	public static Response deleteUser(int id) {
		
	     Response response = given()
		      .pathParam("id", id)
		  
		.when()
		  .delete(Routes.delete_url);
	     
	    return response;
	}
	
	
	
	
	
}

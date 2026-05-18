package endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.User;
public class UserEndPoints {

	
	//public static String token;
	
	public static Response PostBooking(User payload)
	{
		Response res = given()
	            .contentType(ContentType.JSON)
	            //.accept(ContentType.JSON)
	           // .header("Cookie", "token=" + token)   
	            .body(payload)
	    .when()
	            .post(Routes.post_URL);               

	    return res;

		
       }
	
	
	public static Response GetBooking(int id)
	{
		Response res=given()
		.pathParam("id", id)
		.when()
		.get(Routes.get_ID_URL);
		
		return res;
		
		
	}
	
	
	public static Response updateBooking(User payload,int id)
	{
		
		//String token =login.createToken();
		Response res = given()
	            .contentType(ContentType.JSON)
	            .pathParam("id", id)
	            .header("Cookie", "token=" + login.createToken()) 
	            .body(payload)
	    .when()
	            .put(Routes.put_URL);               

	    return res;
	}
	
	
	public static Response patchBooking(User payload,int id)
	{
		
		//String token =login.createToken();
		Response res = given()
	            .contentType(ContentType.JSON)
	            .pathParam("id", id)
	            .header("Cookie", "token=" + login.createToken()) 
	            .body(payload)
	    .when()
	            .patch(Routes.patch_URL);               

	    return res;
	}
	
	
	public static Response deleteBooking(int id)
	{
		
		//String token =login.createToken();
		Response res = given()
	            .contentType(ContentType.JSON)
	            .pathParam("id", id)
	            .header("Cookie", "token=" + login.createToken()) 
	            
	    .when()
	            .delete(Routes.delete_URL);               

	    return res;
	}
	
	
	
	
}

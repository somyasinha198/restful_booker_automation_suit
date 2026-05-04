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
	
	
	
	
/*	public static String createToken()
	{
		Response res = given()
                .contentType("application/json")
                .body("{\"username\":\"admin\",\"password\":\"password123\"}")
        .when()
                .post("https://restful-booker.herokuapp.com/auth");

       String token=res.jsonPath().getString("token");
       // return token;
        
        System.out.println("token beig passed--------"+  token);
		return token;


	}*/
	
	
	
}

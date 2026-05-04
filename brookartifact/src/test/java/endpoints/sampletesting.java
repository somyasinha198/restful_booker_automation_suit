package endpoints;

import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.User;

public class sampletesting {
	
	

    
    
	
	@Test
	public static void PostBooking()
	
	
	{
		
		// ✅ Inner map for bookingdates
		Map<String, String> bookingDates = new HashMap<>();
		bookingDates.put("checkin", "2026-06-01");
		bookingDates.put("checkout", "2026-06-10");

		// ✅ Outer map for booking payload
		Map<String, Object> payload = new HashMap<>();
		payload.put("firstname", "Alice");
		payload.put("lastname", "Johnson");
		payload.put("totalprice", 250);
		payload.put("depositpaid", false);
		payload.put("bookingdates", bookingDates);
		payload.put("additionalneeds", "Dinner");
	    
		Response res = given()
	            .contentType(ContentType.JSON)
	            //.accept(ContentType.JSON)
	           // .header("Cookie", "token=" + token)   
	            .body(payload)
	    .when()
	            .post("https://restful-booker.herokuapp.com/booking");
		
		//res.then().log().all();
		res.then().statusCode(200);
		
		
		//return res;               

	    //return res;

		
       }

}

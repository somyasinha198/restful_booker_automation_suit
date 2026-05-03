package endpoints;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import payload.User;
public class UserEndPoints {

	
	public Response createUser(User Payload)
	{
		Response res=given()
		
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(Payload)
		.when()
		.get(Routes.post_URL);
		
         return res;
		
       }
	
	
	
}

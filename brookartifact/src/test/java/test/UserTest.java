package test;

import java.text.SimpleDateFormat;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import endpoints.UserEndPoints;
import io.restassured.response.Response;
import payload.User;

public class UserTest {
	
	
	//String token=UserEndPoints.createToken();
	
	
	public static int id;
	Faker fake;
	User payload;
	
	@BeforeClass
	public void setupdata()
	{
		fake=new Faker();
		payload=new User();
		
		payload.setFirstname(fake.name().firstName());
		payload.setLastname(fake.name().lastName());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		User.BookingDates bookingDates = new User.BookingDates();
		bookingDates.setCheckin("2018-01-01");
		bookingDates.setCheckout("2019-01-01");
		payload.setBookingdates(bookingDates);



        payload.setTotalprice(fake.number().numberBetween(100, 900));
        payload.setDepositpaid(fake.bool().bool());
        payload.setAdditionalneeds(fake.food().dish());


	}
	
	
	
	@Test(priority=1)
	public void TestCreateBooking()
	{
		
		//System.out.println("token being passed---------"+ token);
		Response res=UserEndPoints.PostBooking(payload);
		res.then().statusCode(200);
		res.then().log().all();
		id=res.jsonPath().get("bookingid");
		
		System.out.println("id is:"+id);
		
	}
	
	
	
	@Test(priority=2)
	public void TestGetBookingwithid()
	{
		Response res=UserEndPoints.GetBooking(id);
		res.then().statusCode(200);
		res.then().log().all();
	}
	
	
	@Test(priority=3)
	public void TestupdateBooking()
	{
		fake =new Faker();
		
		payload.setFirstname(fake.name().firstName());
		payload.setLastname(fake.name().lastName());
		

        payload.setTotalprice(fake.number().numberBetween(100, 900));
       
        
        Response res=UserEndPoints.updateBooking(payload,id);
        res.then().statusCode(200);
        res.then().log().all();
        
	}
	
	
	@Test(priority=4)
	public void testPartialUpdateBooking()
	{
		
fake =new Faker();
		
		payload.setFirstname(fake.name().firstName());
		payload.setLastname(fake.name().lastName());
		
		 Response res=UserEndPoints.patchBooking(payload,id);
	        res.then().statusCode(200);
	        res.then().log().all();
	        
		
		
		
	}

	@Test(priority=5)
	public void testdeleteBooking()
	{
		

		
		 Response res=UserEndPoints.deleteBooking(id);
	        res.then().statusCode(201);
	        res.then().log().all();
	        
		
		
		
	}
}

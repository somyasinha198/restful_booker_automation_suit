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
	public void CreateBooking()
	{
		
		//System.out.println("token being passed---------"+ token);
		Response res=UserEndPoints.PostBooking(payload);
		res.then().statusCode(200);
		res.then().log().all();
		//String id=res.jsonPath().getString("id");
		
		//System.out.println("id is:"+id);
		
	}

}

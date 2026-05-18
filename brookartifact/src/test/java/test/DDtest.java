package test;

import java.text.SimpleDateFormat;

import org.testng.annotations.Test;

import endpoints.UserEndPoints;
import io.restassured.response.Response;
import payload.User;
import utilities.DataProviders;

public class DDtest {
	
	public class DDtests {
		
		User userpayload;
		
		public  int id;
		@Test(priority=1,dataProvider="Data",dataProviderClass=DataProviders.class)
		public void createst(String Firstname,String Lastname,int TotalPrice,boolean DepositPaid,String Checkin,String Checkout,String AdditionalNeeds)
		{
			userpayload=new User();
			
			
			
			userpayload.setFirstname(Firstname);
			userpayload.setLastname(Lastname);
			//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			User.BookingDates bookingDates = new User.BookingDates();
			bookingDates.setCheckin(Checkin);
			bookingDates.setCheckout(Checkout);
			userpayload.setBookingdates(bookingDates);



	        userpayload.setTotalprice(TotalPrice);
	        userpayload.setDepositpaid(DepositPaid);
	        userpayload.setAdditionalneeds(AdditionalNeeds);
	        
	        Response res=UserEndPoints.PostBooking(userpayload);
			res.then().statusCode(200);
			res.then().log().all();
			id=res.jsonPath().get("bookingid");
			
			System.out.println("id is:"+id);
			
			
		}
		
		

		/*@Test(priority=2)
		public void TestCreateBooking()
		{
			
			//System.out.println("token being passed---------"+ token);
			Response res=UserEndPoints.PostBooking(userpayload);
			res.then().statusCode(200);
			res.then().log().all();
			id=res.jsonPath().get("bookingid");
			
			System.out.println("id is:"+id);
			
		}*/


}
}

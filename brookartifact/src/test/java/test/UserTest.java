package test;

import com.github.javafaker.Faker;

import payload.User;

public class UserTest {
	
	
	Faker fake;
	User payload;
	public void setupdata()
	{
		fake=new Faker();
		
		payload=new User();
		
		payload.setFirstname(fake.name().firstName());
	}

}

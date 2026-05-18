package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException {
		
		
		//String path=System.getProperty("user.dir")+"//testData//UserData.xlxs";
		
		XLUtility xl=new XLUtility("C:\\Users\\Admin\\git\\restful_booker_automation_suit 1\\brookartifact\\TestData\\UserData1.xlsx");
		
		int rownum=xl.getRowCount("Sheet1");
		int colcount=xl.getCellCount("Sheet1", 1);
		
		String apidata[][] =new String[rownum][colcount];
		
		for(int i=1;i<rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				
				apidata[i-1][j]=xl.getCellData("Sheet1",i,j);
				
				
			}
		}
		return apidata;

}
	
	@DataProvider(name="Usernames")
	public String[] getUserNames() throws IOException
	{

		
XLUtility xl=new XLUtility("C:\\Users\\Admin\\Desktop\\summy\\practice 2026\\API Framework\\rafw\\PetStoreAutomation\\testData\\UserData.xlsx");
		
		int rownum=xl.getRowCount("Sheet1");
		
		String apidata[] =new String[rownum];
		
		for(int i=1;i<=rownum;i++)
		{
			apidata[i-1]=xl.getCellData("Sheet1", i, 1);
		}
		
		return apidata;
	}
	
	

}

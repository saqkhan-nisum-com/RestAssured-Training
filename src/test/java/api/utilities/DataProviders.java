package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "Data")
	public String[][] getAllData() throws IOException{
		//Get path of excel file
		String path = System.getProperty("user.dir")+"/testData/Userdata.xlsx";
		XLUtility xl = new XLUtility(path);

		//Getting the rows and columns by passing sheet name
		int rownum = xl.getRowCount("Sheet1");
		int colcount = xl.getCellCount("Sheet1", 1);

		//Creating 2d array with the same size of our excel sheet rows and columns
		String apidata[][] = new String[rownum][colcount];

		//Get the data from the sheet and assign the same data into the 2d array
		//Once the loop will be completed all the data will be in 2d array i.e. apidata[][]
		for(int i=1; i<=rownum; i++)
		{
			for(int j=0;j<colcount;j++) {
				apidata[i-1][j]=xl.getCellData("Sheet1", i, j);
			}
		}

		return apidata;
		
	}

	@DataProvider(name = "UserNames")
	public String[] getUserNames() throws IOException{
		//Get path of excel file
		String path = System.getProperty("user.dir")+"/testData/Userdata.xlsx";
		XLUtility xl = new XLUtility(path);
		
		//Getting the rows by passing sheet name
		int rownum = xl.getRowCount("Sheet1");
		
		//Creating 2d array with the same size of our excel sheet rows and columns
		String apidata[] = new String[rownum];
		
		//Get the data from the sheet and assign the same data into the 2d array
		//Once the loop will be completed all the data will be in 2d array i.e. apidata[][]
		for(int i=1; i<=rownum; i++)
		{
			apidata[i-1]=xl.getCellData("Sheet1", i, 1);
			
		}
		
		return apidata;
		
	}
}

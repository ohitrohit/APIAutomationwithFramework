package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException{
		String path =System.getProperty("user.dir")+"//testData//data2.xlsx";
		XLUtility x1 = new XLUtility(path);
		
		int rownum = x1.getRowCount("Sheet1");
		int colcount = x1.getCellCount("Sheet1", 1);
		
		String apidata[][]= new String[rownum][colcount];
		
		for(int i=1;i<rownum; i++) {
			for(int j=0;j<colcount; j++) {
				apidata[i-1][j]=x1.getCellData("Sheet1",i , j);
			}
		}
		return apidata;
	}
	
	@DataProvider(name="userId")
	public Integer[] getUserIds() throws IOException {
	    String path = System.getProperty("user.dir") + "//testData//data2.xlsx";
	    XLUtility x1 = new XLUtility(path);

	    int rownum = x1.getRowCount("Sheet1");
	    Integer[] userIds = new Integer[rownum];

	    for (int i = 1; i <= rownum; i++) {
	        // Assuming the ID column is at index 0, change it if needed
	        userIds[i - 1] = Integer.parseInt(x1.getCellData("Sheet1", i, 0));
	    }
	    return userIds;
	}

	
}

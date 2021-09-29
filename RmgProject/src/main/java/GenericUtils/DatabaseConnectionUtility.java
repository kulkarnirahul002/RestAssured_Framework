package GenericUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;


import com.mysql.cj.jdbc.Driver;


public class DatabaseConnectionUtility {
	Connection con;
	ResultSet result;
	Boolean flag=false;
	String Data;
	/**
	 * Below method used for Registering Driver
	 * @throws Throwable
	 */
	public void registerDriver() throws Throwable {
		Driver dbdriver= new Driver();
		DriverManager.registerDriver(dbdriver);
		con=DriverManager.getConnection(IPathConstants.Dburl, IPathConstants.Dbun,IPathConstants.Dbpwd);
		
	}
	/**
	 * below method is to execute query and return result
	 * @param query
	 * @param colIndex
	 * @param expData
	 * @return
	 * @throws Throwable
	 */
	public String executeQuery(String query,int colIndex,String expData) throws Throwable {
		
	 result=con.createStatement().executeQuery(query);
	 
	 while(result.next())
	 {
		Data=result.getString(colIndex);
		 if(Data.equals(expData))
		 {
			 flag=true;
			 break;
			 
		 }
		 else
		 {
			 flag=false;
		 }
	 }
	 
	 if(flag)
	 {
		 return Data;
	 }
	 else
	 {
		 return Data;
	 }
}
	
	/**
	 * Close db connection
	 * @throws Throwable
	 */
	public void dbClose() throws Throwable {
		con.close();
	}
	
}

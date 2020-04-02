package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utility.ConnectionManager;

public class HospitalController 
{
	public boolean validate() throws ClassNotFoundException, SQLException, IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter name and password");
		String username=br.readLine();
		String password=br.readLine();
		
		ConnectionManager con=new ConnectionManager();
		Statement st=  con.getConnection().createStatement();
		
		ResultSet rs=  st.executeQuery("select *from Hospital");
		
		while(rs.next())
		{
			
			if(username.equals(rs.getString("NAME"))&&password.equals(rs.getString("password")))
			{ 
				System.out.println("Successfully Login into Hospital services "+"\n");
				con.getConnection().close();
			    return true;
				
			}

		}
		System.out.println("Sorry wrong password or username "+"\n");
		con.getConnection().close();
		return false;

}
}

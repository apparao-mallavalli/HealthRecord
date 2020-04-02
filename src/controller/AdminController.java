package controller;

import java.sql.Statement;

import model.Admin;
import utility.ConnectionManager;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminController {
	public boolean validate(Admin admin) throws ClassNotFoundException, SQLException, IOException
	{
		String username=admin.getUserName();
		String password=admin.getPassword();
		
		ConnectionManager con=new ConnectionManager();
		Statement st=  con.getConnection().createStatement();
		
		ResultSet rs=  st.executeQuery("select *from admin");
		
		while(rs.next())
		{
			
			if(username.equals(rs.getString("ADMINNAME"))&&password.equals(rs.getString("PASSWORD")))
			{ 
				System.out.println("Successfully Login into admin services"+"\n");
				con.getConnection().close();
			    return true;
				
			}

		}
		System.out.println("Sorry wrong password or username "+"\n");
		con.getConnection().close();
		return false;
		
	}

}

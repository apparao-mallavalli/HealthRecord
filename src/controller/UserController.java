package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.User2;
import utility.ConnectionManager;

public class UserController 
{
	public boolean validate(User2 user) throws ClassNotFoundException, SQLException, IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        
		
		ConnectionManager con=new ConnectionManager();
		Statement st=  con.getConnection().createStatement();
		
		ResultSet rs=  st.executeQuery("select *from u");
		
		while(rs.next())
		{
			
			if(user.getId().equals(rs.getString("id"))&&user.getPassword().equals(rs.getString("password")))
			{ 
				System.out.println("Successfully Login into user services "+"\n");
				con.getConnection().close();
			    return true;
				
			}

		}
		System.out.println("Sorry wrong password or username"+"\n");
		con.getConnection().close();
		return false;
		
	}

}

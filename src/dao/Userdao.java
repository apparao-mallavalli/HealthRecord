package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Hospital;
import model.User;
import utility.ConnectionManager;

public class Userdao 
{
	public void insertUser(User user) throws ClassNotFoundException, SQLException, IOException
	{
		Connection con=ConnectionManager.getConnection();
		String sql="Insert into u(id,name,mobile ,password)values(?,?,?,?)";
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setString(1,user.getId());
		ps.setString(2,user.getName());
		
		ps.setString(4, user.getPassword());
		
		ps.setString(3,user.getMobile());
		int insert=ps.executeUpdate();
		if(insert>0)
			System.out.println("inserted successfully"+"\n");
		else
			System.out.println("Sorry not deleted,please check the inputs again "+"\n");
		con.close();

	}
	public void readUser(String id) throws SQLException, ClassNotFoundException, IOException
	{
		Connection con=ConnectionManager.getConnection();
		
	       java.sql.Statement stmt=  con.createStatement();
			
			ResultSet rs =stmt.executeQuery("select * from u  where u.id=id");
			
			while(rs.next())
			{
				System.out.println(rs.getString("ID")+"\t"+rs.getString("Name")+"\t"+rs.getDate("established"));
						
			}
			con.close();
	}
	
	public void updateUser(User user) throws ClassNotFoundException, SQLException, IOException
	{
		Connection con=ConnectionManager.getConnection();
		PreparedStatement statement = con.prepareStatement("update u set  name= ?, mobile =?,password = ? where Id = ?"); 
		
	       statement.setString(1,user.getName());
	       statement.setString(2,user.getMobile());
	       statement.setString(3,user.getPassword());
	       statement.setString(4,user.getId());
	       int update=  statement.executeUpdate() ;
		     if(update>0)
					System.out.println("updated successfully"+"\n");
				else
					System.out.println("Sorry not deleted,please check the inputs again "+"\n");
		
	}
	
	public void deleteUser(String i) throws ClassNotFoundException, SQLException, IOException
	{
		Connection con=ConnectionManager.getConnection();
		PreparedStatement statement = con.prepareStatement("delete from u where Id = ?"); 
		statement.setString(1, i);
		int delete=statement.executeUpdate() ;
		if(delete>0)
			System.out.println("deleted successfully"+"\n");
		else
			System.out.println("Sorry not deleted,please check the inputs again "+"\n");
		
	}
	
}

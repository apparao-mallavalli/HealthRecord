package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Hospital;
import model.UserProblem;
import utility.ConnectionManager;

public class TemporaryDAO
{
	
	public void insertRegister(Hospital hospital) throws ClassNotFoundException, SQLException, IOException
	{
		Connection con=ConnectionManager.getConnection();
		String sql="Insert into hr(id,name,password,established)values(?,?,?,?)";
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setString(1,hospital.getId());
		ps.setString(2,hospital.getName());
		ps.setString(3,hospital.getPassword());
		
		ps.setString(4,hospital.getEstablished());
		ps.executeUpdate();
		con.close();

	}
	public void insertUpdate(Hospital hospital) throws ClassNotFoundException, SQLException, IOException
	{
		Connection con=ConnectionManager.getConnection();
		String sql="Insert into hu(id,name,password,established)values(?,?,?,?)";
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setString(1,hospital.getId());
		ps.setString(2,hospital.getName());
		ps.setString(3,hospital.getPassword());
		
		ps.setString(4,hospital.getEstablished());
		ps.executeUpdate();
		con.close();

	}
	public void insertDelete(String id) throws ClassNotFoundException, SQLException, IOException
	{
		Connection con=ConnectionManager.getConnection();
		String sql="Insert into hd(id)values(?)";
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setString(1,id);
		
		ps.executeUpdate();
		con.close();

	}
	
	public List<Hospital> readRegister() throws SQLException, ClassNotFoundException, IOException
	{
		List<Hospital>  list=new ArrayList<Hospital>();
		
		Connection con=ConnectionManager.getConnection();
		
	       java.sql.Statement stmt=  con.createStatement();
			
			ResultSet rs =stmt.executeQuery("select * from hr ");
			
			while(rs.next())
			{
				
				//System.out.println(rs.getString("ID")+"\t"+rs.getString("Name")+"\t"+rs.getString("issue")+"\t"+rs.getDate("joined").toLocalDate());
				Hospital h=new Hospital(rs.getString("Id"),rs.getString("name"),rs.getString("password"),rs.getString("established"));
				list.add(h);
				
			}
			con.close();
			return list;
	}
	
	public void deleteRegister(String i) throws ClassNotFoundException, SQLException, IOException
	{
		Connection con=ConnectionManager.getConnection();
		PreparedStatement statement = con.prepareStatement("delete from hr where Id = ?"); 
		statement.setString(1, i);
		statement.executeUpdate() ;
		
	}
	
	public List<Hospital> readUpdate() throws SQLException, ClassNotFoundException, IOException
	{
		List<Hospital>  list=new ArrayList<Hospital>();
		
		Connection con=ConnectionManager.getConnection();
		
	       java.sql.Statement stmt=  con.createStatement();
			
			ResultSet rs =stmt.executeQuery("select * from hu ");
			
			while(rs.next())
			{
				
				//System.out.println(rs.getString("ID")+"\t"+rs.getString("Name")+"\t"+rs.getString("issue")+"\t"+rs.getDate("joined").toLocalDate());
				Hospital h=new Hospital(rs.getString("Id"),rs.getString("name"),rs.getString("password"),rs.getString("established"));
				list.add(h);
				
			}
			con.close();
			return list;
	}
	
	public void deleteUpdate(String i) throws ClassNotFoundException, SQLException, IOException
	{
		Connection con=ConnectionManager.getConnection();
		PreparedStatement statement = con.prepareStatement("delete from hu where Id = ?"); 
		statement.setString(1, i);
		statement.executeUpdate() ;
		
	}
	public List<String> readDelete() throws SQLException, ClassNotFoundException, IOException
	{
		List<String>  list=new ArrayList<String>();
		
		Connection con=ConnectionManager.getConnection();
		
	       java.sql.Statement stmt=  con.createStatement();
			
			ResultSet rs =stmt.executeQuery("select * from hd ");
			
			while(rs.next())
			{
				
				//System.out.println(rs.getString("ID")+"\t"+rs.getString("Name")+"\t"+rs.getString("issue")+"\t"+rs.getDate("joined").toLocalDate());
				//Hospital h=new Hospital(rs.getString("Id"),rs.getString("name"),rs.getString("password"),rs.getString("established"));
				String id=rs.getString("id");
				list.add(id);
				
			}
			con.close();
			return list;
	}
	
	public void deleteDelete(String i) throws ClassNotFoundException, SQLException, IOException
	{
		Connection con=ConnectionManager.getConnection();
		PreparedStatement statement = con.prepareStatement("delete from hu where Id = ?"); 
		statement.setString(1, i);
		statement.executeUpdate() ;
		
	}
	
	public void insertUserProblem(UserProblem userproblem) throws ClassNotFoundException, SQLException, IOException
	{
		Connection con=ConnectionManager.getConnection();
		String sql="Insert into userProblem(id,message,posted)values(?,?,?)";
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setString(1,userproblem.getId());
		ps.setString(2,userproblem.getMessage());
		ps.setDate(3,java.sql.Date.valueOf(userproblem.getDate()));
		
		
		ps.executeUpdate();
		con.close();

	}
	
	public List<UserProblem> readUserProblem() throws SQLException, ClassNotFoundException, IOException
	{
		List<UserProblem>  list=new ArrayList<UserProblem>();
		
		Connection con=ConnectionManager.getConnection();
		
	       java.sql.Statement stmt=  con.createStatement();
			
			ResultSet rs =stmt.executeQuery("select * from userproblem");
			
			while(rs.next())
			{
				
				//System.out.println(rs.getString("ID")+"\t"+rs.getString("Name")+"\t"+rs.getString("issue")+"\t"+rs.getDate("joined").toLocalDate());
				//Hospital h=new Hospital(rs.getString("Id"),rs.getString("name"),rs.getString("password"),rs.getString("established"));
				UserProblem up=new UserProblem(rs.getString("id"),rs.getString("message"),rs.getDate("posted").toLocalDate());
				list.add(up);
				
			}
			con.close();
			return list;
	}
	public void deleteUserProblem(String i) throws ClassNotFoundException, SQLException, IOException
	{
		Connection con=ConnectionManager.getConnection();
		PreparedStatement statement = con.prepareStatement("delete from userproblem where Id = ?"); 
		statement.setString(1, i);
		statement.executeUpdate() ;
		
	}
	
	
	

}

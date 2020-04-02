package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Hospital;
import utility.ConnectionManager;

public class HospitalDAO
{
	public void insertHospital(Hospital hospital) throws ClassNotFoundException, SQLException, IOException
	{
		Connection con=ConnectionManager.getConnection();
		String sql="Insert into Hospital(id,name,password ,established)values(?,?,?,?)";
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setString(1,hospital.getId());
		ps.setString(2,hospital.getName());
		ps.setString(3,hospital.getPassword());
		
		ps.setString(4,hospital.getEstablished());
		int insert=ps.executeUpdate();
		if(insert>0)
			System.out.println("inserted successfully"+"\n");
		else
			System.out.println("Sorry not deleted,please check the inputs again "+"\n");
		con.close();

	}
	public void readHospital() throws SQLException, ClassNotFoundException, IOException
	{
		Connection con=ConnectionManager.getConnection();
		
	       java.sql.Statement stmt=  con.createStatement();
			
			ResultSet rs =stmt.executeQuery("select * from hospital ");
			
			while(rs.next())
			{
				System.out.println(rs.getString("ID")+"\t"+rs.getString("Name")+"\t"+rs.getDate("established"));
						
			}
			con.close();
	}
	
	public void updateHospital(Hospital hospital) throws ClassNotFoundException, SQLException, IOException
	{
		Connection con=ConnectionManager.getConnection();
		PreparedStatement statement = con.prepareStatement("update hospital set  name= ?, password =?,established = ? where Id = ?"); 
		
	       statement.setString(1,hospital.getName());
	       statement.setString(3,hospital.getEstablished());
	       statement.setString(2,hospital.getPassword());
	       statement.setString(4,hospital.getId());
	     int update=  statement.executeUpdate() ;
	     if(update>0)
				System.out.println("updated successfully"+"\n");
			else
				System.out.println("Sorry not deleted,please check the inputs again "+"\n");
		
	}
	
	public void deleteHospital(String i) throws ClassNotFoundException, SQLException, IOException
	{
		Connection con=ConnectionManager.getConnection();
		PreparedStatement statement = con.prepareStatement("delete from hd where Id = ?"); 
		statement.setString(1, i);
		int delete=statement.executeUpdate() ;
		if(delete>0)
			System.out.println("deleted successfully"+"\n");
		else
			System.out.println("Sorry not deleted,please check the inputs again "+"\n");
	}
}
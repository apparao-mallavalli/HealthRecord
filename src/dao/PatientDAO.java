package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Patient;
import utility.ConnectionManager;

public class PatientDAO 
{
	public void insertPatient(Patient patient) throws ClassNotFoundException, SQLException, IOException
	{
		Connection con=ConnectionManager.getConnection();
		String sql="Insert into Patient(id,name,issue,joined)values(?,?,?,?)";
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setString(1,patient.getId());
		ps.setString(2,patient.getName());
		ps.setString(3,patient.getIssueId());
		ps.setDate(4,java.sql.Date.valueOf(patient.getDate()));
		int insert=ps.executeUpdate();
		if(insert>0)
			System.out.println("inserted successfully"+"\n");
		else
			System.out.println("Sorry not deleted,please check the inputs again "+"\n");
		
		con.close();

	}
	public void readPatient(String p) throws SQLException, ClassNotFoundException, IOException
	{
		Connection con=ConnectionManager.getConnection();
		
	       java.sql.Statement stmt=  con.createStatement();
			
			ResultSet rs =stmt.executeQuery("select * from patient  ");
			
			while(rs.next())
			{
				if(p.equalsIgnoreCase(rs.getString("id")))
				
				System.out.println(rs.getString("ID")+"\t"+rs.getString("Name")+"\t"+rs.getString("issue")+"\t"+rs.getDate("joined").toLocalDate());
						
			}
			con.close();
	}
	
	public void updatePatient(Patient patient ) throws ClassNotFoundException, SQLException, IOException
	{
		Connection con=ConnectionManager.getConnection();
	PreparedStatement statement = con.prepareStatement("update patient set  name= ?,joined= ? where Id = ? and issue =?"); 
		
	       statement.setString(1,patient.getName());
	       statement.setString(4,patient.getIssueId());
	       statement.setDate(2,java.sql.Date.valueOf(patient.getDate()));
	       statement.setString(3,patient.getId());
	       int update=  statement.executeUpdate() ;
		     if(update>0)
					System.out.println("updated successfully"+"\n");
				else
					System.out.println("Sorry not deleted,please check the inputs again "+"\n");
		
	}
	
	public void deletePatient(String p,String pp) throws ClassNotFoundException, SQLException, IOException
	{
		Connection con=ConnectionManager.getConnection();
		PreparedStatement statement = con.prepareStatement("delete from patient where Id = ? and issue =?"); 
		statement.setString(1, p);
		statement.setString(2, pp);
		int delete=statement.executeUpdate() ;
		if(delete>0)
			System.out.println("deleted successfully"+"\n");
		else
			System.out.println("Sorry not deleted,please check the inputs again "+"\n");
	}
	
}

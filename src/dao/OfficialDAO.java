package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Official;
import utility.ConnectionManager;

public class OfficialDAO 
{
	
	private static final String INSERT_OFFICIAL_SQL = "INSERT INTO OFFICIAL"
			+ "  (id, name, designation) VALUES " + " ( ?, ?, ?)";

	private static final String SELECT_OFIICIAl_ID = "select Id,name,designation from official where Id =?";
	private static final String SELECT_ALL_OFFICIAL = "select * from official";
	private static final String DELETE_OFFICIAL_BY_ID = "delete from official where Id = ?";
	private static final String UPDATE_OFFICIAL = "update official set name = ?, designation = ? where Id = ?";

	

	public void insertOfficial(Official official) throws ClassNotFoundException, IOException {
		//System.out.println(INSERT_OFFICIAL_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = ConnectionManager.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_OFFICIAL_SQL)) {
			preparedStatement.setString(1, official.getId());
			preparedStatement.setString(2,official.getName() );
			preparedStatement.setString(3, official.getDesignation());
			
			
			//System.out.println(preparedStatement);
		int inserted=	preparedStatement.executeUpdate();
			if(inserted>0)
				System.out.println("inserted successfully"+"\n");
			else
				System.out.println("Sorry not deleted,please check the inputs again "+"\n");
			
			
		} catch (SQLException exception) {
			System.out.println(exception);
		}
	
		
	}

	
	public void selectOfficial(String Id) throws ClassNotFoundException, IOException {
		
		
		// Step 1: Establishing a Connection
		try (Connection connection = ConnectionManager.getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_OFIICIAl_ID)) {
			
			//System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String id = rs.getString("ID");
				String name = rs.getString("NAME");
				String designation = rs.getString("Designation");
				
				System.out.println(id+"\t"+name+"\t"+designation);
				
				
			}
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		
	}


	public void selectAllOfficial() throws ClassNotFoundException, IOException {
		 
		// using try-with-resources to avoid closing resources (boiler plate code)
		

		// Step 1: Establishing a Connection
		try (Connection connection = ConnectionManager.getConnection();

				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_OFFICIAL);) {
			
			//System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String id = rs.getString("Id");
				String name = rs.getString("name");
				
				String designation = rs.getString("designation");
				
				System.out.println(id+"\t"+name+"\t"+designation);
				
				
				
			}
		} catch (SQLException exception) {
			System.out.println(exception);
		}
		
	}

	public boolean deleteOfficial(String id) throws SQLException, ClassNotFoundException, IOException {
		
		
		boolean rowDeleted;
		try (Connection connection = ConnectionManager.getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_OFFICIAL_BY_ID)) {
			statement.setString(1, id);
			rowDeleted = statement.executeUpdate() > 0;
			if(rowDeleted)
				System.out.println("Deleted successfully"+"\n");
			else
				System.out.println("Sorry not deleted,please check the inputs again "+"\n");
		}
		return rowDeleted;
	}

	
	public boolean updateOfficial(Official official) throws Exception {
		boolean rowUpdated = false;
		
		try {

			Connection connection = ConnectionManager.getConnection();
			PreparedStatement statement = connection.prepareStatement(UPDATE_OFFICIAL); 
			//statement.setString(1, official.getId());
			statement.setString(1,official.getName());
			statement.setString(2, official.getDesignation());
			statement.setString(3, official.getId());
			rowUpdated = statement.executeUpdate() > 0;
		//	System.out.println(rowUpdated);
			if(rowUpdated)
				System.out.println("Updated successfully"+"\n");
			else
				System.out.println("Sorry not deleted,please check the inputs again "+"\n");
		}catch(Exception exception){
			System.out.println(exception);
		}
		return rowUpdated;
	}

}

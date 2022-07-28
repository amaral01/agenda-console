package dev.amaral.agendaconsole;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {
	private static final String URL = "jdbc:oracle:thin:@//localhost:1521/XE";
	private static final String USER = "system";
	private static final String PASSWORD = "rodrigo123";
	private static final String NAMECLASS = "oracle.jdbc.OracleDriver";
	public static class Msgs{
		private static final String LOADSUCESS = "Drive is Loaded Sucessfull";
		private static final String WARNING = "Warning";
		private static final String CONSUCESSFULL = "Connection is sucefull with";
		
	}//msg
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Contact contact1 = new Contact();
		
		contact1.setName();
		contact1.setLastName();
		contact1.setAddress();		
		contact1.setBirthDate();
		contact1.setModificationDate();
		contact1.setCellPhone();
		contact1.setPhone();
		contact1.setZipCode();
		
		contact1.setCity();
		contact1.setGender();
		contact1.report();
		insert(contact1);
		
	}// main
	public static void insert(Contact contact) {
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("	INSERT INTO TelephoneBook ("); 
		sql.append("	name,address,birthdate,modificationdate,phone,cellphone,gender)	");
		sql.append("	 VALUES (name_t (? ,? ),?,?,?, ?, ?,?);	");
		
		String query = sql.toString();
		
		Connection conn = getConection();
		
		try {
			PreparedStatement preparedStmt = conn.prepareStatement(query);
			preparedStmt.setString(1, contact.getName());
			preparedStmt.setString(2, contact.getLastName());
			preparedStmt.setString(3, contact.getAddress());
			preparedStmt.setDate(4, (Date) contact.getBirthDate());
			preparedStmt.setDate(5, (Date) contact.getModificationDate());
			preparedStmt.setString(7, contact.getPhone());
			preparedStmt.setString(8, contact.getCellPhone());
			preparedStmt.setString(9, contact.getGender());
			
			preparedStmt.execute();
		      
		    conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//method insert
	public static Connection getConection() {
		try {
			Class.forName(NAMECLASS);
			Connection con = DriverManager.getConnection(URL,USER,PASSWORD);
			System.out.println(Msgs.CONSUCESSFULL);
			return con;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}//method	


	public static void consult() {
		StringBuffer sql = new StringBuffer();
		
		sql.append("select * from telephonebook"); 		
		
		String query = sql.toString();
		
		Connection conn = getConection();
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = (Statement) conn.createStatement();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			rs= ((java.sql.Statement) stmt).executeQuery(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {		      
		      while (rs.next()) {
		        int id = rs.getInt("Id");
		        String name = rs.getString("Name");
		        String lastName = rs.getString("LastName");
		        String adress = rs.getString("Adress");
		        Date birthDate = rs.getDate("BirthDate");
		        Date modificationDate = rs.getDate("ModificationDate");
		        String phone = rs.getString("phone");
		        String cellPhone = rs.getString("cellPhone");
		        String gender = rs.getString("Gender");
		        
		        
		        System.out.println(id + ", "+name + ", " + lastName + ", " + adress + ", " + birthDate+
		                           ", " + modificationDate + ", " + phone+ ", " + cellPhone +
		                           ", " + gender                           
		                           );
		      }//while
		      
		      }catch (SQLException e) {
		    	// TODO Auto-generated catch block
					e.printStackTrace();
		      }//catch
	}// method
}// class	     
	



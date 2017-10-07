package database;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLConnector {
	

	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
	static final String USER = "root";
	static final String PASS = "BratinDol14";
	public static Connection conn = null;
	public static Statement stmt = null;
	

	public void connection() {
		 try{
		      //STEP 2: Register JDBC driver
		      Class.forName("com.mysql.jdbc.Driver");

		      //STEP 3: Open a connection
		      System.out.println("Connecting to a selected database...");
		      conn = DriverManager.getConnection(DB_URL, USER, PASS);
		      System.out.println("Connected database successfully...");
		 }
		 catch(SQLException se){
		      //Handle errors for JDBC
		      se.printStackTrace();
		   }catch(Exception e){
		      //Handle errors for Class.forName
		      e.printStackTrace();
		   }
	}
	
	//public static void addUserDetails(String firstName, String lastName, String email, String password, String phoneNumber) {
		//System.out.println("Inserting records into the table...");
	    //  stmt = conn.createStatement();
	     // String sql = "INSERT into users ( f_name, l_name, email, password, phone_number) values ('" + ivan.getFirstName() + "','" + ivan.getLastName() +  "','" + ivan.getEmail() +  "','" + ivan.getPassword() +  "','" + ivan.getTelephoneNumber() +  "')";
//	}

	public static Connection getCon() {
		return conn;
	}

	public static void setCon(Connection con) {
		MySQLConnector.conn = con;
	}
	
	public static ResultSet getEmailInfo() {
		ResultSet rs = null;
		try{
	      System.out.println("Creating statement...");
	      stmt = conn.createStatement();

	      String sql = "SELECT email FROM users";
	      rs = stmt.executeQuery(sql);
	      //STEP 5: Extract data from result set
	      while(rs.next()){
	         //Retrieve by column name
	         String email = rs.getString("email");
	         
	         //Display values
//	         System.out.print("ID: " + id);
//	         System.out.print(", Age: " + age);
//	         System.out.print(", First: " + first);
//	         System.out.println(", Last: " + last);
	      }
	      rs.close();
	   }catch(SQLException se){
	      se.printStackTrace();
	   }catch(Exception e){
	      e.printStackTrace();
	   }finally{
	      try{
	         if(stmt!=null)
	            conn.close();
	      }catch(SQLException se){
	      }
	      try{
	         if(conn!=null)
	            conn.close();
	      }catch(SQLException se){
	         se.printStackTrace();
	      }
	   }
		return rs;
	}
	
}


package simple;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Sim {
	
	public static void main(String[] args) {
		
		
		try {
			
			//1. register the driver class
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. create Connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/amit", "root", "root");
			
			
			//3. Create statement 
			Statement st = con.createStatement();
			
			//4. execute Query
			ResultSet rs = st.executeQuery("select * from employee");
			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("empName");
				int age = rs.getInt("emplNo");
				
				System.out.println(id  + " " + name  + " " + age);
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
	}
}

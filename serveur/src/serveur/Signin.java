package serveur;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Signin {
	Connection conn;
	String name;
	
	public String connectBD() throws SQLException {
		
		
		conn = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/chatapp","root", "root");
		Statement stmt = conn.createStatement();
		if(conn!=null) {
			return "base de donnee est connecte";
        }
		return ("Error!");
	   
	}
	
	public String insertBD(String[] t) throws SQLException {
		Statement stmt = conn.createStatement();
		if(!verif(t[0], t[1], t[2], t[3])) {
			stmt.execute("insert into users (firstName,lastName,email,pass) values "
					+ "('"+t[0]+"','"+t[1]+"','"+t[2]+"','"+t[3]+"')");
			//id++;
			return "user added";
		}
		return "user exists";
	}
	
	public boolean verif(String fname, String lname, String email, String pass) throws SQLException {
	
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM users WHERE firstName='"+fname+"' AND lastName='"+lname+"' AND email='"+email+"' AND pass='"+pass+"'";
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next()) {
			return true;
		}else
			return false;
		
	}
	
	// partie login
	
	public String login(String[] t) throws SQLException {
		Statement stmt = conn.createStatement();
		if(verifLog(t[0], t[1])) {
			ResultSet rs = stmt.executeQuery("select * from users where email='"+t[0]+"'");
			while (rs.next()) {
				name = rs.getString("firstName");
			}
			return "welcome "+name;
		}
		return "user doesn't exist";
	}
	
	public boolean verifLog(String email, String pass) throws SQLException {
	
		Statement stmt = conn.createStatement();
		String sql = "SELECT * FROM users WHERE email='"+email+"' AND pass='"+pass+"'";
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next()) {
			return true;
		}else
			return false;
		
	}

}

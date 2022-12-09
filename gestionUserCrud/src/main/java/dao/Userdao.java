package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import user.User;


public class Userdao {

	public static Connection getconnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jee_tp","root","");
		}catch( Exception e)
		{
			System.out.println(e);
		}
		
		return connection;
	}
	
	
	public static int insertUser(User user) {
		int status = 0;
		
		try {
			
			Connection con = Userdao.getconnection();
			PreparedStatement ps = con.prepareStatement(" insert into user (nom,prenom,login,password) values (?,?,?,?)" );
			ps.setString(1, user.getNom());
			ps.setString(2, user.getPrenom());
			ps.setString(3, user.getLogin());
			ps.setString(4, user.getPassword());
			
			status = ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static void updateUser(User user) {
		
		try {
			
			Connection con = Userdao.getconnection();
			PreparedStatement ps = con.prepareStatement(" update user set  nom=?,prenom=?,login=?,password=? where id = ?" );
			ps.setString(1, user.getNom());
			ps.setString(2, user.getPrenom());
			ps.setString(3, user.getLogin());
			ps.setString(4, user.getPassword());
			ps.setInt(5, user.getId());
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		
	}
	
	public static void deleteUser(int id) {
		
		
		try {
			
			Connection con = Userdao.getconnection();
			PreparedStatement ps = con.prepareStatement(" delete from user where id = ?" );
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
	
	}
	
	public static User getUserById(int id) {
		
		User user = new User();
		
		try {
			
			Connection con = Userdao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select nom , prenom , login , password from user where id = ?" );
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				user.setNom(rs.getString(1));
				user.setPrenom(rs.getString(2));
				user.setLogin(rs.getString(3));
				user.setPassword(rs.getString(4));
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		return user;
		
	}
	
	public static List<User> getAllUser(){
		
		List<User> liste = new ArrayList<User>();
		
	try {
			
			Connection con = Userdao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select * from user" );
		
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				User user = new User();
				user.setId(rs.getInt(1));
				user.setNom(rs.getString(2));
				user.setPrenom(rs.getString(3));
				user.setLogin(rs.getString(4));
				user.setPassword(rs.getString(5));
				liste.add(user);
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
	return liste;
		
	}
	
	public static User getUserBylogin(String login,String password) {
	
		Connection con = Userdao.getconnection();
		User user = null;
		PreparedStatement ps;
		try {
			
			ps = con.prepareStatement(" select * from user where login = ? and password = ?" );
			
			ps.setString(1, login);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			User user2 = new User();
			if(rs.next()) {
				user2.setId(rs.getInt("id"));
				user2.setNom(rs.getString("nom"));
				user2.setPrenom(rs.getString("prenom"));
				user2.setLogin(rs.getString("login"));
				user2.setPassword(rs.getString("password"));

				user = user2;
				con.close();
				return user2;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return user;
	}
	
	
}

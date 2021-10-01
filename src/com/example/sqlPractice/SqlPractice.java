package com.example.sqlPractice;
import java.sql.*;
public class SqlPractice {

	public static void main(String[] args) {
		getDatabase();
		
		setDatabase("방탄소년단", "남성", "2010년대", "2013년");
		setDatabase("에일리", "여성", "2000년대", "2008년");
		setDatabase("임창정", "남성", "1970년대", "1970년");
		setDatabase("유희열", "남성", "1980년대", "1980년");
		setDatabase("이센스", "남성", "2000년대", "2005년");
		setDatabase("거미", "여성", "2000년대", "2003년");
		setDatabase("로제", "여성", "2010년대", "2013년");

		getDatabase();
		deleteAllDatabase();
		
//		deleteDatabase(3);
		getDatabase();
//
//		updateDatabase();
//		getDatabase();
	}
	public static void getDatabase() {
		Connection con = null;
		
		try {
			Class .forName("org.sqlite.JDBC");
			String dbFile = "music.db";
			
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
			
			Statement stat1 = con.createStatement();
			String query = "select * from g_artists;";
			ResultSet rs1 = stat1.executeQuery(query);
			
			while(rs1.next()) {
				String name = rs1.getString("name");
				String a_type = rs1.getString("a_type");
				String a_year = rs1.getString("a_year");
				System.out.println("name : "+name + " type : " + a_type +" a_year : " + a_year);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public static void setDatabase(String name, String a_type, String a_year, String debut) {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			String dbFile = "music.db";
			
			con = DriverManager.getConnection("jdbc:sqlite:"+dbFile);
			
			Statement stat2 = con.createStatement();
			String query = "insert into g_artists(name, a_type, a_year, debut, regdate)" + 
							"values(\'" + name + "\',\'" + a_type + "\',\'" + a_year + "\',\'" + debut + "\',datetime('now', 'localtime'));";
			
			int cnt = stat2.executeUpdate(query);
			
			if(cnt > 0) {
				System.out.println("Data updated");
			}
			else {
				System.out.println("Data update fail");
			}
			stat2.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	public static void deleteDatabase(int id) {
		Connection con = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			String dbFile = "music.db";
			
			con = DriverManager.getConnection("jdbc:sqlite:"+dbFile);
			
			Statement stat3 = con.createStatement();
			String query = "delete from g_artists where id = " + id + ";";
			
			int cnt3 = stat3.executeUpdate(query);
			
			if(cnt3 > 0) {
				System.out.println("data deleted");			
			}
			else {
				System.out.println("data deletion failed");
			}			
			stat3.close();
		} 
		
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void updateDatabase() {
		Connection con = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			String dbFile = "music.db";
			
			con = DriverManager.getConnection("jdbc:sqlite:"+dbFile);
			
			Statement stat4 = con.createStatement();
			String query = "update g_artists set a_year = '2000년대, 2010년대, 2020년대'" + " where id = 1 ;";
			
			int cnt4 = stat4.executeUpdate(query);
			if(cnt4 > 0) {
				System.out.println("database updated");
			}
			else {
				System.out.println("database update fail");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	public static void deleteAllDatabase() {
		Connection con = null;
		
		try {
			Class.forName("org.sqlite.JDBC");
			String dbFile = "music.db";
			
			con = DriverManager.getConnection("jdbc:sqlite:" + dbFile);
			Statement stat5 = con.createStatement();
			String query = "delete from g_artists";
			
			int cnt5 = stat5.executeUpdate(query);
			if(cnt5 < 0) {
				System.out.println("database deletion fail");
			}
			else {
				
				System.out.println("database deleted properly");
			}
		} 
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

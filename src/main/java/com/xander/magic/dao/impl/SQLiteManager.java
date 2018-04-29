package com.xander.magic.dao.impl;

import java.sql.*;

public class SQLiteManager {
	private static Connection connection;

	public static Connection getConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			try {
				Class.forName("org.sqlite.JDBC");
				connection = DriverManager.getConnection("jdbc:sqlite:music.db");
			} catch (Exception e) {
				System.err.println(e.getClass().getName() + ": " + e.getMessage());
				System.exit(0);
			}
			System.out.println("Opened database successfully");
		}
		return connection;
	}

	public static boolean validateTable(String tableName) throws SQLException {
		Statement statment = connection.createStatement();
		ResultSet rs = statment.executeQuery("select count(1) " +
				"from sqlite_master " +
				"where LOWER(type)='table' " +
				"and LOWER(name) = '" + tableName.toLowerCase() + "'");
		rs.first();
		if(rs.getInt(1)>0){
			return true;
		}
		return false;
	}

	public static void createTable(String tableSQL) throws SQLException {
		Statement statment = connection.createStatement();
		boolean result = statment.execute(tableSQL);
	}

	public static void initializeTables() throws SQLException {
//		if (!validateTable("my_music")) {
//
//		}

	}
}

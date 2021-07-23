package com.training.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.apache.log4j.Logger;

public class DatabaseUtil {

	private static Connection con = null;
	private static Logger log = Logger.getLogger(DatabaseUtil.class.getName());
	private static final String DB_URL = "jdbc:mysql://localhost:3306/user_management";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";

	public static Connection getDatabaseConnection() {
		if (con == null) {
			synchronized (DatabaseUtil.class) {
				if (con == null) {
					try {
						Class.forName("com.mysql.jdbc.Driver");
						con = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

					} catch (ClassNotFoundException e) {
						log.error("Driver class not found :" + e.getMessage());
						e.printStackTrace();
					} catch (SQLException e) {
						log.error("Getting error while retriving connection :" + e.getMessage());
						e.printStackTrace();
					}
				}
			}
		}
		return con;
	}

}

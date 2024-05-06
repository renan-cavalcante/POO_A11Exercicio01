package view;

import java.sql.Connection;

import persistence.GenericDaoMySQL;
import persistence.GenericDaoPostgreSQL;

public class Main {

	public static void main(String[] args) {
		GenericDaoMySQL GMySQL = new GenericDaoMySQL();
		GenericDaoPostgreSQL GPostgreSQL = new GenericDaoPostgreSQL();
		
		try {
			Connection conn =GMySQL.getConnection();
			System.out.println(conn.getMetaData().getDatabaseProductName());
			conn.close();
			conn =GPostgreSQL.getConnection();
			System.out.println(conn.getMetaData().getDatabaseProductName());
		}catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}

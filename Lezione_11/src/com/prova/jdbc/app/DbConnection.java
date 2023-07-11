package com.prova.jdbc.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DbConnection {

	String url = "jdbc:postgresql://localhost:5432/";
	String db = "Lezione_11";
	String user = "postgres";
	String pass = "root";
	Statement state;
	
	public DbConnection() throws SQLException {
		Connection connection = DriverManager.getConnection(url + db, user, pass);
		state = connection.createStatement();
		createTableSchoolStudents();
		System.out.println("DATABASE CONNECTED SUCCESFULLY");
	}

	private void createTableSchoolStudents() throws SQLException {
		String sqlTable =  " CREATE TABLE IF NOT EXISTS school_students ("
				+ "		id SERIAL PRIMARY KEY,"
				+ " 	name VARCHAR NOT NULL,"
				+ "		lastname VARCHAR NOT NULL,"
				+ "		gender VARCHAR NOT NULL,"
				+ "		birthdate DATE NOT NULL,"
				+ "		avg DECIMAL NOT NULL,"
				+ "		min_vote DECIMAL NOT NULL,"
				+ "		max_vote DECIMAL NOT NULL"
				+ " );" ;
	state.executeUpdate(sqlTable);
	System.out.println("TABLE SCHOOL STUDENTS CREATED SUCCESFULLY");
	}
	
	public void insertStudent(Student s) throws SQLException {
		String sqlRow = " INSERT INTO school_students (name, lastname, gender, birthdate, avg, min_vote, max_vote) "
				   + "VALUES ('"+s.getName()+"', '"+s.getLastname()+"', '"+ s.getGender()+"', '"+s.getBithdate()+"', "+s.getAvg()+", "+s.getMin_vote()+", "+s.getMax_vote()+");";
		state.executeUpdate(sqlRow);
		System.out.println("STUDENT: " + s.getName() + " ADDED SUCCESFULLY");
	}
	
}

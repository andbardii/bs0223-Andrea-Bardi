package com.prova.jdbc.app;

import java.sql.SQLException;
import java.time.LocalDate;

public class MainClass {

	public static void main(String[] args) {
		
		try {
			DbConnection DATABASE = new DbConnection();
			
			Student Andrea = new Student("Andrea", "Bardi", Gender.MALE, LocalDate.of(2002, 10, 28), 8.7, 6.9, 10.0);
			Student Federico = new Student("Federico", "Rossi", Gender.UNDEFINED, LocalDate.of(1990, 12, 15), 9.2, 7.4, 10.0);
			Student Alessia = new Student("Alessia", "Verdi", Gender.FEMALE, LocalDate.of(1983, 11, 30), 8.2, 5.8, 9.5);
			
//			DATABASE.insertStudent(Andrea);
//			DATABASE.insertStudent(Federico);
//			DATABASE.insertStudent(Alessia);
			
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}

}

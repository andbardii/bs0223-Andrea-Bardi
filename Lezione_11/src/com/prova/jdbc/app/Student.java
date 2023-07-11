package com.prova.jdbc.app;

import java.time.LocalDate;

public class Student {

	private Integer id;
	private String name;
	private String lastname;
	private Gender gender;
	private LocalDate bithdate;
	private double avg;
	private double min_vote;
	private double max_vote;
	
	public Student(String name, String lastname, Gender gender, LocalDate bithdate,
				   double avg, double min_vote, double max_vote) {
		super();
		this.name = name;
		this.lastname = lastname;
		this.gender = gender;
		this.bithdate = bithdate;
		this.avg = avg;
		this.min_vote = min_vote;
		this.max_vote = max_vote;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public LocalDate getBithdate() {
		return bithdate;
	}

	public void setBithdate(LocalDate bithdate) {
		this.bithdate = bithdate;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public double getMin_vote() {
		return min_vote;
	}

	public void setMin_vote(double min_vote) {
		this.min_vote = min_vote;
	}

	public double getMax_vote() {
		return max_vote;
	}

	public void setMax_vote(double max_vote) {
		this.max_vote = max_vote;
	}

	@Override
	public String toString() {
		return "STUDENT id:" + id + " (name:" + name + ", lastname:" + lastname + ", gender:" + gender + ", bithdate:"
			   + bithdate + ", avg:" + avg + ", min_vote:" + min_vote + ", max_vote:" + max_vote + ")";
	}
	
	
	
}

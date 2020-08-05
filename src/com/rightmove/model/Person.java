package com.rightmove.model;

import java.util.Date;

public class Person {
	private String personName;
	private String personSex;
	private int personAge;
	private Date personDob;
	
	public Person(String pN, String pS, int pA, Date pDob){
		this.personName = pN;
		this.personSex = pS;
		this.personAge= pA;
		this.personDob = pDob;
	}
	
	public String getPersonSex() {
		return personSex;
	}
	public void setPersonSex(String personSex) {
		this.personSex = personSex;
	}
	public int getPersonAge() {
		return personAge;
	}
	public void setPersonAge(int personAge) {
		this.personAge = personAge;
	}
	public Date getPersonDob() {
		return personDob;
	}
	public void setPersonDob(Date personDob) {
		this.personDob = personDob;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}
	
	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 * Overriding equals method for deep comparison objects of type person.
	 */
	@Override
	public boolean equals(Object p){
		if(!(p instanceof Person)){
			return false;
		}
		Person that = (Person) p;
		return 
			      this.personName.equals(that.personName) &&
			      this.personSex.equals(that.personSex) &&
			      this.personAge == that.personAge &&
			      this.personDob.equals(that.personDob);
	}
}

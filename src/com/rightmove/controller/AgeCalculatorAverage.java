package com.rightmove.controller;

import java.util.List;

import com.rightmove.interfaces.AgeCalculator;
import com.rightmove.model.Person;

/*
 * This method is synchronized - coarse grain locking on object monitor for thread safety.
 */
public class AgeCalculatorAverage implements AgeCalculator {
	public static synchronized int calcAvAge(List<Person> peopleList){
		int avAge = 0;
		for(Person p : peopleList){
			avAge += p.getPersonAge();
		}
		return (avAge/peopleList.size());
	}
}

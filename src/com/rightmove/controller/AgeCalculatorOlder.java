package com.rightmove.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rightmove.interfaces.AgeCalculator;
import com.rightmove.model.Person;

public class AgeCalculatorOlder implements AgeCalculator {
	
	public static List<String> olderCalc(List<Person> peopleList, String p1, String p2){
		List<String> dateList = new ArrayList<String>();
		String str = "";
		for(Person p : peopleList){
			if(p.getPersonName().equals(p1)){
				for(Person pip : peopleList){
					if(pip.getPersonName().equals(p2)){
						str = "The difference in days between " + p1 + " and " + p2 + " is: " + calcAge(p.getPersonDob(), pip.getPersonDob()) + " days.";
						dateList.add(str);
					}
				}
			}
		}
		return dateList;
	}
	
	public static int calcAge(Date date1, Date date2){
		long diff = date2.getTime() - date1.getTime();
		int diffDays =  (int) (diff / (24* 1000 * 60 * 60));
		return diffDays;
	}
}

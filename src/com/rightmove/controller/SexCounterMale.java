package com.rightmove.controller;

import java.util.List;

import com.rightmove.interfaces.SexCounter;
import com.rightmove.model.Person;

public class SexCounterMale implements SexCounter {
	/*
	 * The method is NOT synchronized to prevent reentrant deadlock as it has fine grain locking.
	 * There is an additional synchronized block, locking on the peopleList 
	 * object monitor for fine grained locking as there might be several invocations of this controller
	 * by several views.
	 * @param peopleList
	 * @return maleCount
	 */
	public static int countMalePeople(List<Person> peopleList){
		synchronized (peopleList) {
			int maleCount = 0;
			for(Person p : peopleList){
				if(p.getPersonSex().equals("male")){
					maleCount++;
				}
			}
			return maleCount;
		}
	}
}

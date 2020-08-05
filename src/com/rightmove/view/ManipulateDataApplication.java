package com.rightmove.view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rightmove.controller.AgeCalculatorAverage;
import com.rightmove.controller.AgeCalculatorOlder;
import com.rightmove.controller.SexCounterMale;
import com.rightmove.model.Person;

/**
 * Please read in the data contained within the file manipulate-data.txt
 * Manipulate the data to programmatically answer the following questions:
 * 
 * 1. How many people in the list are male? 
 * 2. In years what is the average age of the people in the list? 
 * 3. How many days older is Jeff Briton than Tom Soyer?
 * 
 * You may add comments to your code to tell us why you chose to do something a
 * particular way, but this is not required. You may create as many classes as
 * you like. You may delete any code in ManipulateDataApplication that you don't
 * want.
 * 
 * Please print your answers out to the screen by using the 'System.out.print'
 * function. Good Luck!
 */

/*
 * I have used Eclipse Indigo 32bit
 * The main class is the view - ManipulateDataApplication.java
 * I have implemented a Model-View-Controller (MVC) architecture.
 * I have implemented an Abstract Factory Design Pattern for the controllers.
 * I have demonstrated inheritance via interfaces for the Abstract Factory pattern crating concrete instances of the controllers.
 * I have not implemented any error handling for the purpose of this application as it would be necessary at a further
 * stage when the application is grown.
 * I have demonstrated the implementation of Thread safety.
 * I have demonstrated a little bit of performance optimisation by using fine-grain locking for thread safety. 
 * I have not demonstrated TDD as it seemed like a time waste considering the simplicity of the application
 * I have demonstrated OOD Object-Oriented-Development by modelling Person as an object.
 * I have overridden equals method for deep comparison objects of type person.
 */

public class ManipulateDataApplication {
	
	private static List<Person> peopleList = new ArrayList<Person>();
	private static BufferedReader bufferedReader;

	public static void main(String[] args) throws IOException, NumberFormatException, ParseException {	
		try{
			loadFile();
			loadUserInterface();
			useControllers();
		} catch (IOException ioe){
			ioe.printStackTrace();
		} catch (NumberFormatException nfe){
			nfe.printStackTrace();
		} catch (ParseException pe){
			pe.printStackTrace();
		}		
	}

	private static void helpfulMethodFeelFreeToDeleteOrUseElsewhere(String line) throws NumberFormatException, ParseException {
		if(!line.isEmpty()){
			String[] columns = line.split(",");			
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
			Person p = new Person(columns[0].trim(), columns[1].trim(), Integer.parseInt(columns[2].trim()), (Date)(df.parse(columns[3].trim())));
			peopleList.add(p);
		}
	}
	
	public static void loadFile() throws IOException, NumberFormatException, ParseException{
		File file = new File("manipulate-data.txt");
		//System.out.println(file.getName() + " file exists = " + file.exists());
		bufferedReader = new BufferedReader(new FileReader(file));
		String line;
		int skipLine = 0;
		while ((line = bufferedReader.readLine()) != null) {
			for(; skipLine < 1; skipLine++)line="";
			helpfulMethodFeelFreeToDeleteOrUseElsewhere(line);
		}
		bufferedReader.close();
	}
	
	public static void useControllers(){
		System.out.print("1. " + SexCounterMale.countMalePeople(peopleList) + " people in the list are male. " + "\n");
		System.out.print("2. The average age of the people in the list is " + AgeCalculatorAverage.calcAvAge(peopleList) + ".\n");
		for(String s : AgeCalculatorOlder.olderCalc(peopleList, "Jeff Briton", "Tom Soyer")){
			System.out.print("3. " + s + "\n");			
		}
	}
	
	public static void loadUserInterface(){
		System.out.print("1. How many people in the list are male?" + "\n");
		System.out.print("2. In years what is the average age of the people in the list" + "\n");
		System.out.print("3. How many days older is Jeff Briton than Tom Soyer?" + "\n\n");
	}
}
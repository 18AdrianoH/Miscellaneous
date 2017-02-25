package main;

import java.util.Scanner;

public class Marian 
{
	//for handling user interactions
	private Scanner input;
	
	//data on user
	private int ssn;
	private String firstName;
	private String lastName;
	
	//data on book
	private String bookName;
	private String date;
	private int amountOverdue; // in days
	private double dailyFine;
	
	double bookFine;
	
	//constructors
	public Marian(){
		firstName = "";
		lastName = "";
		ssn = 0;
		input = new Scanner(System.in);
		
		date = "";
		bookName = "";
		amountOverdue = 0;
		dailyFine = 0;
	}
	public Marian(String f, String l){
		firstName = f;
		lastName = l;
		ssn = 0;
		input = new Scanner(System.in);
		
		date = "";
		bookName = "";
		amountOverdue = 0;
		dailyFine = 0;
	}
	public Marian(String f, String l, int s){
		firstName = f;
		lastName = l;
		ssn = s;
		input = new Scanner(System.in);
		
		date = "";
		bookName = "";
		amountOverdue = 0;
		dailyFine = 0;
	}
	public Marian(String f, String l, int s, String da, String b, int a, double d){
		firstName = f;
		lastName = l;
		ssn = s;
		input = new Scanner(System.in);
		
		date = da;
		bookName = b;
		amountOverdue = a;
		dailyFine = d;
	}
	
	
	//get the user's info
	public void getUserInformation(){
		System.out.println("Enter your first name, last name, and social security"
				+ "number.  Seperate them with commas and do not put any other characters"
					+ "in the entire string.  Do it in that order and do not end on a comma.");
		String data = input.nextLine();
		//didnt follow conventions or forgot data
		if(data.indexOf(",") == -1 || data.indexOf(",",data.indexOf(",")) == -1){
			System.out.println("Check to make sure that You have all your information"
					+ " and it is seperated by commas.");
			//clear and redo
			firstName = "";
			lastName = "";
			ssn = 0;
			getUserInformation();
		}
		else{
			firstName = data.substring(0,data.indexOf(","));
			lastName = data.substring(data.indexOf(","), data.indexOf(",",data.indexOf(",")));
			try{
				//ssn = Integer.parseInt(data.substring(data.indexOf(",",data.indexOf(",",data.indexOf(",")))+1));
				System.out.println("Thanks!");
			}
			catch(NumberFormatException e){
				System.out.println("Check to make sure that Social Security number is an int.");
				//clear and redo
				firstName = "";
				lastName = "";
				ssn = 0;
				getUserInformation();
			}
		}
	}
	//get the book's info
	public void getBookInformation(){
		System.out.println("Enter the name of the book that is overdue.  Enter the date the book "
				+ "was checked out.  Enter the number of days the book is overdue.  " + 
					"Enter the daily fine.  Seperate them with commas and do not enter anything"
					+ " else into this string (don't end on a comma).  Do it in that order.");
		String data = input.nextLine();
		//didnt follow conventions or forgot data
		if(data.indexOf(",") == -1 || data.indexOf(",",data.indexOf(",")) == -1
				|| data.indexOf(",",data.indexOf(",",data.indexOf(","))) == -1){
			System.out.println("Make sure to input your info in the way stated.  Don't"
					+ " forget any commas and enter all of it.");
			//clear and redo
			bookName = "";
			date = "";
			amountOverdue = 0;
			dailyFine = 0;
			getBookInformation();
		}
		else{
			bookName = data.substring(0,data.indexOf(","));
			date = data.substring(data.indexOf(","), data.indexOf(",",data.indexOf(",")));
			try{
				amountOverdue = Integer.parseInt(data.substring
						(data.indexOf(",",data.indexOf(",")), 
								data.indexOf(",",data.indexOf(",",data.indexOf(",")))));
				dailyFine = Double.parseDouble(data.substring(
						data.indexOf(",",data.indexOf(",",data.indexOf(",")))));
				System.out.println("Thanks.");
			}
			catch(NumberFormatException e){
				System.out.println("Check to make sure that amount overdue is an int and "
						+ " daily fine is a double.");
				bookName = "";
				date = "";
				amountOverdue = 0;
				dailyFine = 0;
				getBookInformation();
			}
		}
		
	}
	//create an account for the user
	public String generateUserAccount(){
		String ssnString = String.valueOf(ssn);
		while(ssnString.length() < 4){
			System.out.println("Please reEnter your info.  The ssn is wrong.");
			getUserInformation();
			ssnString = String.valueOf(ssn);
		}
		return lastName + firstName.substring(0,3) + "-" + ssnString.substring(ssnString.length()-4);
	}
	//calculate the book fine
	public void calculateBookFine(){
		bookFine = dailyFine*amountOverdue;
		//cut off anything below a penny's worth and round appropriately
		bookFine = bookFine*100;
		bookFine = ((double)((int)(bookFine + 0.5)))/100.0;
	}
	//print overdue message
	public void printBookOverdueMessage(){
		
		//blank
		System.out.println();
		System.out.println();
		
		//top info
		System.out.println("To: " + firstName + " " + lastName + "		Account: " + generateUserAccount());
		System.out.println("From: Marian");
		System.out.println("Subject: Overdue Notice");
		
		//seperator
		System.out.println("=========================================================");
		
		//bottom info
		System.out.println(bookName + " was checked out on: " + date);
		System.out.println("The book is currently " + String.valueOf(amountOverdue) + " days late.");
		System.out.println("Your fine has accumulated to " + String.valueOf(bookFine));
	}
	
	
	public static void main(String[]args){
		Marian marian = new Marian();
		marian.getUserInformation();
		marian.getBookInformation();
		
		marian.generateUserAccount();
		marian.calculateBookFine();
		
		marian.printBookOverdueMessage();
	}
}

//Java Program for Library management system

import java.util.Scanner;
import java.util.Date;
import java.text.SimpleDateFormat;

class Library{
	
	String bookId;
	String bookName;
	String bookGenre;
	String bookAuthor;
	String bookPublisher;
	int bookEdition;
	int countOfTotalBooks;
	int countOfAvailabeBooks;
	double bookPrice;
	static double fine = 50.0;
	
	//Default Constructor
	Library(){
		bookId = null;
		bookName = null;
		bookGenre = null;
		bookAuthor = null;
		bookPublisher = null;
		bookEdition = 0;
		countOfAvailabeBooks = 0;
		countOfTotalBooks = 1;
		bookPrice = 0.0;
	}
	
	//Parameterised Constructor
	Library(String bookId, String bookName, String bookGenre, String bookAuthor, String bookPublisher, int bookEdition, int countOfAvailabeBooks, int countOfTotalBooks, double bookPrice){
		this.bookAuthor = bookAuthor;
		this.bookEdition = bookEdition;
		this.bookId = bookId;
		this.bookPublisher = bookPublisher;
		this.bookName = bookName;
		this.countOfAvailabeBooks = countOfAvailabeBooks;
		this.countOfTotalBooks = countOfTotalBooks;
		this.bookGenre = bookGenre;
		this.bookPrice = bookPrice;
	}
	
	int getAvaialableBookCount(){
		return countOfAvailabeBooks;
	}
	
	void displayBookDetails(){
		System.out.println("Details of book you asked are as follows :");
		System.out.println("Book Id : " + bookId);
		System.out.println("Book Name : " + bookName);
		System.out.println("Book Genre : " + bookGenre);
		System.out.println("Author Name : " + bookAuthor);
		System.out.println("Publisher : " + bookPublisher);
		System.out.println("Edition : " + bookEdition);
		System.out.println("Total Number of Books in Library : " + countOfTotalBooks);
		System.out.println("Total Number of Books available and can be issued : " + countOfAvailabeBooks);
		System.out.println("Book MRP.: " + bookPrice);
	}
	
	void issueBook(){
		if ( this.countOfAvailabeBooks > 0){
			countOfAvailabeBooks--;
			System.out.println("Thank you for issuing the Book");
		}
		else{
			System.out.println("Sorry the book you asked for is not available with us now");
		}
	}
	
	void returnBook(){
		countOfAvailabeBooks++;
		System.out.println("Thank you for returning the Book");
	}
	
	void newCopyBought(){
		countOfTotalBooks++;
		countOfAvailabeBooks++;
	}
}

class Driver{
	public static void main(String[] args){
		Library obj1 = new Library("LIB0123", "DSA in .py", "Course", "Sumita Arora", "Cordova", 9, 3, 15, 499.99);
		obj1.displayBookDetails();
		Library obj2 = new Library("LIB0123", "DSA in .py", "Course", "Sumita Arora", "Cordova", 9, 3, 15, 499.99);
		obj2.displayBookDetails();
		Library obj3 = new Library("LIB0123", "DSA in .py", "Course", "Sumita Arora", "Cordova", 9, 3, 15, 499.99);
		obj3.displayBookDetails();
		
		obj1.issueBook();
		
		obj1.returnBook();
		
	}
}
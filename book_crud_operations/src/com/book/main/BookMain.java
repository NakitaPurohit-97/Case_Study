package com.book.main;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

import com.book.jdbc.*;
import com.book.pojo.*;

public class BookMain 
{
	public static void main(String[] args) throws Exception 
	{
		
		BookJdbc bookjdbc = new BookJdbc();
		BookPojo p = new BookPojo();
		int ch=0;
		//the while loop will run forever as value ch=0 is true. it can be terminated using  System.exit(0)
		while(ch==0)
		{
		System.out.println("select the option");
		System.out.println("1 -> Insert new book");
		System.out.println("2 -> Fetch book details");
		System.out.println("3 -> Update the book details");
		System.out.println("4 -> Delete book");
		
		Scanner sc=new Scanner(System.in);	
		int option = sc.nextInt();
		switch(option)
		{
		//Switch case 1 used here is to insert book details and is passed to createBook(p) method to insert the details into database
		case 1 :
		{
			sc.nextLine();
			System.out.println("Enter Book name");
		     p.setBook_name(sc.nextLine());
		     System.out.println("Enter Author name");
		     p.setAuthor_name(sc.nextLine());
		     System.out.println("Enter the book edition");
		     p.setEdition(sc.nextInt());
		 
			     int val = bookjdbc.createBook(p);
			     if(val==1)
			    	 System.out.println("Book Created");
			     else
			    	 System.out.println("Book not Created");
			     break;
		}
		//=================================================================
		//switch case 2 used here is to fetch the book details from the database by taking ISBN_number from user
		case 2:
		{
	          System.out.println("Enter ISBN_number");
	          p.setIsbn_number(sc.nextInt());
	          bookjdbc.readBook(p);
	          break;
	     }
		//=================================================================
		//Switch case3 used here is to update book edition in the database by taking ISBN_number and edition number from user
		case 3:
		{
			sc.nextLine();
		       System.out.println("Enter ISBN number to update book details");
		       p.setIsbn_number(sc.nextInt());
		     
	           System.out.println("Enter edition");
	           p.setEdition(sc.nextInt());
	           
	           int val = bookjdbc.updateBook(p);
	           if(val==0)
	    	    System.out.println("Book details not Updated");
	           else
	    	    System.out.println("Book details Updated");
	           break;
		      			
	     }
		//=================================================================
		//switch case4 used here is to delete book details by taking ISBN_number from user
		case 4:
		{
		       System.out.println("Enter ISBN number to Delete Book");
		       p.setIsbn_number(sc.nextInt());
		       
	           int val = bookjdbc.deleteBook(p);
	           if(val==0)
	    	    System.out.println("Book not Deleted");
	           else
	    	    System.out.println("Book Deleted");
	           break;
		      			
	    }
		
}
		System.out.println("Press 0 to continue");
		ch = sc.nextInt();
		}
	}
}

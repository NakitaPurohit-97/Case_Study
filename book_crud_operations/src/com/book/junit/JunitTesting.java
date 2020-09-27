package com.book.junit;
import com.book.pojo.*;
import com.book.main.*;
import com.book.jdbc.*;
import java.sql.Connection;
import java.sql.DriverManager;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/* Testing the Functionality with the Manually giving Inputs from Users to 
constructor and then passing the object to createBook(e),updateBook(e),deleteBook(e)  which
accepts BookPojo object e,e1,e2,e3,e4 as parameters. Establishes Connection with Sql Server
and Inserts,updates and deletes Values in table  Book of db_Book	*/
class JunitTesting 
{
	BookJdbc book = new BookJdbc();
	BookPojo e = new BookPojo("War and Peace","Tolstoy",1);
	BookPojo e1 = new BookPojo("Cheque book","vasdev mohi");
	BookPojo e2=new BookPojo("Celestial bodies",8);
    BookPojo e3=new BookPojo(1,8);
    BookPojo e4=new BookPojo(9);
	
	@Test
	void test1() throws Exception 
	{

		  int res =  book.createBook(e); // create and insert operation are same
		  assertEquals(1,res); 
		  
	}@Test

	void test2() throws Exception 
	{

		  int res1 =  book.createBook(e1); // create and insert operation are same
		  assertEquals(1,res1);   //condition for failure of insertion
	}
	@Test
	void test3() throws Exception 
	{
		  int res2 =  book.createBook(e2); // create and insert operation are same
		  assertEquals(1,res2);  //condition for failure of insertion
	}
	@Test
	void test4() throws Exception 
	{
		  int res3 =  book.updateBook(e3); //updation of book details
		  assertEquals(1,res3); 
	}
	@Test
	void test5() throws Exception 
	{
		  int res4 =  book.deleteBook(e4); // deletion of book details
		  //If we execute it for the second time this results in failure as the book details in the first execution will be deleted
		  assertEquals(1,res4); 
	}
	
	

}

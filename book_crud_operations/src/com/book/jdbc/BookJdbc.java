package com.book.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import com.book.pojo.*;
import com.book.main.*;

public class BookJdbc 
{
	/*This createBook(BookPojo p)  accepts BookPojo object p as parameter.  
	Establishes Connection with Sql Server and Inserts 3 Values into table  Book of db
	using Prepared Statement  */
	public int createBook(BookPojo p) throws Exception 
	
{
		Connection con = null;
		Statement stmt = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_book","root","root");
			stmt= con.createStatement();
		} 
		catch (ClassNotFoundException ex) 
		{
			
			ex.printStackTrace();
		}
		
     
		PreparedStatement pt = con.prepareStatement("insert into Book"
				+ "(Book_name, Author_name, Edition) values \r\n" + 
				"( ?,?,?)");
		
		pt.setString(1,p.getBook_name() );
		pt.setString(2,p.getAuthor_name() );
		pt.setInt(3,p.getEdition());
		
		int r = pt.executeUpdate();
		stmt.close();
	    con.close();
		return r;

}
	 /*This readBook(BookPojo x) Method  accepts BookPojo object p as parameter.
    Establishes Connection with Sql Server and Fetchs All Values from table  Book of db and display it
	using Prepared Statement  */
	
	public void readBook(BookPojo x) throws Exception 
	{
		Connection con = null;
		Statement stmt = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_book","root","root");
			//here db_book is database name, root is username and password  
			stmt= con.createStatement();
		} 
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		}

		
		ResultSet rs= stmt.executeQuery("select * from Book where ISBN_number="+x.getIsbn_number());
		if(rs.first())
		{
			rs= stmt.executeQuery("select * from Book where ISBN_number="+x.getIsbn_number());	
		while(rs.next()) 
		{
		
	    System.out.println("ISBN_number : "+rs.getInt("ISBN_number")+
	    		"\nBook_name : "+rs.getString("Book_name")+
	    		"\nAuthor_name : "+rs.getString("Author_name")+
	    		
	    		"\nEdition : "+rs.getInt("Edition")
	    		
	    		);
		}
		}
		else
		{
			System.out.println("Book with givdn Id not found");
		}
		
		stmt.close();
	    con.close();
	
	}
	
	/*This updateBook(BookPojo p) Method  accepts BookPojo object p as parameter.
    Establishes Connection with Sql Server and Updates Edition number using ISBN_number into table  Book of db
	using Prepared Statement  */
	public int updateBook(BookPojo p) throws Exception 
	{
		Connection con = null;
		Statement stmt = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_book","root","root");
			stmt= con.createStatement();
		} 
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		}

		PreparedStatement pt = con.prepareStatement(" update Book set Edition=? where ISBN_number= ?");
		pt.setInt(2, p.getIsbn_number());
	
		
		pt.setInt(1,p.getEdition());
		int r = pt.executeUpdate();
		
		stmt.close();
	    con.close();
		return r;
		
	}
	/*This updateBook(BookPojo p) Method  accepts BookPojo object p as parameter.
    Establishes Connection with Sql Server and deletes data using ISBN_number into table Book of db
	using Prepared Statement  */
	
	public int deleteBook(BookPojo p) throws Exception 
	{
		Connection con = null;
		Statement stmt = null;
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_book","root","root");
			stmt= con.createStatement();
		} 
		catch (ClassNotFoundException e) 
		{
			
			e.printStackTrace();
		}

		PreparedStatement pt = con.prepareStatement("delete from Book where ISBN_number = ?");
		pt.setInt(1, p.getIsbn_number());
	
		int r = pt.executeUpdate();
		
		stmt.close();
	    con.close();
		return r;
		
	}
	



}
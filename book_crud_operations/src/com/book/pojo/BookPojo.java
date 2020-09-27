package com.book.pojo;

public class BookPojo 
{
	private int isbn_number,edition;
	private String book_name,author_name;

//Parameterized Users Constructor with 3 inputs  to initialize fields 
public BookPojo(  String book_name, String author_name,int edition) 
{
		super();
		
		this.edition = edition;
		this.book_name = book_name;
		this.author_name = author_name;
}
//Parameterized Users Constructor with 2 inputs  to initialize fields 
public BookPojo( String book_name, String author_name) 
{
		super();
		
		
		this.book_name = book_name;
		this.author_name = author_name;
}
//Parameterized Users Constructor with 2 inputs  to initialize fields 
public BookPojo(  String author_name,int edition) 
{
		super();
		
		this.edition = edition;
		this.author_name = author_name;
		
}
//Parameterized Users Constructor with 2 inputs  to initialize fields 
public BookPojo(int  isbn_number,int edition) 
{
		super();
		this. isbn_number =  isbn_number;
		this.edition = edition;
		
		
}
//Parameterized Users Constructor with 1 input  to initialize fields 
public BookPojo(int  isbn_number) 
{
		super();
		this. isbn_number =  isbn_number;
				
}
//default constructor to initialize the fields
public BookPojo() 
{
		super();
		// TODO Auto-generated constructor stub
}
//getter methods and setter methods for ISBN_number,Author_name,Book_name and Edition number
    public int getIsbn_number()
    {
		return isbn_number;
	}
	public void setIsbn_number(int isbn_number)  
	{
		this.isbn_number = isbn_number;
	}
	public int getEdition() {
		return edition;
	}
	public void setEdition(int edition)
    {
		this.edition = edition;
	}
	public String getBook_name() 
	{
		return book_name;
	}
	public void setBook_name(String book_name) 
	{
		this.book_name = book_name;
	}
	public String getAuthor_name()  
	{
		return author_name;
	}
	public void setAuthor_name(String author_name) 
	{
		this.author_name = author_name;
	}

}

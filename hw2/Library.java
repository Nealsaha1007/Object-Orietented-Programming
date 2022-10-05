package syr.edu.hw2;
import java.util.ArrayList;
import java.util.List;


public class Library {
	
	static List<Book> bookCatalog = new ArrayList<Book>();	
	
	public static void add(Book Obj) {
		if(Obj == null) return;
		
		bookCatalog.add(Obj);
		
		}
	public static List<Book> search(Book obj) {
		List<Book> searchResult = new ArrayList<Book>();
		for(int i = 0; i<bookCatalog.size();i++)
		{
			//Directly match Book object store in catalog with input Book
			if(bookCatalog.get(i).equals(obj))
			{
				searchResult.add(bookCatalog.get(i));
				
			}
			
			//Match one or more attributes
			//used .equals() for isbn and YearPublished
			else if((bookCatalog.get(i).getAuthor().toLowerCase().contains(obj.getAuthor().toLowerCase().trim())) && 
					(bookCatalog.get(i).getYearPublished() == (obj.getYearPublished())) && 
					(bookCatalog.get(i).getTitle().toLowerCase().contains(obj.getTitle().toLowerCase().trim())) && 
					(bookCatalog.get(i).getPublisher().toLowerCase().contains(obj.getPublisher().toLowerCase().trim())) && 
					(bookCatalog.get(i).getIsbn().equals(obj.getIsbn()) || (obj.getIsbn().isEmpty()))) 
			{
				searchResult.add(bookCatalog.get(i));
			}
		}
		return searchResult;
			
	}
}



package syr.edu.hw2;

import java.util.List;

public class Book {
	 private String author;
	 private String title;
	 private String publisher;
	 private String isbn;
	 private int yearPublished;


	public Book(String a, String t, String p, String i, int y) {
		 this.author = a;
	     this.title = t;
	     this.publisher = p;
	     this.isbn = i;
	     this.yearPublished = y;
	    }

	 public String getAuthor() {
		 return author;
	    }
	 public String getTitle() {
	     return title;
	  	}
	 public String getPublisher() {
	     return publisher;
	   	}
	 public String getIsbn() {
	     return isbn;
	    }
	 public int getYearPublished() {
	     return yearPublished;
	    }
	 
	 @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || !(obj instanceof Object)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		
		Book other = (Book) obj;
		
		if (author == null) {
			if (other.author != null) {
				return false;
			}
		} else if (!author.equals(other.author)) {
			return false;
		}
		
		if (title == null) {
			if (other.title != null) {
				return false;
			}
		} else if (!title.equals(other.title)) {
			return false;
		}
		
		if (publisher == null) {
			if (other.publisher != null) {
				return false;
			}
		} else if (!publisher.equals(other.publisher)) {
			return false;
		}
		
		if (isbn == null) {
			if (other.isbn != null) {
				return false;
			}
		} else if (!isbn.equals(other.isbn)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {

		return "[ Author: " + author + ", Title: " + title + ", Publisher: " + publisher + ", Isbn: " + isbn
				+ ", YearPublished: " + yearPublished + " ]";
	}




	 public static void main(String[] args) {
		 Book b1 = new Book("Holden Karau", "Learning Spark", "O'Reilly", "9781449358624", 2015);
		 Library.add(b1);
	     Book b2 = new Book("Norman Matloff", "The Art of R Programming", "No Starch Press", "9781593273842", 2011);
	     Library.add(b2);
	     Book b3 = new Book("Alan A. A. Donovan", "The Go Programming Language", "Addison Wesley", "9780134190440", 2016);
	     Library.add(b3);
	     
	     
	     //test case	    
	     Book b4 = new Book("", "", "", "9780134190440", 2016);
	     try { // Handling null pointer exception.
	    	 List<Book> result = Library.search(b4);
	    	 for(int i = 0; i<result.size(); i++)
	    	 {
	    		 System.out.println(result.get(i));
	    	 }
	     }
	     catch(NullPointerException e){
	    	 System.out.println("Invalid entry, Please check your input");
	     }
	     
	 }
}



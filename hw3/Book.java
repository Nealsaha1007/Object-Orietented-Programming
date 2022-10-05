package syr.edu.hw3;

import java.util.List;

public class Book<T> {
	 private String author;
	 private String title;
	 private String publisher;
	 private String isbn;
	 private int yearPublished;
	 private T type;


	public Book(String a, String t, String p, String i, int y, T type) {
		 this.author = a;
	     this.title = t;
	     this.publisher = p;
	     this.isbn = i;
	     this.yearPublished = y;
	     this.type =type;
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
	 
	 public T getType() {
		return type;
		 
	 	}
	 
	
	 
	 @Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((author == null) ? 0 : author.hashCode());
			result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
			result = prime * result + ((publisher == null) ? 0 : publisher.hashCode());
			result = prime * result + ((title == null) ? 0 : title.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
			result = prime * result + yearPublished;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (obj == null) {
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
			if (isbn == null) {
				if (other.isbn != null) {
					return false;
				}
			} else if (!isbn.equals(other.isbn)) {
				return false;
			}
			if (publisher == null) {
				if (other.publisher != null) {
					return false;
				}
			} else if (!publisher.equals(other.publisher)) {
				return false;
			}
			if (title == null) {
				if (other.title != null) {
					return false;
				}
			} else if (!title.equals(other.title)) {
				return false;
			}
			if (type == null) {
				if (other.type != null) {
					return false;
				}
			} else if (!type.equals(other.type)) {
				return false;
			}
			if (yearPublished != other.yearPublished) {
				return false;
			}
			return true;
		}

	
	@Override
	public String toString() {

		return "[ Author: " + author + ", Title: " + title + ", Publisher: " + publisher + ", Isbn: " + isbn
				+ ", YearPublished: " + yearPublished + ", Type: " + type + " ]";
	}

	

}



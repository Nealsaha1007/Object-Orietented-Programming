package syr.edu.hw1;

//HW Question-3

import java.util.ArrayList;
import java.util.List;

public class Library {

	
	static List<String> myString = new ArrayList<String>();
	
	
	public static void init(String[] str) {
		for(String s: str)
		{
			myString.add(s);
		}
	}
	
	public static String search(String str2) {
		for(int i = 0; i<myString.size();i++)
		{
			if(myString.get(i).toLowerCase().contains(str2.toLowerCase())) 
				return myString.get(i);
		}
		return "String not found";
				
	}
	public static void main(String[] args)
	{
		String[] abc ={"ABhratanu Saha", "Neal"};
		init(abc);
		String ans = search("A");
		System.out.println(ans);
	}
}



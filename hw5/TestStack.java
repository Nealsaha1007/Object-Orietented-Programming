package syr.edu.hw5;

import java.util.ArrayList;
import java.util.List;


public class TestStack {

	static List<String> items;
	public static void main(String[] args) {
		items = new ArrayList<>();
		items.add("Abhratanu");
		items.add("Saha");
		Adaptee<String> stack = new Adaptee<String>();
		for(int i = 0; i<items.size(); i++)
		{
			stack.push(items.get(i));
		}
		
		
		System.out.println(stack);
		//System.out.println("Get Data:"+ stack.getData());
		System.out.println("Current stack size:"+ stack.size());
		System.out.println("Peek Top Element = "+ stack.peek());
		System.out.println("Current stack size after peek:"+ stack.size());
		System.out.println("Pop Top Element "+ stack.pop());
		System.out.println("Peek Top Element = "+ stack.peek());
		System.out.println("Current stack size after pop:"+ stack.size());
		System.out.println(stack);
		System.out.println("****************");
		stack.getData().add("try to modify");
	}

}

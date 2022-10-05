package syr.edu.hw5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Adaptee<E> implements Stack<E> {
	public List<E> l1 = new ArrayList<E>();
	public String toString()
	{
		return "Stack elements= " + l1;
	}
	@Override
	public void push(E e) {
		l1.add(e);
	}

	@Override
	public E pop() {
		if(l1.isEmpty())
		{
			return null;
		}
		E top = l1.get(l1.size()-1);
		l1.remove(l1.get(l1.size()-1));
		return top;
		
	}

	@Override
	public E peek() {
		if(l1.isEmpty()) {
			return null;
		}
		return l1.get(l1.size()-1);
	}

	@Override
	public int size() {
		return l1.size();
	}

	@Override
	public List<E> getData() {
		if(l1.isEmpty())
			return Collections.emptyList();
		return Collections.unmodifiableList(l1);
	}
	
	

}

package syr.edu.hw6;

//abstract decorator class that extends Element
public abstract class TextDecorator extends Element {
	String tempText;
	Element tempText2;
	
	public TextDecorator(String newText) {
		super(newText);
		tempText = newText;
		// TODO Auto-generated constructor stub
	}
	
	public TextDecorator(Element newText)
	{
		super(newText);
		tempText2 = newText;
		
	}
	
	public String toString() {
		if(tempText != null)
			return tempText+ " ";
		
		else if(tempText2 != null)
				return tempText2.toString();
		return null;
	}
	
	public String toMarkDown() {
		
		if(tempText != null)
			return tempText;
		
		else if(tempText2 != null)
				return tempText2.toMarkDown();
		return null;
	}

}

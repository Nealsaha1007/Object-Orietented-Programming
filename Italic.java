package syr.edu.hw6;

//Adding Italic functionality to element/string

public class Italic extends TextDecorator {

	public Italic(String newText) {
		super(newText);
		
	}
	
	public Italic(Element newText) {
		super(newText);
		
	}
	
	public String toMarkDown() {
		if(tempText != null)
			return "*"+tempText+"*"+" ";
		else if(tempText2 !=null)
				return "*"+tempText2.toMarkDown()+"*";
		return null;
		
	
	
	}

}

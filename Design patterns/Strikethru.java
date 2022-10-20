package syr.edu.hw6;

//Adding Strikethru functionality to element/string

public class Strikethru extends TextDecorator {

	public Strikethru(String newText) {
		super(newText);
	}
	public Strikethru(Element newText) {
		super(newText);
		
	}
	
	public String toMarkDown() {
		
		if(tempText != null)
			return "~~"+tempText+"~~"+" ";
		else if(tempText2 !=null)
				return "~~"+tempText2.toMarkDown()+"~~";
		return null;
		
	
	}


}

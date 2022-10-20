package syr.edu.hw6;

// Adding Bold decoration to element/string

public class Bold extends TextDecorator {

	public Bold(String newText) {
		super(newText);
		// TODO Auto-generated constructor stub
	}
	public Bold(Element newText) {
		super(newText);
		// TODO Auto-generated constructor stub
	}
	
	public String toMarkDown() {
		if(tempText != null)
			return "**"+tempText+"**"+" ";
		else if(tempText2 !=null)
				return "**"+tempText2.toMarkDown()+"**";
		return null;
		
	
	}


}

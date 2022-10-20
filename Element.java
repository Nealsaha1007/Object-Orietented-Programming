package syr.edu.hw6;

//Element class to implement the required methods of toString() and toMarkdown()
public class Element {
	protected String tempText; //Incase input parameter is string 
	protected Element tempText2;//Incase input parameter is an element
	public Element(String newText)
	{
		tempText = newText;
	}
	
	public Element(Element newText)
	{
		tempText2 = newText;
	}
	
	public String toMarkDown() {
		// TODO Auto-generated method stub
		if(tempText != null)
			return tempText.toString()+" ";
		
		if(tempText2 != null)
			return tempText2.toMarkDown();
		return null;
			
		}
		
	

	@Override
	public String toString() {
		if(tempText != null)
			return tempText+" ";
		
		if(tempText2 != null)
				return tempText2.toString();
		return null;
	}

}

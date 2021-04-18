package counter;

public class Counter {

	private String text;
	private int word;
	
	public void setText(String text) {
		
		this.text = text;
		setWordCount(text);
		
	}
	
	public String getText() {
		return text;
	}
	
	public void setWordCount(String text1) {
		
		char ch[]= new char[text1.length()];     
        for(int i=0;i<text1.length();i++)  
        {  
            ch[i]= text1.charAt(i);  
            if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )  
                word++;  
        }  
        
	}
	
	
	public int getWordCount(){
						
		return word;
	}
}

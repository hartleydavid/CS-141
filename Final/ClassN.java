/* B */


public class ClassN {
	private int number;
	private String word;

	public ClassN()
	{
		number = 0;
		word  = "word";
	}
	
	public ClassN(int n, String w)
	{
		number = n;
		word = w;
	}
	
	public void set(int n, String w)
	{
		number = n;
		word = w;		
	}
	
	public boolean equals(ClassN obj)
	{
		return number==obj.number && word.equals(obj.word);
	}
	
	public String toString()
	{
		return String.format("[%d, \"%s\"]", number, word);
	}
}

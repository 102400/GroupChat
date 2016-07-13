package d.handler;

public class RowCounter {
	
	private String s;
	
	public RowCounter(String s)
	{
		this.s = s;
	}
	
	public int getRowCount()
	{
		int count = 0;
		for(int i=0;i<s.length();i++)
		{
			switch(s.charAt(i))
			{
				case '\n':
					count++;
					break;
			}
		}
		count++;
		return count;
	}

}

package d.handler;

/**
 * 
 * 弃用
 * 
 * 将出现的转义字符的变为不是转义字符
 *
 */

public class NoEscapeCharacter {
	
//	private String s;
	private char[] c;
	
	public NoEscapeCharacter(String s)
	{
		c = s.toCharArray();
	}
	
	public String handle()
	{
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<c.length;i++)
		{
			switch(c[i])
			{
				case '\b':
					sb.append("\\b");
					break;
				case '\t':
					sb.append("\\t");
					break;
				case '\n':
					sb.append("\\n");
					break;
				case '\f':
					sb.append("\\f");
					break;
				case '\r':
					sb.append("\\r");
					break;
				case '\"':
					sb.append("\\\"");
					break;
				case '\'':
					sb.append("\\'");
					break;
				case '\\':
					sb.append("\\\\");
					break;
				default:
					sb.append(c[i]);
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args)
	{
		String a = new NoEscapeCharacter("\\\n\b\t\'\"\\\'").handle();
		System.out.println(a);
	}

}

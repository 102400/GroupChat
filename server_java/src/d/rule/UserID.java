package d.rule;

public class UserID {
	
	private String userid;
	private char[] c_userid;
	
	public UserID(String userid)
	{
		this.userid = userid;
		this.c_userid = userid.toCharArray();
	}
	
	public boolean isLegal()
	{
		if(c_userid.length<1||c_userid.length>10)  //user的id字符数在1-10之间
		{
			return false;
		}
		for(int i=0;i<c_userid.length;i++)
		{
			/**
			 * 数字,大写字母,小写字母
			 * 48-57,65-90,97-122
			 */
			int temp = c_userid[i];
			if(!((temp>=48&&temp<=57)||(temp>=65&&temp<=90)||(temp>=97&&temp<=122)))  //不在此范围里
			{
				return false;
			}
		}
		return true;
	}

}

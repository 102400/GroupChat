package d.rule;

public class RoomID {
	
	private String roomid;
	private char[] c_roomid;
	
	public RoomID(String roomid)
	{
		this.roomid = roomid;
		this.c_roomid = roomid.toCharArray();
	}
	
	public boolean isLegal()
	{
		if(c_roomid.length!=3)  //roomid的字符数必须为3
		{
			return false;
		}
		for(int i=0;i<c_roomid.length;i++)
		{
			/**
			 * 数字,大写字母,小写字母
			 * 48-57,65-90,97-122
			 */
			int temp = c_roomid[i];
			if(!((temp>=48&&temp<=57)||(temp>=65&&temp<=90)||(temp>=97&&temp<=122)))  //不在此范围里
			{
				return false;
			}
		}
		return true;
	}
	
//	public static void main(String[] args)
//	{
//		System.out.println(new RoomID("A2z").isLegal());
//	}

}

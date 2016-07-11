package d.rule;

public class RoomPassword {
	
	String roompassword;
	char[] c_roompassword;
	
	public RoomPassword(String roompassword)
	{
		this.roompassword = roompassword;
		this.c_roompassword = roompassword.toCharArray();
	}
	
	public boolean isLegal()
	{
		if(c_roompassword.length>16)  //room的密码字符数大于16时
		{
			return false;
		}
		for(int i=0;i<c_roompassword.length;i++)
		{
			if(c_roompassword[i]<33||c_roompassword[i]>126)  //根据Unicode表
			{
				return false;
			}
		}
		return true;
	}

}

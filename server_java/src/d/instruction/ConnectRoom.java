package d.instruction;

import d.net.Connection;
import d.net.Room;

public class ConnectRoom {
	
	private String roomid;
	private String roompassword;
	
	public ConnectRoom(Connection c,String s)
	{
		int count = 1;
		roomid = "";
		roompassword = "";
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='\n')
			{
				if(count==1)
				{
					count++;
				}
				else if(count==2)
				{
					break;
				}
			}
			else
			{
				if(count==1)
				{
					roomid = roomid + s.charAt(i);
				}
				else if(count==2)
				{
					roompassword = roompassword + s.charAt(i);
				}
			}
		}
		System.out.println("roomid: " + roomid);
		System.out.println("roompassword: " + roompassword);
		String server_roompassword = Room.roompasswordmap.get(roomid);
		if(server_roompassword==null)
		{
			System.out.println("roompassword不匹配");
		}
		else if(roompassword.equals(server_roompassword))
		{
			System.out.println("roompassword匹配");
			Room.roommap.get(roomid).getConnectionSet().add(c);  //将connection加入到房间内
			
			//向客户端发送password匹配消息
		}
	}

}

package d.instruction;

import java.time.ZonedDateTime;

import d.handler.RowCounter;
import d.net.Connection;
import d.net.Room;

public class SendMessage {
	
	private String roomid;
	private String time;
	private String userid;
	private String message;
	
	public SendMessage(String userid,String s)
	{
		roomid = "";
		this.userid = userid;
		for(int i=0;i<s.length();i++)
		{
			if(s.charAt(i)=='\n')
			{
				break;
			}
			else
			{
				roomid = roomid + s.charAt(i);
			}
		}
		
		ZonedDateTime now = ZonedDateTime.now();
		time = "[" + now.getHour() + ":" + now.getMinute() + ":" + now.getSecond() + "]";
		
		message = "sendMessage\n"
				+ userid + "\n"
				+ time + "\n"
				+ s;  //roomid包括在s内
		
		message = new RowCounter(message).getRowCount() + "\n"
				+ message;
		
		System.out.println("***");
		System.out.println(message);
		System.out.println("***handler");
		handler();
//		System.out.println(message);
//		for(Connection c : Room.roommap.get(roomid).getConnectionSet())  //向每个连接这个房间的用户发送
//		{
//			c.write(message);
//			System.out.println(message);
//		}
	}
	
	private void handler()
	{
		for(Connection c : Room.roommap.get(roomid).getConnectionSet())  //向每个连接这个房间的用户发送
		{
			c.write(message);
			System.out.println(message);
		}
	}

}

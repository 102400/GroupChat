package d.instruction;

import d.net.Connection;

public class ReceiveMessage {
	private Connection c;
	private String userid = "";
	private String time = "";
	private String roomid = "";
	private String message = "";
	
	public ReceiveMessage(Connection c,String s)
	{
		this.c = c;
		int count = 1;
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
					count++;
				}
				else if(count==3)
				{
					count++;
				}
				else if(count==4)
				{
					message = message + s.charAt(i);
				}
			}
			else
			{
				if(count==1)
				{
					userid = userid + s.charAt(i);
				}
				else if(count==2)
				{
					time = time + s.charAt(i);
				}
				else if(count==3)
				{
					roomid = roomid + s.charAt(i);
				}
				else if(count==4)
				{
					message = message + s.charAt(i);
				}
			}
		}
		System.out.println("******");
		System.out.println("userid: " + userid);
		System.out.println("time: " + time);
		System.out.println("roomid: " + roomid);
		System.out.println("message: " + message);
		String xxx = time + " " + userid + " > " + message;
//		System.out.println(xxx);
		
//		System.out.println(c.getRoomPanelMap().size());
//		if(c.getRoomPanelMap().get(roomid)!=null)
//		{
//			System.out.println("roomid!=null");
//		}
		c.getRoomPanelMap().get(roomid).getButton().getGroupChatPanel().getInfoPanel().getChatPanel().getLeftPanel().getDisplay().append(xxx+"\n");
	}

}

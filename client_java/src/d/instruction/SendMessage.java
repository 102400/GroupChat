package d.instruction;

import d.handler.RowCounter;

public class SendMessage {
	
	private String message;
	
	public SendMessage(String roomid,String content)  //client send
	{
		message = "sendMessage\n"
				+ roomid + "\n"
				+ content;
	}
	
	public String getMessage()
	{
		message = new RowCounter(message).getRowCount() + "\n"
				+ message;
		
		return message;
	}
	
//	public void setMessage()
//	{
//		message = "";
//	}
	
//	public void send()
//	{
//		
//	}
//	
//	public void receive()
//	{
//		
//	}
	
//	public static void main(String[] args)
//	{
//		SendMessage sm = new SendMessage("123","聊天中");
//		System.out.println(sm.getMessage());
//		sm.setMessage();
//		System.out.println("**********");
//		sm = new SendMessage("123","聊天中");
//		System.out.println(sm.getMessage());
//		sm.setMessage();
//		System.out.println("**********");
//		sm = new SendMessage("123","聊天中");
//		System.out.println(sm.getMessage());
//		sm.setMessage();
//	}

}

package d.instruction;

import d.handler.RowCounter;

public class ConnectRoom {
	
	String message;
	
	public ConnectRoom(String roomid,String roompassword)
	{
		message = "connectRoom\n"
		  +  roomid + "\n"
		  +	 roompassword;
	}
	
	public String getMessage()
	{
		message = new RowCounter(message).getRowCount() + "\n"
				+ message;
		
		return message;
	}

}

package d.handler;

import d.instruction.ConnectRoom;
import d.instruction.SendMessage;
import d.net.Connection;

public class ReceiveInstructionHandler {
	
	private Connection c;
	private String instruction;
	private String userid;
	private String s;
	
	public ReceiveInstructionHandler(Connection c,String instruction,String userid,String s)
	{
		this.c = c;
		this.instruction = instruction;
		this.userid = userid;
		this.s = s;
	}
	
	public void handler()
	{
		switch(instruction)
		{
			case "sendMessage":
				new SendMessage(userid,s);
				break;
			case "connectRoom":
				new ConnectRoom(c,s);
				break;
		}
	}
	

}

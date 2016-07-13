package d.handler;

import d.instruction.ReceiveMessage;
import d.net.Connection;

public class ReceiveInstructionHandler {
	
	private Connection c;
	private String instruction;
//	private String userid;
	private String s;
	
	public ReceiveInstructionHandler(Connection c,String instruction,String s)
	{
		this.c = c;
		this.instruction = instruction;
//		this.userid = userid;
		this.s = s;
	}
	
	public void handler()
	{
		switch(instruction)
		{
			case "sendMessage":
				new ReceiveMessage(c,s);
				break;
		}
	}

}

package d.rule;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ServerHost {
	
	private String serverhost;
	
	public ServerHost(String serverhost)
	{
		this.serverhost = serverhost;
	}
	
	public boolean isLegal()
	{
		try
		{
			InetAddress.getByName(serverhost);
		}
		catch(UnknownHostException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

}

package d.rule;

public class ServerPort {
	
	private String serverport;
	
	public ServerPort(String serverport)
	{
		this.serverport = serverport;
	}
	
	public boolean isLegal()
	{
		int temp = Integer.valueOf(serverport);
		if(temp<0||temp>65535)
		{
			return false;
		}
		return true;
	}

}

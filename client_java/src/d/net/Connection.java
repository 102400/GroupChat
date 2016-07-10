package d.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Connection {
	
	private InetAddress server_address;
	private int server_port;
	private String room_id;
	private String room_password;
	private String user_id;
	private String user_password;
	private Socket s;
	private PrintWriter pw;
	private BufferedReader br;
	
	//客户端所有连接的集合
	
	public Connection(String serverhost,String serverport,String roomid,String roompassword,String userid,String userpassword)
	{
		try
		{
			this.server_address = InetAddress.getByName(serverhost);
		}
		catch(UnknownHostException e)
		{
			e.printStackTrace();
		}
		this.server_port = Integer.valueOf(serverport);
		this.room_id = roomid;
		this.room_password = roompassword;
		this.user_id = userid;
		this.user_password = userpassword;
	}
	
	public boolean tryConnect()
	{
		try
		{
			s = new Socket(server_address,server_port);
			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					read();
				}
			}).start();
			//发送connectRoom()命令
			//指令分析器在接收到服务器指令后返回 布尔值,并在logtext中显示 操作的结果
			//超时则报错
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;  //默认应为false
	}
	
	public void read()
	{
		while(true)
		{
			try
			{
				String line = br.readLine();
				//line通过指令分析器进行处理
				//首次连接在接受到服务器的指令后,连通到指令分析器进行处理
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	public void write(String content)
	{
		pw.println(content);
		pw.flush();
	}

}

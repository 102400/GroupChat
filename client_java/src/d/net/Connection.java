package d.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.HashSet;

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
	
//	private static HashSet<Connection> connection_set = new HashSet<>();  //所有连接的集合
//	private static HashSet<String> hostport_set = new HashSet<>();  //所有连接的hostport String信息
	
	//所有连接的hostport String信息,尝试连接对象查询是否匹配到hostport信息,查询到则获取connection对象,没查询到则定义一个
	public static HashMap<String,Connection> hostport_map = new HashMap<>(); 
	private HashSet<Room> room_set = new HashSet<>();  //此连接的房间集合,必须host和port相同
	
	//客户端所有连接的集合
	
	public Connection(String serverhost,String serverport)
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
	}
	
	public boolean tryConnectServer()
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
			//发送connectServer()命令
			//指令分析器在接收到服务器指令后返回 布尔值,并在logtext中显示 操作的结果
			//超时则报错
//			write("abc\\naaa");  //测试
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;  //默认应为false
	}
	
	public boolean tryConnectRoom(String roomid,String roompassword,String userid,String userpassword)  //尝试连接房间
	{
		this.room_id = roomid;
		this.room_password = roompassword;
		this.user_id = userid;
		this.user_password = userpassword;
		
		return true;
	}
	
	public void read()
	{
		while(true)
		{
			try
			{  //可能要放个队列,不然来不及处理???
				String line = br.readLine();
				//line通过指令分析器进行处理
				//首次连接在接受到服务器的指令后,连通到指令分析器进行处理
			}
			catch(IOException e)
			{
				e.printStackTrace();
				//此处应放入个计数器?
				//如果与服务端停止了连接,此处就会不停的循环下去
			}
		}
	}
	
	public void write(String content)
	{
		pw.println(content);
		pw.flush();
	}

}

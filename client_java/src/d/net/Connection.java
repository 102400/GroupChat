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

import d.handler.ReceiveInstructionHandler;
import d.instruction.ConnectRoom;
import d.showlist.NewText;

public class Connection {
	
	private InetAddress server_address;
	private int server_port;
	private String user_id;  //只绑定user_id与password,room_id
	private String user_password;
	private Socket s;
	private PrintWriter pw;
	private BufferedReader br;
	
//	private static HashSet<Connection> connection_set = new HashSet<>();  //所有连接的集合
//	private static HashSet<String> hostport_set = new HashSet<>();  //所有连接的hostport String信息
	
	//所有连接的hostport String信息,尝试连接对象查询是否匹配到hostport信息,查询到则获取connection对象,没查询到则定义一个
	public static HashMap<String,Connection> hostportuserid_map = new HashMap<>(); 
	private HashMap<String,NewText> roompanel_map = new HashMap<>();  //此连接的所有房间的panel String为roomid,NewText为房间对应的panel
	
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
	
	public boolean tryConnectServer(String userid,String userpassword)  //验证userid唯一性,和password
	{
		try
		{
			s = new Socket(server_address,server_port);
			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			new Thread() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					read();
				}
			}.start();
			//发送connectServer()命令
			//指令分析器在接收到服务器指令后返回 布尔值,并在logtext中显示 操作的结果
			//超时则报错
//			write("abc\\naaa");  //测试
//			write("sendMessage(123,001,){\n聊天中\n};");
			
//			VerifyUserIDUserPassword
		}
		catch(IOException e)
		{
			e.printStackTrace();
			return false;
		}
		return true;  //默认应为false
	}
	
	public boolean tryConnectRoom(String roomid,String roompassword)  //尝试连接房间
	{
		String message = new ConnectRoom(roomid,roompassword).getMessage();
		System.out.println(message);
		write(message);
		return true;
	}
	
	/**
	 * 
	 * count=0	3
	 * count=1	sendMessage
	 * count=2	abc
	 * count=3	聊天内容
	 * 
	 */
	
	
	public void read()
	{
		while(true)
		{
			try
			{  
				
				int rows = 0;
				String instruction;
				StringBuilder sb = new StringBuilder();
				
				while(true)
				{
					String line = br.readLine();  //读取指令行数
					
					if(rows==0)
					{
						rows = Integer.valueOf(line);
						
						line = br.readLine();  //指令行
						instruction = line;
						
						for(int i=2;i<rows;i++)
						{
							line = br.readLine();
							sb.append(line + '\n');
						}
						line = br.readLine();
						sb.append(line);  //最后一行不加'\n'
						
//							System.out.println(sb.toString());
						
						new ReceiveInstructionHandler(this,instruction,sb.toString()).handler();
						
						sb = new StringBuilder();
						instruction = "";
						rows = 0;
					}
					
				}
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
	
	public synchronized void write(String content)
	{
		pw.println(content);
		pw.flush();
	}
	
	public HashMap<String,NewText> getRoomPanelMap()
	{
		return roompanel_map;
	}

}

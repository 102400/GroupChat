package d.net;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashSet;
import java.util.LinkedList;

public class Listen implements Runnable{
	
	private static int port = -1;  //监听端口
//	public static HashSet<Connection> connectionlist = new HashSet<>();  //主机所有连接对象
	
	static
	{
		try
		{
			InputStream is = new FileInputStream("config/port.ini");
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			port = Integer.valueOf(br.readLine());
			br.close();
			is.close();
		}
		catch(NumberFormatException | IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public Listen()
	{
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		Thread t = new Thread(new Runnable() {
			int tryconnect = 0;  //尝试连接总数
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ServerSocket ss;
				try
				{
					ss = new ServerSocket(port);
					System.out.println("port:"+port);
					while(true)
					{
						try
						{
							Socket s = ss.accept();
							tryconnect++;
							System.out.println("("+tryconnect+")客户端正在尝试连接");
							Connection handler = new Connection(s);
	//						connectionlist.add(handler);
							new Thread(handler).start();
						}
						catch(Exception ex)
						{
							ex.printStackTrace();
						}
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
			
		});
		t.start();
	}

}

package d.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Connection implements Runnable {
	
	private Socket s;
	private PrintWriter pw;
	private BufferedReader br;
	
	private boolean isReadLine = true;
	
	private String userid;
	
	public Connection(Socket s)
	{
		this.s = s;
		try
		{
			br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			pw = new PrintWriter(new OutputStreamWriter(s.getOutputStream()));
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

	@Override
	public void run()
	{
		read();
	}
	
	public void read()
	{
		try
		{
			while(isReadLine)
			{
				String line = br.readLine();  //读取一行
				//分析 line
				//检测这个连接在哪个房间...
				System.out.println(line);
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public void write(String message)  //接受message并发送
	{
		pw.println(message);
		pw.flush();
	}
	
	public void close()
	{
		isReadLine = false;
		pw.close();
		try
		{
			br.close();
			s.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}

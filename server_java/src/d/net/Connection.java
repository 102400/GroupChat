package d.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import d.handler.ReceiveInstructionHandler;


public class Connection implements Runnable {
	
	private Socket s;
	private PrintWriter pw;
	private BufferedReader br;
	
	private boolean isReadLine = true;
	
	private String userid;  //绑定的userid与password
	private String userpassword;
	
	{
		userid = "default";  //暂时设定
	}
	
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
	
	public void read()  //一旦抛异常,将不会读取
	{
		try
		{
			int rows = 0;
			String instruction;
			StringBuilder sb = new StringBuilder();
			
			while(isReadLine)
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
					
//					System.out.println(sb.toString());
					
					new ReceiveInstructionHandler(this,instruction,userid,sb.toString()).handler();
					
					sb = new StringBuilder();
					instruction = "";
					rows = 0;
				}
				
			}
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public synchronized void write(String message)  //接受message并发送
	{
		pw.println(message);
		pw.flush();
	}
	
//	public void close()
//	{
//		isReadLine = false;
//		pw.close();
//		try
//		{
//			br.close();
//			s.close();
//		}
//		catch(IOException e)
//		{
//			e.printStackTrace();
//		}
//	}

}

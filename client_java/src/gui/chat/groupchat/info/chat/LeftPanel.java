package gui.chat.groupchat.info.chat;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import d.handler.RowCounter;
import d.instruction.SendMessage;
import d.net.Connection;

public class LeftPanel extends JPanel {
	
	private JTextArea display = new JTextArea();
	private JTextArea input = new JTextArea();
	private JSplitPane topbottomsplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT,new JScrollPane(display),new JScrollPane(input));
	
	private Connection connection;
	private String roomid;
	
	public LeftPanel()
	{
		setLayout(new BorderLayout());
		
		display.setLineWrap(true);  //自动换行
		display.setWrapStyleWord(true);  //断行不断字
		input.setLineWrap(true);
		input.setWrapStyleWord(true);
		
		input.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER)  //当发生回车时
				{
					if(input.getText().equals(""))  //输入内容完全为空时,不做任何操作
					{
						return;
					}
//					System.out.println(input.getText());
					String s = new SendMessage(roomid,input.getText()).getMessage();  //发送给服务端的信息
					connection.write(s);
					
					
//					input.setText(null);  //清除输入框
					
					new Thread() {  //解决回车后切入下行的问题
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							try
							{
								Thread.currentThread().sleep(1);
							}
							catch (InterruptedException e)
							{
								e.printStackTrace();
							}
							//keypress比append先调用?,调用后在输入回车会造成第一行空行问题,先可以keypress,在append,所以先延时不清屏,等append后,在清空
							input.setText("");
						}
					}.start();
					
					
					
					
					
//					new Thread(()->{  //解决回车后切入下行的问题
//						try
//						{
//							Thread.currentThread().sleep(1);
//						}
//						catch(Exception e1)
//						{
//							e1.printStackTrace();
//						}
//						//keypress比append先调用?,调用后在输入回车会造成第一行空行问题,先可以keypress,在append,所以先延时不清屏,等append后,在清空
//						input.setText("");
//					}).start();
//					
//					
//					input.setText("");  //清除输入框
//					input.transferFocus();
				}
			}
		});
		
		topbottomsplit.setDividerLocation(650);  //分割条位置
		add(topbottomsplit);
		
//		display.setText("显示框"+Math.random()*100);
//		input.setText("输入框"+Math.random()*100);
	}
	
	public void setConnection(Connection connection)
	{
		this.connection = connection;
	}
	
	public void setRoomID(String roomid)
	{
		this.roomid = roomid;
	}
	
	public JTextArea getDisplay()
	{
		return display;
	}

}

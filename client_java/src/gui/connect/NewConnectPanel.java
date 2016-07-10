package gui.connect;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import d.net.Connection;
import d.showlist.NewText;
import gui.connect.form.FormPanel;

public class NewConnectPanel extends JPanel {
	
	private FormPanel formpanel = new FormPanel();
//	private JScrollPane scrollpane = new JScrollPane(formpanel);
	
	private JTextArea logtext = new JTextArea(10,1);
	private JButton submit = new JButton("连接");
	
	public NewConnectPanel()
	{
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		logtext.setEditable(false);
		
		submit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Thread t = new Thread(new Runnable() {
					
					//对userid进行服务端验证,确保唯一
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						boolean isFlushSuccess = formpanel.flushParameter();  //尝试刷新连接参数
						if(isFlushSuccess)
						{
							
							Connection c = new Connection(FormPanel.serverhost,FormPanel.serverport,FormPanel.roomid,FormPanel.roompassword,FormPanel.userid,FormPanel.userpassword);
							boolean connectsuccess = c.tryConnect();
							if(connectsuccess)
							{
								NewText newtext = new NewText();
								newtext.NT();
								String a = "("+FormPanel.roomid+")";
								String b = "("+FormPanel.serverhost+":"+FormPanel.serverport+" , "+FormPanel.roomid+")";
								newtext.getButton().setButtonText("room_name" + a);  //此处及下方的room_name应修改为从服务端获取的room name
								newtext.getButton().getGroupChatPanel().getTitlePanel().getNamePanel().getJButton().setText("room_name" + b);
								logtext.append("server = "+FormPanel.serverhost+":"+FormPanel.serverport+"\n");
								logtext.append("room-id = "+FormPanel.roomid+"\n");
								logtext.append("user-id = "+FormPanel.userid+"\n\n");
							}
							else
							{
								logtext.append("server连接异常");
							}
						}
						else
						{
							logtext.append("输入参数不合法!尝试刷新连接参数失败\n");
						}
					}
				});
				t.start();
			}
		});
		
		
		add(new JScrollPane(formpanel));
		add(new JScrollPane(logtext));
		add(submit);
		
	}

}

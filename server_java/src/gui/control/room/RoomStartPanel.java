package gui.control.room;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import d.net.Room;

public class RoomStartPanel extends JPanel {
	
	private JPanel leftpanel = new JPanel();
	
	private JPanel idpanel = new JPanel();
	private JLabel idlabel = new JLabel("id:                 ");
	private JTextField idtext = new JTextField();
	
	private JPanel passwordpanel = new JPanel();
	private JLabel passwordlabel = new JLabel("password: ");
	private JTextField passwordtext = new JTextField();
	
	
	private JButton rightbutton = new JButton("启动");
	
	
	private String id;
	private String password;
	private Room room;
	private boolean isRoomStart = false;
	
	public RoomStartPanel(RoomPanel roompanel)
	{
		setLayout(new BorderLayout());
		leftpanel.setLayout(new BoxLayout(leftpanel,BoxLayout.Y_AXIS));
		
		idpanel.setLayout(new BorderLayout());
		idpanel.add(idlabel,BorderLayout.WEST);
		idpanel.add(idtext);
		
		passwordpanel.setLayout(new BorderLayout());
		passwordpanel.add(passwordlabel,BorderLayout.WEST);
		passwordpanel.add(passwordtext);
		
		
		leftpanel.add(idpanel);
		leftpanel.add(passwordpanel);
		
		rightbutton.setBackground(Color.GREEN);
		rightbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				id = idtext.getText();
				password = passwordtext.getText();
				if(room==null)  //如果room不存在,则创建一个
				{
					room = new Room(id,password);
					roompanel.setRoom(room);  //设置RoomPanel
					
					idtext.setEditable(false);  //设置id及password文本框不可编辑
					passwordtext.setEditable(false);
				}
				
				
				//对房间进行启动和停止操作  ???
				if(!isRoomStart)  //房间未开时,进行启动操作
				{
					room.addRoom();
					
					rightbutton.setBackground(Color.RED);
					rightbutton.setText("停止");
					isRoomStart = true;
				}
				else if(isRoomStart)  //停止操作
				{
					room.removeRoom();  //从roomset移除
					
					rightbutton.setBackground(Color.GREEN);
					rightbutton.setText("启动");
					isRoomStart = false;
				}
				
				
				
//				对按钮风格进行操作(上方代码已实现)
//				if(!isRoomStart)  //房间未开时
//				{
//					rightbutton.setBackground(Color.RED);
//					rightbutton.setText("停止");
//					isRoomStart = true;
//				}
//				else if(isRoomStart)
//				{
//					rightbutton.setBackground(Color.GREEN);
//					rightbutton.setText("启动");
//					isRoomStart = false;
//				}
				
			}
		});
		
		add(leftpanel);
		add(rightbutton,BorderLayout.EAST);
	}

}

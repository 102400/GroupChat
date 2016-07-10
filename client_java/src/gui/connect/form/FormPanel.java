package gui.connect.form;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import d.rule.RoomID;
import d.rule.RoomPassword;
import d.rule.ServerHost;
import d.rule.ServerPort;
import d.rule.UserID;
import d.rule.UserPassword;

public class FormPanel extends JPanel {
	
	private ServerFormPanel serverformpanel = new ServerFormPanel();
	private RoomFormPanel roomformpanel = new RoomFormPanel();
	private UserFormPanel userformpanel = new UserFormPanel();
	
	public static String serverhost;
	public static String serverport;
	public static String roomid;
	public static String roompassword;
	public static String userid;
	public static String userpassword;
	
	public FormPanel()
	{
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		add(serverformpanel);
		add(roomformpanel);
		add(userformpanel);
	}
	
	//判断获得的参数是否合法
	public boolean flushParameter()
	{
//		boolean is_temp_serverhost_legal = true;
//		boolean is_temp_serverport_legal = true;
//		boolean is_temp_roomid_legal = true;
//		boolean is_temp_roompassword_legal = true;
//		boolean is_temp_userid_legal = true;
//		boolean is_temp_userpassword_legal = true;
		
		String temp_serverhost = serverformpanel.getServerHost();
		String temp_serverport = serverformpanel.getServerPort();
		String temp_roomid = roomformpanel.getRoomID();
		String temp_roompassword = roomformpanel.getRoomPassword();
		String temp_userid = userformpanel.getUserID();
		String temp_userpassword = userformpanel.getUserPassword();
		
		boolean is_temp_serverhost_legal = new ServerHost(temp_serverhost).isLegal();
		boolean is_temp_serverport_legal = new ServerPort(temp_serverport).isLegal();
		boolean is_temp_roomid_legal = new RoomID(temp_roomid).isLegal();
		boolean is_temp_roompassword_legal = new RoomPassword(temp_roompassword).isLegal();
		boolean is_temp_userid_legal = new UserID(temp_userid).isLegal();
		boolean is_temp_userpassword_legal = new UserPassword(temp_userpassword).isLegal();
		
		if(
				is_temp_serverhost_legal
				&&is_temp_serverport_legal
				&&is_temp_roomid_legal
				&&is_temp_roompassword_legal
				&&is_temp_userid_legal
				&&is_temp_userpassword_legal)
		{
			serverhost = temp_serverhost;
			serverport = temp_serverport;
			roomid = temp_roomid;
			roompassword = temp_roompassword;
			userid = temp_userid;
			userpassword = temp_userpassword;
			return true;
		}
		return false;  //刷新参数失败
	}

}

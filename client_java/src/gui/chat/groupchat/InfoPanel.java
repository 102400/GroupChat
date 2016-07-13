package gui.chat.groupchat;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import gui.chat.groupchat.info.ChatPanel;
import gui.chat.groupchat.info.NoticePanel;
import gui.chat.groupchat.info.SettingPanel;

public class InfoPanel extends JPanel {
	
	public ChatPanel chatpanel = new ChatPanel();
	public NoticePanel noticepanel = new NoticePanel();
	public SettingPanel settingpanel = new SettingPanel();
	
	public InfoPanel()
	{
		setLayout(new BorderLayout());
		setBorder(null);
		add(chatpanel);  //默认为聊天页面
	}
	
	public void setAdd(JPanel show)  //设置显示的panel
	{
		show.setVisible(false);
		removeAll();
		add(show);
		show.setVisible(true);
		repaint();
	}
	
	public ChatPanel getChatPanel()
	{
		return chatpanel;
	}

}

package gui.main;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import gui.chat.groupchat.GroupChatPanel;
import gui.global.CurrentChatPanel;
import gui.help.about.About;
import gui.help.updates.Updates;
import gui.help.welcome.Welcome;
import gui.text.ShowListPanel;

public class Panel extends JPanel{
	
	static final Welcome welcome = new Welcome();
	static final About about = new About();
	static final Updates updates = new Updates();
//	static final GroupChatPanel groupchatpanel = new GroupChatPanel();
	static final ShowListPanel showlistpanel = new ShowListPanel();
	
	private Frame frame;
	
	public Panel()
	{
		this.frame = frame;
		setLayout(new BorderLayout());
//		add(shell);
//		add(groupchatpanel);
//		CurrentChatPanel.group_list.add(groupchatpanel);
		
		add(showlistpanel);
	}
	
	public void setAdd(JPanel show)  //设置显示的panel
	{
		show.setVisible(false);
		removeAll();
		add(show);
		show.setVisible(true);
		repaint();
	}

}

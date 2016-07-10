package gui.main;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import gui.help.about.About;
import gui.help.updates.Updates;
import gui.help.welcome.Welcome;
import gui.text.EditPanel;

public class Panel extends JPanel{
	
	static final Welcome welcome = new Welcome();
	static final About about = new About();
	static final Updates updates = new Updates();
//	static final GroupChatPanel groupchatpanel = new GroupChatPanel();
//	static final ControlPanel controlpanel = new ControlPanel();
	static final EditPanel editpanel = new EditPanel();
	
	private Frame frame;
	
	public Panel()
	{
		this.frame = frame;
		setLayout(new BorderLayout());
//		add(shell);
//		add(groupchatpanel);
//		CurrentChatPanel.group_list.add(groupchatpanel);
		
		add(editpanel);
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

package gui.chat.groupchat;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class GroupChatPanel extends JPanel{
	
	private TitlePanel titlepanel = new TitlePanel();
	private InfoPanel infopanel = new InfoPanel();
	
	public GroupChatPanel()
	{
		setLayout(new BorderLayout());
		add(titlepanel,BorderLayout.NORTH);
		add(infopanel,BorderLayout.CENTER);
	}
	
	public InfoPanel getInfoPanel()
	{
		return infopanel;
	}
	
	public TitlePanel getTitlePanel()
	{
		return titlepanel;
	}

}

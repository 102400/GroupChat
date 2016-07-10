package gui.chat.groupchat.info;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import gui.chat.groupchat.info.chat.LeftPanel;
import gui.chat.groupchat.info.chat.RightPanel;

public class ChatPanel extends JPanel{
	
	private LeftPanel leftpanel = new LeftPanel();
	private RightPanel rightpanel = new RightPanel();
	private JSplitPane leftrightsplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,leftpanel,rightpanel);
	
	public ChatPanel()
	{
		setLayout(new BorderLayout());
		
		leftrightsplit.setDividerLocation(500);  //分割条位置
		leftrightsplit.setContinuousLayout(true);  //连续布局
		
		add(leftrightsplit);
	}

}

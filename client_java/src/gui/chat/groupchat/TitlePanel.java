package gui.chat.groupchat;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import gui.chat.groupchat.title.NamePanel;
import gui.chat.groupchat.title.ShowInfoButtonPanel;

public class TitlePanel extends JPanel {
	
	private NamePanel namepanel = new NamePanel();
	private ShowInfoButtonPanel showinfobuttonpanel = new ShowInfoButtonPanel();
//	private JScrollPane scrollpane = new JScrollPane(showinfobuttonpanel);
	
	public TitlePanel()
	{
//		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setLayout(new BorderLayout());
		setBorder(new LineBorder(new Color(0, 0, 0)));
		add(namepanel,BorderLayout.NORTH);
		add(showinfobuttonpanel,BorderLayout.SOUTH);
	}
	
	public NamePanel getNamePanel()
	{
		return namepanel;
	}

}

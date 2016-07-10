package gui.control.room;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import d.net.Room;

public class RoomNoticePanel extends JPanel {
	
	private JPanel leftpanel = new JPanel();
	private JLabel noticelabel = new JLabel("notice:        ");
	private JTextArea nt = new JTextArea(25,1);
	private JScrollPane noticetext = new JScrollPane(nt);
	
	private JButton rightbutton = new JButton("设置");
	
	private Room room;
	
	public RoomNoticePanel(RoomPanel roompanel)
	{
		setLayout(new BorderLayout());
		leftpanel.setLayout(new BorderLayout());
		
		leftpanel.add(noticelabel,BorderLayout.WEST);
		leftpanel.add(noticetext);
		
		rightbutton.setBackground(Color.WHITE);
		
		add(leftpanel);
		add(rightbutton,BorderLayout.EAST);
		
		
	}

}

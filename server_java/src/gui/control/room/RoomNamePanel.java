package gui.control.room;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import d.net.Room;

public class RoomNamePanel extends JPanel {
	
	private JPanel leftpanel = new JPanel();
	private JLabel namelabel = new JLabel("name:         ");
	private JTextField nametext = new JTextField();
	
	private JButton rightbutton = new JButton("设置");
	
	private Room room;
	
	public RoomNamePanel(RoomPanel roompanel)
	{	
		setLayout(new BorderLayout());
		leftpanel.setLayout(new BorderLayout());
		
		leftpanel.add(namelabel,BorderLayout.WEST);
		leftpanel.add(nametext);
		
		rightbutton.setBackground(Color.WHITE);
		
		add(leftpanel);
		add(rightbutton,BorderLayout.EAST);
		
		
	}

}

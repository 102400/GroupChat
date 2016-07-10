package gui.chat.groupchat.title;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class NamePanel extends JPanel {
	
	private JButton jbutton = new JButton();
	
	public NamePanel()
	{
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		setBackground(Color.WHITE);
		
		jbutton.setText("Test"+Math.random()*1000);
		jbutton.setBackground(Color.WHITE);
		jbutton.setBorder(null);
		
		add(jbutton);
	}
	
	public JButton getJButton()
	{
		return jbutton;
	}

}

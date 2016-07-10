package gui.chat.groupchat.info;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class SettingPanel extends JPanel {
	
	public SettingPanel()
	{
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		JTextPane jtp = new JTextPane();
		jtp.setText("test..."+Math.random()*100);
		JButton jb = new JButton(""+Math.random()*100);
		
		add(jtp);
		add(jb);
	}

}

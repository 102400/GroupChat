package gui.chat.groupchat.info;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class NoticePanel extends JPanel {
	
	public NoticePanel()
	{
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		JTextPane jtp = new JTextPane();
		jtp.setText("test..."+Math.random()*100);
		
		add(jtp);
	}

}

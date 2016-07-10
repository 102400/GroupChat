package gui.connect;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class NewConnectFrame extends JFrame {
	
	public NewConnectFrame()
	{
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(850, 100, 300, 500);
		NewConnectPanel panel = new NewConnectPanel();  //内容
		JScrollPane scrollpane = new JScrollPane(panel);
		setContentPane(scrollpane);
	}

}

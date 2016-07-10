package gui.chat.groupchat.info.chat;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class LeftPanel extends JPanel {
	
	private JTextArea display = new JTextArea();
	private JTextArea input = new JTextArea();
	
	private JSplitPane topbottomsplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT,new JScrollPane(display),new JScrollPane(input));
	
	public LeftPanel()
	{
		setLayout(new BorderLayout());
		
		topbottomsplit.setDividerLocation(650);  //分割条位置
		add(topbottomsplit);
		
		display.setText("显示框"+Math.random()*100);
		input.setText("输入框"+Math.random()*100);
	}

}

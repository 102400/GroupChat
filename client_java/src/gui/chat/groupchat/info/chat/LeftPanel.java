package gui.chat.groupchat.info.chat;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
		
		display.setLineWrap(true);  //自动换行
		display.setWrapStyleWord(true);  //断行不断字
		input.setLineWrap(true);
		input.setWrapStyleWord(true);
		
		input.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				if(e.getKeyCode()==KeyEvent.VK_ENTER)  //当发生回车时
				{
					System.out.println(input.getText());
					
					input.setText(null);  //清除输入框
				}
			}
		});
		
		topbottomsplit.setDividerLocation(650);  //分割条位置
		add(topbottomsplit);
		
		display.setText("显示框"+Math.random()*100);
		input.setText("输入框"+Math.random()*100);
	}

}

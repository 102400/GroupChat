package gui.text.split.buttonlist;

import gui.chat.groupchat.GroupChatPanel;
import gui.global.CurrentChatPanel;
import gui.text.ShowListPanel;
//import gui.text.split.text.Text;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Button extends JPanel {
	
//	private Text text = new Text();
	private GroupChatPanel groupchatpanel = new GroupChatPanel();
	
	private JButton closebutton = new JButton();
	private JButton button = new JButton();
	
	public Button()
	{
		setLayout(new BorderLayout());
		
		CurrentChatPanel.group_list.add(groupchatpanel);
//		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		
//		JButton closebutton = new JButton();
//		closebutton.setText("*");
//		closebutton.setBorder(new EmptyBorder(10, 10, 5, 5));
		closebutton.setBackground(Color.RED);
		closebutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ButtonListPanel.buttonlist.remove(Button.this);  //? 不知是否有效
				ShowListPanel.buttonlistpanel.remove(Button.this);
				ShowListPanel.splitpane.setRightComponent(ShowListPanel.emptypanel);
				ShowListPanel.buttonlistpanel.reload();
			}
		});
		
		
		add(closebutton,BorderLayout.WEST);
		
		
//		JButton button = new JButton();
//		button.setBorder(new EmptyBorder(0, 0, 0, 0));
		button.setText(""+(Math.random()*100+50-Math.random()*100));
		button.setBackground(Color.WHITE);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ShowListPanel.splitpane.setRightComponent(groupchatpanel);
				try
				{
					if(ButtonListPanel.stack.getLast()!=null)
					{
						ButtonListPanel.stack.getLast().setBackForegroundNormal();
					}
				}
				catch(Exception ex)
				{
					
				}
				setBackForegroundSelected();
				ButtonListPanel.stack.add(Button.this);
				ActiveButton.thisbutton = Button.this;
				
				CurrentChatPanel.group_list.add(groupchatpanel);
			}
		});
		add(button);
		
		ShowListPanel.splitpane.setRightComponent(groupchatpanel);
	}
	
	public void setBackForegroundNormal()  //按钮风格正常
	{
		button.setBackground(Color.WHITE);
		button.setForeground(Color.BLACK);
	}
	
	public void setBackForegroundSelected()  //按钮风格被选中
	{
		button.setBackground(Color.GREEN);
		button.setForeground(Color.WHITE);
	}
	
	public GroupChatPanel getGroupChatPanel()  //返回绑定的text
	{
		return groupchatpanel;
	}
	
	public void setButtonText(String buttontext)
	{
		button.setText(buttontext);
	}
	
	public void setCloseButtonText(String closebuttontext)
	{
		closebutton.setText(closebuttontext);
	}

}

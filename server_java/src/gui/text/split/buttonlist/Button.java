package gui.text.split.buttonlist;

import gui.control.room.RoomPanel;
import gui.text.EditPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

public class Button extends JPanel {
	
	private RoomPanel rp = new RoomPanel();
	private JScrollPane roompanel = new JScrollPane(rp);
	
	private JButton closebutton = new JButton();
	private JButton button = new JButton();
	
	public Button()
	{
		setLayout(new BorderLayout());
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
				EditPanel.buttonlistpanel.remove(Button.this);
				EditPanel.splitpane.setRightComponent(EditPanel.emptypanel);
				EditPanel.buttonlistpanel.reload();
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
				EditPanel.splitpane.setRightComponent(roompanel);
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
			}
		});
		add(button);
		
		EditPanel.splitpane.setRightComponent(roompanel);
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
	
	public JScrollPane getText()  //返回绑定的text
	{
		return roompanel;
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

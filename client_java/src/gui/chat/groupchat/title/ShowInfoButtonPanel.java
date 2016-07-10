package gui.chat.groupchat.title;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import gui.chat.groupchat.info.ChatPanel;
import gui.chat.groupchat.info.NoticePanel;
import gui.chat.groupchat.info.SettingPanel;
import gui.global.CurrentChatPanel;

public class ShowInfoButtonPanel extends JPanel{
	
	private JButton showchatbutton = new JButton(" 聊天 ");
	private JButton shownoticebutton = new JButton(" 公告 ");
	private JButton showsettingbutton = new JButton(" 设置 ");
	
	private LinkedList<JButton> buttonstack = new LinkedList<>();
	
	public ShowInfoButtonPanel()
	{
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		setBackground(Color.WHITE);
		
		showchatbutton.setBackground(Color.WHITE);
		shownoticebutton.setBackground(Color.WHITE);
		showsettingbutton.setBackground(Color.WHITE);
		showchatbutton.setBorder(new EmptyBorder(0, 0, 0, 0));
		shownoticebutton.setBorder(new EmptyBorder(0, 0, 0, 0));
		showsettingbutton.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		showchatbutton.setBackground(Color.GREEN);  //默认按钮风格
		showchatbutton.setBorder(new LineBorder(new Color(0, 0, 0)));
		buttonstack.add(showchatbutton);  //默认增加至buttonstack
		
		showchatbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ChatPanel chatpanel = CurrentChatPanel.group_list.getLast().getInfoPanel().chatpanel;
				CurrentChatPanel.group_list.getLast().getInfoPanel().setAdd(chatpanel);
				
				setOtherButtonStyle();
				buttonstack.add(showchatbutton);
				setCurrentButtonStyle();
			}
		});
		
		shownoticebutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				NoticePanel noticepanel = CurrentChatPanel.group_list.getLast().getInfoPanel().noticepanel;
				CurrentChatPanel.group_list.getLast().getInfoPanel().setAdd(noticepanel);
				
				setOtherButtonStyle();
				buttonstack.add(shownoticebutton);
				setCurrentButtonStyle();
			}
		});
		
		showsettingbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SettingPanel settingpanel = CurrentChatPanel.group_list.getLast().getInfoPanel().settingpanel;  //当前页面的settingpanel
				CurrentChatPanel.group_list.getLast().getInfoPanel().setAdd(settingpanel);
				
				setOtherButtonStyle();
				buttonstack.add(showsettingbutton);
				setCurrentButtonStyle();
			}
		});
		
		add(showchatbutton);
		add(shownoticebutton);
		add(showsettingbutton);
	}
	
	public void setCurrentButtonStyle()  //设置选中button风格
	{
		buttonstack.getLast().setBackground(Color.GREEN);
		buttonstack.getLast().setBorder(new LineBorder(new Color(0, 0, 0)));
	}
	
	public void setOtherButtonStyle()  //设置未选中button风格
	{
		buttonstack.getLast().setBackground(Color.WHITE);
		buttonstack.getLast().setBorder(new EmptyBorder(0, 0, 0, 0));
	}

}

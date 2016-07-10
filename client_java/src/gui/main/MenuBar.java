package gui.main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuBar extends JMenuBar {
	
	private Panel panel;
	
	public MenuBar()
	{
		
	}
	
	public MenuBar(Panel panel)
	{
//		JMenuBar menuBar = new JMenuBar();
//		setJMenuBar(menuBar);
		this.panel = panel;
		JMenu menuStart = new JMenu("开始");
		add(menuStart);
		
		JMenuItem menuitem_groupchat = new JMenuItem("群聊");
		menuitem_groupchat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setAdd(Panel.showlistpanel);
			}
		});
		menuStart.add(menuitem_groupchat);
		
		JMenu menu_Help = new JMenu("帮助");
		add(menu_Help);
		
		JMenuItem menuitem_Welcome = new JMenuItem("欢迎");
		menuitem_Welcome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setAdd(Panel.welcome);
			}
		});
		menu_Help.add(menuitem_Welcome);
		
		JMenuItem menuitem_Updates = new JMenuItem("更新");
		menuitem_Updates.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setAdd(Panel.updates);
			}
		});
		menu_Help.add(menuitem_Updates);
		
		JMenuItem menuitem_About = new JMenuItem("关于");
		menuitem_About.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				panel.setAdd(Panel.about);
			}
		});
		menu_Help.add(menuitem_About);
	}

}

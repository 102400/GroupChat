package gui.text.split.buttonlist;

import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ButtonListPanel extends JPanel {
	
//	public static ButtonListPanel buttonlistpanel = new ButtonListPanel();
	public static LinkedList<Button> buttonlist = new LinkedList<>();
	public static LinkedList<Button> stack = new LinkedList<>();  //当前选项卡及上一个选项卡,将记录所有单击Button动作[预留功能]
	
	public ButtonListPanel()
	{
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
	}
	
	public void reload()  //设置显示的panel
	{
		this.setVisible(false);
		this.setVisible(true);
		repaint();
	}

}

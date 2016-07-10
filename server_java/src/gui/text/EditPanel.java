package gui.text;

import gui.text.editbutton.EditButtonPanel;
import gui.text.split.SplitPane;
import gui.text.split.buttonlist.ButtonListPanel;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class EditPanel extends JPanel {
	
	public static EditButtonPanel editbuttonpanel = new EditButtonPanel();
	public static EmptyPanel emptypanel = new EmptyPanel();
	public static ButtonListPanel buttonlistpanel = new ButtonListPanel();
	public static SplitPane splitpane = new SplitPane(JSplitPane.HORIZONTAL_SPLIT,new JScrollPane(buttonlistpanel),emptypanel);
	
	public EditPanel()
	{
		setLayout(new BorderLayout());
		add(editbuttonpanel,BorderLayout.NORTH);
		
		splitpane.setContinuousLayout(true);
		splitpane.setOneTouchExpandable(true);
		
		add(splitpane,BorderLayout.CENTER);
	}
}

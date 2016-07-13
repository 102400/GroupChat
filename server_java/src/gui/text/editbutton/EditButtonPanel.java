package gui.text.editbutton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

//import d.CloseAllFiles;
//import d.CloseFile;
//import d.OpenFile;
//import d.SaveAllFiles;
//import d.SaveAs;
//import d.SaveFile;
import d.showlist.NewText;

public class EditButtonPanel extends JPanel {
	
	public EditButtonPanel()
	{
		setLayout(new BoxLayout(this,BoxLayout.X_AXIS));
		JButton newtextbutton = new JButton();
		newtextbutton.setBackground(Color.WHITE);
		newtextbutton.setText("新建房间");
		newtextbutton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				NewText newtext = new NewText();
				newtext.NT();
				
				
//				ButtonListPanel.buttonlist.add(new Button());
//				EditPanel.buttonlistpanel.add(ButtonListPanel.buttonlist.getLast(),0);
//				EditPanel.buttonlistpanel.reload();
			}
		});
		
		
		add(newtextbutton);
	}

}

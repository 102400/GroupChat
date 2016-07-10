package d.showlist;

import gui.text.ShowListPanel;
import gui.text.split.buttonlist.ActiveButton;
import gui.text.split.buttonlist.Button;
import gui.text.split.buttonlist.ButtonListPanel;

public class NewText {
	
	private Button button;
	private static int newcount = 1;
	
	public NewText()
	{
		
	}
	
	public void NT()
	{
		ButtonListPanel.buttonlist.add(button = new Button());
		ShowListPanel.buttonlistpanel.add(ButtonListPanel.buttonlist.getLast(),0);
		
		button.setButtonText("new"+newcount);
		newcount++;
		
		ActiveButton setthisbutton = new ActiveButton(button);
		setthisbutton.STB();
		
		ShowListPanel.buttonlistpanel.reload();
	}
	
	public Button getButton()
	{
		return button;
	}

}

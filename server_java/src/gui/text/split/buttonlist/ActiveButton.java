package gui.text.split.buttonlist;

import gui.text.EditPanel;

public class ActiveButton {  //设置当前使用的button的颜色,与不活动的button区分开来
	
	public static Button thisbutton;  //活动的button
	
	public ActiveButton()
	{
		
	}
	
	public ActiveButton(Button thisbutton)
	{
		this.thisbutton = thisbutton;
	}
	
	public void STB()
	{
//		EditPanel.splitpane.setRightComponent(text);
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
		thisbutton.setBackForegroundSelected();
		ButtonListPanel.stack.add(thisbutton);
	}

}

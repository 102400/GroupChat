package gui.text.split;

import java.awt.Component;

import javax.swing.JSplitPane;

public class SplitPane extends JSplitPane {
	
	public SplitPane()
	{
		
	}
	
	public SplitPane(int newOrientation,Component newLeftComponent,Component newRightComponent)
	{
		super(newOrientation,newLeftComponent,newRightComponent);
//		setDividerLocation(20);
		setDividerLocation(200);  //设置分隔条的位置
	}
	
//	public void setRightComponent(Component comp)
//	{
//		super.setRightComponent(comp);
//	}

}

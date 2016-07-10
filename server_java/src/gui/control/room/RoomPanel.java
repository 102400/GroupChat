package gui.control.room;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import d.net.Room;

public class RoomPanel extends JPanel{
	
	private RoomStartPanel roomstartpanel = new RoomStartPanel(this);
	private RoomNamePanel roomnamepanel = new RoomNamePanel(this);
	private RoomNoticePanel roomnoticepanel = new RoomNoticePanel(this);
	
	private Room room;
	
	public RoomPanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		
		add(roomstartpanel);
		add(roomnamepanel);
		add(roomnoticepanel);
	}
	
	public void setRoom(Room room)
	{
		this.room = room;
	}
	
	public Room getRoom()
	{
		return room;
	}

}

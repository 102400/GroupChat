package d.net;

import java.util.HashSet;

public class Room {
	
	public static HashSet<Room> roomset = new HashSet<>();  //所有房间集合
	
	private String id;
	private String password;
	
	private HashSet<Connection> connection_set = new HashSet<>();  //此房间的连接集合,size相当于人数
//	private HashSet<String> userid_set = new HashSet<>();  //用户id集合
	
	public Room(String id,String password)
	{
		this.id = id;
		this.password = password;
	}
	
	public void addRoom()
	{
		roomset.add(this);
	}
	
	public void removeRoom()
	{
		roomset.remove(this);
	}

}

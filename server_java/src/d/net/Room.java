package d.net;

import java.util.HashMap;
import java.util.HashSet;

public class Room {
	
//	public static HashSet<Room> roomset = new HashSet<>();  //所有房间集合
	public static HashMap<String,Room> roommap = new HashMap<>();  //通过id查询room
	public static HashMap<String,String> roompasswordmap = new HashMap<>();  //通过id查询roompassword
	
	private String id;
	private String password;
	
	private HashSet<Connection> connection_set = new HashSet<>();  //此房间的连接集合,size相当于人数
//	private HashSet<String> userid_set = new HashSet<>();  //用户id集合
	
	public Room(String id,String password)
	{
		this.id = id;
		this.password = password;
		roompasswordmap.put(id, password);
	}
	
	public void addRoom()
	{
//		roomset.add(this);
		roommap.put(id,this);
	}
	
	public void removeRoom()
	{
//		roomset.remove(this);
		roommap.remove(id);
	}
	
	public HashSet<Connection> getConnectionSet()
	{
		return connection_set;
	}

}

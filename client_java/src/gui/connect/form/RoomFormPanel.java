package gui.connect.form;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RoomFormPanel extends JPanel {
	
	private JLabel label = new JLabel("Room");
	private JPanel idpanel = new JPanel();
	private JPanel passwordpanel = new JPanel();
	
	private JLabel idlabel = new JLabel("id:                ");
	private JTextField idtext = new JTextField();
	
	private JLabel passwordlabel = new JLabel("password: ");
	private JTextField passwordtext = new JTextField();
	
	private String roomid;
	private String roompassword;
	
	public RoomFormPanel()
	{
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		idpanel.setLayout(new BoxLayout(idpanel,BoxLayout.X_AXIS));
		idpanel.add(idlabel);
		idpanel.add(idtext);
		
		passwordpanel.setLayout(new BoxLayout(passwordpanel,BoxLayout.X_AXIS));
		passwordpanel.add(passwordlabel);
		passwordpanel.add(passwordtext);
		
		add(label);
		add(idpanel);
		add(passwordpanel);
	}
	
	public String getRoomID()
	{
		roomid = idtext.getText();
		return roomid;
	}
	
	public String getRoomPassword()
	{
		roompassword = passwordtext.getText();
		return roompassword;
	}

}

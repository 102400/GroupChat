package gui.connect.form;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ServerFormPanel extends JPanel {
	
	private JLabel label = new JLabel("Server");
	private JPanel hostpanel = new JPanel();
	private JPanel portpanel = new JPanel();
	
	private JLabel hostlabel = new JLabel("host:           ");
	private JTextField hosttext = new JTextField();
	
	private JLabel portlabel = new JLabel("port:            ");
	private JTextField porttext = new JTextField();
	
	private String serverhost;
	private String serverport;
	
	public ServerFormPanel()
	{
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		hostpanel.setLayout(new BoxLayout(hostpanel,BoxLayout.X_AXIS));
		hostpanel.add(hostlabel);
		hostpanel.add(hosttext);
		
		portpanel.setLayout(new BoxLayout(portpanel,BoxLayout.X_AXIS));
		portpanel.add(portlabel);
		portpanel.add(porttext);
		
		add(label);
		add(hostpanel);
		add(portpanel);
	}
	
	public String getServerHost()
	{
		serverhost = hosttext.getText();
		return serverhost;
	}
	
	public String getServerPort()
	{
		serverport = porttext.getText();
		return serverport;
	}

}

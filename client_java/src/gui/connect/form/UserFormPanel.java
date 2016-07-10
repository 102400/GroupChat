package gui.connect.form;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UserFormPanel extends JPanel {
	
	private JLabel label = new JLabel("User");
	private JPanel idpanel = new JPanel();
	private JPanel passwordpanel = new JPanel();
	
	private JLabel idlabel = new JLabel("id(name):   ");
	private JTextField idtext = new JTextField();
	
	private JLabel passwordlabel = new JLabel("password: ");
	private JTextField passwordtext = new JTextField();
	
	private String userid;
	private String userpassword;
	
	public UserFormPanel()
	{
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		passwordtext.setEditable(false);  //设置用户密码框不可编辑
		
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
	
	public String getUserID()
	{
		userid = idtext.getText();
		return userid;
	}
	
	public String getUserPassword()
	{
		userpassword = passwordtext.getText();
		return userpassword;
	}

}

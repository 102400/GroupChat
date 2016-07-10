package gui;

import java.awt.EventQueue;

import d.net.Listen;
import gui.main.Frame;

public class Start{
	
	private static Frame mframe = new Frame();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		System.setProperty("sun.jnu.encoding","utf-8");
//		System.setProperty("file.encoding","utf-8");
		
		Listen listen = new Listen();
		Thread t_listen = new Thread(listen);
		t_listen.start();
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Frame frame = new Frame();
					mframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Start() {
		
	}
}

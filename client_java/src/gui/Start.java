package gui;

import java.awt.EventQueue;

import gui.connect.NewConnectFrame;
import gui.main.Frame;

public class Start{
	
	private static Frame mframe = new Frame();
	public static NewConnectFrame connectframe = new NewConnectFrame();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
//		System.setProperty("sun.jnu.encoding","utf-8");
//		System.setProperty("file.encoding","utf-8");
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
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					NewConnectFrame frame = new NewConnectFrame();
					connectframe.setVisible(true);
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

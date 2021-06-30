package com.facedetection.app;

import com.detection.gui.MainFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class App { 
	public static void main(String arg[]) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace(); 
		}
		SwingUtilities.invokeLater(new Runnable(){
		 public void run() {
			 new MainFrame();
		 }
		 });
	}

}

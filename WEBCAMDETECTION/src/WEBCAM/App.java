package WEBCAM;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;



public class App { 
	public static void main(String arg[]){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch(ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
			e.printStackTrace(); 
		}
		MainFrame mainFrame=new MainFrame();
		mainFrame.displayScreen();
	}

}


package GUI;

import javax.swing.JFrame;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

import algorithme.Detector;

public class MainFrame2 extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Detector detector;
	private  CameraPanel2 cameraPanel;
	
	public MainFrame2() {
		super("Face Detector");
	
	System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	
	detector =new Detector();
	cameraPanel=new CameraPanel2();
	
	 setContentPane(cameraPanel);
	 
	 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 setSize(800,600);
	 setLocationRelativeTo(this);
	 setVisible(true);
	}
	public void displayScreen(){
	Mat webcamImage =new Mat();
	VideoCapture videoCapture =new VideoCapture(0);
	
	if(videoCapture.isOpened()) {
		while(true) {
		videoCapture.read(webcamImage);
		
		if(!webcamImage.empty()) {
			setSize(webcamImage.width()+50,webcamImage.height()+70);
			webcamImage=detector.detect(webcamImage);
			cameraPanel.convertMatToImage(webcamImage);
			cameraPanel.repaint();
		} else {
			System.out.println("ERROR");
			break;
		}
		
	}
		
	}
	
}
} 

package algorithme;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import Constants.Constants;

public class Detector {
	private CascadeClassifier cascadeClassifier;
	private MatOfRect detectedfaces;
	private Mat ColoredImage;
	private Mat GreyImage;
	
	public Detector() {
		this.detectedfaces=new MatOfRect();
		this.cascadeClassifier=new CascadeClassifier(Constants.CASCADE_CLASSIFIER);
		this.ColoredImage=new Mat();
		this.GreyImage=new Mat();
		
	}
	
	public 	Mat detect(Mat inputFrame) {
		
		inputFrame.copyTo(ColoredImage);
		inputFrame.copyTo(GreyImage);
		
		
		Imgproc.cvtColor(ColoredImage,GreyImage,Imgproc.COLOR_BGR2GRAY);
		
		Imgproc.equalizeHist(GreyImage, GreyImage);
		
		cascadeClassifier.detectMultiScale(GreyImage, detectedfaces,1.2,3,10,new Size(20,20),new Size(500,500));
		
		showFacesOnScreen();

		
		return ColoredImage;
		
	}

	private void showFacesOnScreen() {
		// TODO Auto-generated method stub
		for(Rect rect: detectedfaces.toArray()) {
			Imgproc.rectangle(ColoredImage, new Point(rect.x,rect.y),new Point(rect.x+rect.width,rect.y+rect.height),new Scalar(100,134,104),5);;
					}
		
		
	}
}

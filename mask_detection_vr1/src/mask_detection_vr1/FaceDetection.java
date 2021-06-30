package mask_detection_vr1;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
//import static org.opencv.objdetect.Objdetect.CASCADE_SCALE_IMAGE;

public class FaceDetection {
	   CascadeLoader myCascade;
	   

	    public FaceDetection(CascadeLoader myCascade) {
	        this.myCascade = myCascade;
	    }

	    public MatOfRect detectFace(Mat frame){
	        /*at this point Once we’ve loaded the classifiers we are ready to start the detection;
	         we are going to implement the detection in the detectAndDisplay method. First of all we need to convert the frame
	         in grayscale and equalize the histogram to improve the results:*/

	        Mat grayFrame = new Mat();

	        Imgproc.cvtColor(frame, grayFrame, Imgproc.COLOR_BGR2GRAY);
	        Imgproc.equalizeHist(grayFrame, grayFrame);
	        MatOfRect faces = new MatOfRect();

	        //now we can start the detection
	        CascadeClassifier cascade = myCascade.loadCascade();
	        cascade.detectMultiScale(grayFrame, faces, 1.1, 2,4,new Size(10,10), new Size());

	        //So the result of the detection is going to be in the objects parameter or in our case faces.

	        //Let’s put this result in an array of rects and draw them on the frame, by doing so we can display the detected face are
	        return faces;
	    }
}

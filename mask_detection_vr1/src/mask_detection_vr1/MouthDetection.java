 package mask_detection_vr1;

import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.objdetect.CascadeClassifier;

//import static org.opencv.objdetect.Objdetect.CASCADE_SCALE_IMAGE;

public class MouthDetection {

	  CascadeLoader myCascade;

	    public MouthDetection(CascadeLoader myCascade) {
	        this.myCascade = myCascade;
	    }
	        public MatOfRect detectMouth(Mat frame, Rect r) {

	            //MOUTH DETECTION CODE STARTS HERE
	            Mat face = new Mat(frame, r);
	            MatOfRect mouth = new MatOfRect();
	            
	            CascadeClassifier cascade = myCascade.loadCascade();
	            cascade.detectMultiScale(face, mouth,1.9, 2,0, new Size(10,30), new Size());
	            return  mouth;
	        }
}

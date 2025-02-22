import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
public class Jfacedetection { 

	public static void main(String[] args) throws Exception {
		// Loading the OpenCV core library
	      
	      System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

	      // Reading the Image from the file and storing it in to a Matrix object
	      String file ="‪D:/FD/FaceDetection/img/img.jpg";
	      Mat src = Imgcodecs.imread(file);

	      // Instantiating the CascadeClassifier
	      String xmlFile = "D:/apks/OpenCv3.0/opencv/sources/modules/java/common_test/res/raw/lbpcascade_frontalface.xml";
	      
	      CascadeClassifier classifier = new CascadeClassifier(xmlFile);
	     
	      // Detecting the face in the snap
	      MatOfRect faceDetection = new MatOfRect();
	      classifier.detectMultiScale(src, faceDetection);
	      System.out.println(String.format("Detected %s faces",faceDetection.toArray().length));
	      
	      // Drawing boxes
	      for(Rect rect:faceDetection.toArray()){ Imgproc.rectangle(src,
	        		 new Point(rect.x,rect.y),
	        		 new Point(rect.x + rect.width, rect.y + rect.height),
	        		 new Scalar(0, 0,255),
	        		 3);}

	      // Writing the image
	      Imgcodecs.imwrite("‪D:/FD/FaceDetection/img/img.jpg",src);

	      System.out.println("Image Processed");
	   }

}

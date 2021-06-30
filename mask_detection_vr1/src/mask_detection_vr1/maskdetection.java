//package mask_detection_vr1;
//
//import org.opencv.core.Core;
//import org.opencv.core.Mat;
//import org.opencv.core.MatOfRect;
//import org.opencv.core.Point;
//import org.opencv.core.Rect;
//import org.opencv.highgui.HighGui;
//import org.opencv.core.Scalar;
////import org.opencv.core.Core.Formatter_FMT_NUMPY;
//import org.opencv.imgproc.Imgproc;
//import org.opencv.videoio.VideoCapture;
////import static org.opencv.objdetect.Objdetect.CASCADE_SCALE_IMAGE;
//public class maskdetection {
//
//	 static {System.loadLibrary(Core.NATIVE_LIBRARY_NAME);}
//
//	   public static void main(String[] args) {
//
//
//	        //start camera
//	        VideoCapture capture  = new VideoCapture(0);
//
//
//	        Mat frame = new Mat();
//
//	        //choosing the canvas colors
//	        Scalar redColor = new Scalar(111, 71, 239);
//	        Scalar greenColor = new Scalar(0, 255, 0, 255);
//	        Scalar whiteColor = new Scalar(255, 255, 255);
//
//	        //camera error
//	        if(!capture.isOpened()){
//	            System.out.println("No cam found");
//	            return;
//	        }
//
//	        //start detecting
//	        while (true) {
//
//	            //read each frame from the input camera and store it in the frame matrix
//	            capture.read(frame);
//
//	            //face detection:
//
//	            //create a cascade
//	            CascadeLoader faceCascade2 = new CascadeLoader("D:\\PROJECT\\mask_detection_vr1\\xml\\face.xml");
//
//	            //faceDetection:
//
//	            FaceDetection faceDetection = new FaceDetection(faceCascade2);
//	            MatOfRect faces = faceDetection.detectFace(frame);
//
//	            //return the faces
//	            Rect[] faceRects = faces.toArray();
//
//	            //now let's move to the mouth detection
//	            if(faceRects.length>0) {
//	                for (Rect r : faceRects) {
//
//	                    //handle the dimension of the canvas
//	                    Point startingPoint = new Point(r.tl().x-1,r.br().y);
//	                    Point endingPoint = new Point(r.br().x,r.br().y+25);
//
//	                    double fontScale = (r.br().x/r.tl().x)/3;
//
//
//
//	                    //MOUTH DETECTION CODE STARTS HERE
//
//	                    //create the cascade
//	                    CascadeLoader mouthCascade = new CascadeLoader("D:\\PROJECT\\mask_detection_vr1\\xml\\Mouth.xml");
//	                    //pass the cascade to the mouthDetection
//
//	                    MouthDetection mouthDetections = new MouthDetection(mouthCascade);
//	                    MatOfRect mouth = mouthDetections.detectMouth(frame, r);
//	                    Rect[] mouthRects = mouth.toArray();
//
//
//	                    if(mouthRects.length < 1 ){
//	                        //draw a green canvas
//	                        Imgproc.rectangle(frame, r.tl(), r.br(), greenColor, 3);
//	                        //draw background
//	                        Imgproc.rectangle(frame,startingPoint,endingPoint,greenColor,-1);
//	                        //put the message
//	                        Imgproc.putText(frame,"thank you",new Point(r.tl().x+5,r.br().y+18),4,fontScale,whiteColor,1);
//	                    }
//
//	                    else if(mouthRects.length > 1 ){
//	                        //draw a red canvas
//	                        Imgproc.rectangle(frame, r.tl(), r.br(), redColor, 3);
//	                        //draw background
//	                        Imgproc.rectangle(frame,startingPoint,endingPoint,redColor,-1);
//	                        //put the message
//	                        Imgproc.putText(frame,"Please wear your mask!",new Point(r.tl().x+5,r.br().y+18),4,fontScale,whiteColor,1);
//	                    }
//	                }
//	            }
//	            HighGui.imshow("Feature Detection",frame);
//	            if (HighGui.waitKey(30)>=0) break;
//	        }
//	    }
//}

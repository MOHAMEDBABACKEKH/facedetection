package algorithme;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
//import java.awt.Point;
import java.io.File;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import GUI.ImagePanel;
import Constants.Constants;

public class FaceDetection {
	
	private CascadeClassifier cascadeClassifier;
	public FaceDetection() {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		this.cascadeClassifier=new CascadeClassifier(Constants.CASCADE_CLASSIFIER);	
	}
	public void detectfaces(File file,ImagePanel imagePanel) {
		
		Mat image=Imgcodecs.imread(file.getAbsolutePath(),Imgcodecs.CV_LOAD_IMAGE_COLOR);
		MatOfRect facedetections= new MatOfRect();
		cascadeClassifier.detectMultiScale(image,facedetections,1.2,3,10,new Size(20,20),new Size(500,500));
		
		for(Rect rect :facedetections.toArray()) {
			Imgproc.rectangle(image, new Point(rect.x,rect.y),new Point(rect.x+rect.width,rect.y+rect.height),new Scalar(150,134,124),10);;	
		}
		BufferedImage bufferedimage= convertMatToImage(image);
		imagePanel.updateImage(bufferedimage);
	}
	private BufferedImage convertMatToImage(Mat mat) {
		
		int type= BufferedImage.TYPE_BYTE_GRAY;
		if(mat.channels()>1) {
			 type=BufferedImage.TYPE_3BYTE_BGR;
		}
		int bufferSize=mat.channels()*mat.cols()*mat.rows();
		byte[] bytes=new byte[bufferSize];
		mat.get(0,0,bytes);
		BufferedImage image = new BufferedImage(mat.cols(),mat.rows(),type);
		final byte[] targetPixels=  ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
		System.arraycopy(bytes,0, targetPixels, 0,bytes.length);

		return image;
	}
}

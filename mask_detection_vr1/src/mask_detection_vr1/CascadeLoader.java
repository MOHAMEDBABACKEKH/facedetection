package mask_detection_vr1;

import org.opencv.objdetect.CascadeClassifier;

public class CascadeLoader {
	String fileName;

    public CascadeLoader(String fileName) {
        this.fileName = fileName;
    }

    public CascadeClassifier loadCascade(){
        //load the classifiers
        CascadeClassifier cascade = new CascadeClassifier();
        cascade.load(this.fileName);
        return cascade;
    }
}

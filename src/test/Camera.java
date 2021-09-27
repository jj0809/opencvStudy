package test;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public class Camera {
	
	static {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
	}

	public static void main(String[] args) {

	    Camera cam = new Camera();
	    String addressString = "rtsp://admin:intuintu1!@192.168.2.59:554/profile2/media.smp";
	    Mat mat = new Mat();
	    VideoCapture capturedVideo = new VideoCapture();

	    boolean isOpened = capturedVideo.open(addressString); 
	    System.out.println("rtsp 실행.....");
	    cam.openRTSP(isOpened, capturedVideo, mat);

	}

	public void openRTSP(boolean isOpened, VideoCapture capturedVideo, Mat cameraMat) {
	    if (isOpened) {
	        boolean tempBool = capturedVideo.read(cameraMat);
	        System.out.println("VideoCapture returned mat? "+tempBool);

	        if (!cameraMat.empty()) {
	            System.out.println("Print image size: "+cameraMat.size());
	            //processing image captured in cameraMat object

	        } else {
	            System.out.println("Mat is empty.");
	        }
	    } else {
	        System.out.println("Camera connection problem. Check addressString");
	    }
	}
	}

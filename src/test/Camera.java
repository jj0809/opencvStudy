package test;

import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

public class Camera {
	
	
	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		System.out.println("load success");
		Mat mat = Mat.eye(5, 5, CvType.CV_8UC(1));
		System.out.println(mat.dump());
		
	}
}

package test;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

public class Camera3 {
    static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }
 
    public static void main(String[] args)
    {
        String RTSP_URL = "rtsp url";
 
 
        Mat frame = new Mat();
        VideoCapture cap = new VideoCapture(RTSP_URL);
 
        if (!cap.isOpened()) {
            System.out.println("Cannot open RTSP stream");
            System.exit(-1);
        }
 
        while (true) {
            cap.read(frame);
            HighGui.imshow("RTSP stream", frame);
 
            if (HighGui.waitKey(1) == 27) {
                break;
            }
        }
 
        cap.release();
        HighGui.destroyAllWindows();
 
        System.exit(0);
    }
}
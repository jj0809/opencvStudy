package test;

import javax.swing.JButton;

import org.opencv.core.Mat;
import org.opencv.videoio.VideoCapture;

public class Camera {

	static {

		System.loadLibrary("opencv_java300");
	}

	public static void main(String[] args) {
	        // TODO Auto-generated method stub

	        VideoCapture cap = new VideoCapture("rtsp url");
	                try {
	            System.out.println("Delay waiting..");
	            Thread.sleep(10000); // wait while stream open from dvr
	            System.out.println("Delay end..");
	        } catch(InterruptedException ex) {
	            Thread.currentThread().interrupt();
	        }

	        if (!cap.isOpened()) {
	            System.exit(-1);
	        }
	         System.out.println("Prepare to Get frame..");
	        // Matrix for storing image
	                Mat image = new Mat();
	                // Frame for displaying image
	                private JButton btnCapture;
	                cameraScreen = new JLabel(); cameraScreen.setBounds(0, 0, 640, 480);
	                add(cameraScreen);
	                btnCapture = new JButton("capture"); btnCapture.setBounds(300, 480, 80, 40);
	                add(btnCapture);
	                setSize(new Dimension(640, 560)); setLocationRelativeTo(null);
	                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setVisible(true);
	                // Main loop
	                while (true) {
	                    // Read current camera frame into matrix

	                    cap.read(image);  
	                     System.out.println("Geting frame..");
	                        try {
	                            System.out.println("Frame delay waiting..");
	                            Thread.sleep(500);
	                            System.out.println("Delay end..");
	                        } catch(InterruptedException ex) {
	                            Thread.currentThread().interrupt();
	                        }
	                    // Render frame if the camera is still acquiring images
	                    if (image != null) {
	                        frame.render(image);
	                    } else {
	                        System.out.println("No captured frame -- camera disconnected");
	                        break;
	                    }
	                }
 
	}
/*
 * package test;
 * 
 * import java.awt.Dimension; import java.awt.EventQueue;
 * 
 * import javax.swing.JButton; import javax.swing.JFrame; import
 * javax.swing.JLabel;
 * 
 * import org.opencv.core.Core; import org.opencv.core.Mat; import
 * org.opencv.videoio.VideoCapture;
 * 
 * public class Camera2 {
 * 
 * static { System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }
 * 
 * VideoCapture cap; Mat2Image mat2Img = new Mat2Image(); Mat matFilter = new
 * Mat();
 * 
 * public VideoGrabber(){ cap = new VideoCapture();
 * 
 * try { System.out.println("Sleeping...."); Thread.sleep(1000);
 * }catch(InterruptedException e){ e.printStackTrace(); }
 * System.out.println("Camera on..");
 * cap.open("rtsp://admin:intuintu1!@192.168.2.59:554/profile2/media.smp");
 * if(!cap.isOpened()) { System.out.println("Camera Error"); }else {
 * System.out.println("Camera Ok?"); } }
 * 
 * //camera Screen private JLabel cameraScreen;
 * 
 * private JButton btnCapture;
 * 
 * 
 * public Camera() {
 * 
 * //design ui setLayout(null);
 * 
 * cameraScreen = new JLabel(); cameraScreen.setBounds(0, 0, 640, 480);
 * add(cameraScreen);
 * 
 * btnCapture = new JButton("capture"); btnCapture.setBounds(300, 480, 80, 40);
 * add(btnCapture);
 * 
 * 
 * setSize(new Dimension(640, 560)); setLocationRelativeTo(null);
 * setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); setVisible(true); }
 * 
 * public static void main(String[] args) { EventQueue.invokeLater(new
 * Runnable() {
 * 
 * @Override public void run() { Camera camera = new Camera(); } });
 * 
 * } }
 */
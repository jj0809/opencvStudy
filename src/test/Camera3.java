package test;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

public class Camera3 extends JFrame {

	private JLabel label;
	private ImageIcon icon;
	private VideoCapture capture;
	private Mat image;
	private boolean clicked = false, closed = false;
	String RTSP_URL = "rtsp: ";

	public Camera3() {

		setLayout(null);

		label = new JLabel();
		label.setBounds(0, 0, 1300, 900);
		add(label);

		JButton btn = new JButton("capture");
		btn.setBounds(700, 900, 80, 40);
		add(btn);

		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clicked = true;
			}
		});
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosed(e);
				capture.release();
				image.release();
				closed = true;
				System.out.println("closed");
				System.exit(0);

			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				super.windowDeactivated(e);
				System.out.println("closed");
			}

		});

		setFocusable(false);
		setSize(1500, 1000);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				Camera3 camera = new Camera3();

				// start camera in thread
				new Thread(new Runnable() {
					public void run() {
						camera.startCamera();
					}
				}).start();
			}
		});

	}

	public void startCamera() {

		capture = new VideoCapture(RTSP_URL);
		image = new Mat();
		byte[] imageData;

		while (true) {
			// read image to matrix
			capture.read(image);

			// convert matrix to byte
			final MatOfByte buf = new MatOfByte();
			Imgcodecs.imencode(".jpg", image, buf);

			imageData = buf.toArray();

			// add to JLabel
			icon = new ImageIcon(imageData);
			label.setIcon(icon);
			// System.out.println(image.cols());

			// capture and save to file
			if (clicked) {
				
				
				
				System.out.println("clicked");
				// prompt for enter image name
				String name = JOptionPane.showInputDialog("Enter image name");
				if (name == null) {
					name = new SimpleDateFormat("yyyy-mm-dd-hh-mm-ss").format(new Date());
				}
				// write to file
				Imgcodecs.imwrite("images/" + name + ".jpg", image);
				clicked = false;
			}
			if (closed) {
				break;
			}

		}
	}
}

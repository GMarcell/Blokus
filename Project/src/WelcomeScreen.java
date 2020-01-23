import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WelcomeScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelcomeScreen window = new WelcomeScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelcomeScreen() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton NewGamebtn = new JButton("New game");
		NewGamebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		NewGamebtn.setBounds(24, 166, 107, 42);
		frame.getContentPane().add(NewGamebtn);
		
		JButton Helpbtn = new JButton("Help");
		Helpbtn.setBounds(171, 166, 99, 42);
		frame.getContentPane().add(Helpbtn);
		
		JButton Quitbtn = new JButton("Quit");
		Quitbtn.setBounds(314, 166, 99, 42);
		frame.getContentPane().add(Quitbtn);
	}
}

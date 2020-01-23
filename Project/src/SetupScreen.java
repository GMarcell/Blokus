import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class SetupScreen {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupScreen window = new SetupScreen();
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
	public SetupScreen() {
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
		
		JLabel lblNumberOfAi = new JLabel("Number Of AI Player");
		lblNumberOfAi.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNumberOfAi.setBounds(10, 77, 180, 30);
		frame.getContentPane().add(lblNumberOfAi);
		
		JLabel lblNumberOfHuman = new JLabel("Number Of Human Player");
		lblNumberOfHuman.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblNumberOfHuman.setBounds(10, 20, 180, 30);
		frame.getContentPane().add(lblNumberOfHuman);
		
		JComboBox NumberHumanPlayer = new JComboBox();
		NumberHumanPlayer.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		NumberHumanPlayer.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		NumberHumanPlayer.setBounds(261, 26, 67, 22);
		frame.getContentPane().add(NumberHumanPlayer);
		
		JComboBox NumberAiPlayer = new JComboBox();
		NumberAiPlayer.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
		NumberAiPlayer.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		NumberAiPlayer.setBounds(261, 83, 67, 22);
		frame.getContentPane().add(NumberAiPlayer);
	}

}

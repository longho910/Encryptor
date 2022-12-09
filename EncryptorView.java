package Ch8;

import java.io.IOException;

import javax.swing.*;
import java.awt.*;

public class EncryptorView extends JFrame {
	public final boolean verbose = true;
	public JTextField inputFileName = new JTextField(15);
	public JLabel inputFileLabel = new JLabel("Input File ", JLabel.CENTER);
	public JTextField outputFileName = new JTextField(15);
	public JLabel outputFileLabel = new JLabel("Output File ", JLabel.CENTER);
	public JLabel output2FileLabel = new JLabel("Idle ", JLabel.CENTER);
	public JTextField encryptorData = new JTextField("e", 15);
	public JLabel encryptorJLabel = new JLabel("Encryptor Key ", JLabel.RIGHT);
	public JButton openB = new JButton("Read");
	public JButton encryptB = new JButton("Encrypt & Save");
	public JButton clearB = new JButton("Reset");
	protected Color tcuC = new Color(77, 25, 121);
	public JPanel displayPanel = new JPanel(new GridLayout(5, 2, 5, 5));

	public static void main(String args[]) {

		EncryptorView x = new EncryptorView();
		x.wsomething(); // it is not loaded statically remains there until you quit

	}

	public EncryptorView() {
		if (verbose)
			System.out.println("View Constructor"); // display in the console
		setTitle("Symmetric View");
		encryptorJLabel.setForeground(Color.WHITE);
		inputFileLabel.setForeground(Color.WHITE);
		outputFileLabel.setForeground(Color.WHITE);
		displayPanel.setBackground(tcuC);
		displayPanel.add(encryptorJLabel);
		displayPanel.add(encryptorData);
		displayPanel.add(openB);
		displayPanel.add(encryptB);
		displayPanel.add(inputFileLabel);
		displayPanel.add(outputFileLabel);
		displayPanel.add(inputFileName);
		displayPanel.add(outputFileName);
		displayPanel.add(clearB);
		displayPanel.add(output2FileLabel);
		add(displayPanel);
		output2FileLabel.setFont(new Font("Helvetica", Font.ITALIC, 20));
		output2FileLabel.setForeground(Color.WHITE);
		outputFileLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
		inputFileLabel.setFont(new Font("Helvetica", Font.BOLD, 14));
		setBounds(100, 100, 250, 200);
		setVisible(true);
	}

	public static void wsomething() {
		System.out.println("hello  again");
	}

}

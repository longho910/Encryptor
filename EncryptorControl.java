package Ch8;

/**

Basic Symmetric Encryptor
TCU Cosc 20203  Fall 2021

   @author Peter Ho
	@credit modified from Dr. Sanchez's code.


*/
import java.io.*;
import java.awt.*;
import java.awt.event.*;

// for claves use 2222 for cl.txt use -2222

public class EncryptorControl extends EncryptorView implements ActionListener, WindowListener {
	File inputF = null;
	File outputF = null;
	public EncryptorModel crypt;

	public static void main(String args[]) {
		new EncryptorControl();
	}

	public EncryptorControl() {
		super();
		if (verbose)
			System.out.println("Control Constructor"); // display in the console
		// Report the buttons to be listened
		setTitle("Symmetric Control Encryptor");
		openB.addActionListener(this);
		encryptB.addActionListener(this);
		clearB.addActionListener(this);
		this.addWindowListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		String whichButton = e.getActionCommand(); // determines which button generated the event evento
		if (whichButton.equals("Reset"))
			processResetB();
		if (whichButton.equals("Read"))
			getFile(true);
		if (whichButton.equals("Encrypt & Save"))
			processFileEncrypt();
		validate();
		repaint();
		inputFileName.requestFocus(); // pay attention to this textfield

	} // end action performed

	private void processResetB() {
		String stringValue = null;
		inputFileName.setText(stringValue); // display cleared
		outputFileName.setText(stringValue); // display cleared
		encryptorData.setText(stringValue); // display cleared
		output2FileLabel.setText("Idle ");
		if (verbose)
			System.out.println("Both textfields are cleared "); // display in console
	} // end process Reset

	private void processFileEncrypt() {
		output2FileLabel.setText("Working");
		getFile(false);
		try {
			crypt = new EncryptorModel();
			crypt.encryptFile(inputF, outputF, encryptorData.getText());
			// encryptorData.setText("To decode use -KEY");
			output2FileLabel.setText("Idle");

		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	} //

	public File getFile(boolean opt) {
		// Put up a file dialog to allow the user to select an input file

		FileDialog d;
		if (opt)
			d = new FileDialog(this, "Open...", FileDialog.LOAD);
		else
			d = new FileDialog(this, "Save...", FileDialog.SAVE);
		// d.setDirectory(".");
		d.setVisible(true);
		if (d.getFile() != null) {
			if (opt)
				inputFileName.setText(d.getFile());
			else
				outputFileName.setText(d.getFile());
		}
		if (opt) {
			inputF = new File(d.getDirectory(), d.getFile());
			return inputF;
		}
		{
			outputF = new File(d.getDirectory(), d.getFile());
			return outputF;
		}

	}

	/**
	 * Public Methods
	 * Used to control the windows
	 **/
	public void windowClosing(WindowEvent e) {
		dispose();
		System.exit(0);
	}

	public void windowOpened(WindowEvent e) {
	}

	public void windowIconified(WindowEvent e) {
	}

	public void windowClosed(WindowEvent e) {
	}

	public void windowDeiconified(WindowEvent e) {
	}

	public void windowActivated(WindowEvent e) {
	}

	public void windowDeactivated(WindowEvent e) {
	}

}

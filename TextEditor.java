import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.*;

public class TextEditor implements ActionListener {

	public static void main(String[] args) throws FileNotFoundException {

		TextEditor TE1 = new TextEditor();

	}

	private JFrame frame;
	private JTextField textCapturePanel;
	private JButton submitButton;
	private String notepadText = "";
	JTextArea notepadArea;

	JMenuBar menuBar;
	JMenu menu, submenu;
	JMenuItem saveButton, clearButton, openButton;
	JRadioButtonMenuItem rbMenuItem;
	JCheckBoxMenuItem cbMenuItem;

	public TextEditor() throws FileNotFoundException {
		// Build frame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(410, 550));
		frame.setTitle("SimpleTextEditor v1.0");
		frame.setLayout(new BorderLayout());

		// Build menu.
		menuBar = new JMenuBar();

		// Build the first menu.
		menu = new JMenu("Menu");
		menu.setMnemonic(KeyEvent.VK_A);
		menu.getAccessibleContext().setAccessibleDescription(
				"The only menu in this program that has menu items");
		menuBar.add(menu);

		openButton = new JMenuItem("Open", KeyEvent.VK_T);
		openButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
				ActionEvent.ALT_MASK));
		openButton.getAccessibleContext().setAccessibleDescription(
				"This doesn't really do anything");
		menu.add(openButton);

		openButton.addActionListener(this);

		// a group of JMenuItems
		saveButton = new JMenuItem("Save", KeyEvent.VK_T);
		saveButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
				ActionEvent.ALT_MASK));
		saveButton.getAccessibleContext().setAccessibleDescription(
				"This doesn't really do anything");
		menu.add(saveButton);

		saveButton.addActionListener(this);

		clearButton = new JMenuItem("Clear", KeyEvent.VK_T);
		clearButton.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
				ActionEvent.ALT_MASK));
		clearButton.getAccessibleContext().setAccessibleDescription(
				"This doesn't really do anything");
		menu.add(clearButton);

		clearButton.addActionListener(this);

		frame.setJMenuBar(menuBar);

		// Build bottom GUI area.
		JPanel textArea = new JPanel(new BorderLayout());
		textCapturePanel = new JTextField("Type your text here.");
		textArea.add(textCapturePanel, BorderLayout.CENTER);

		textCapturePanel.addActionListener(this);

		submitButton = new JButton("Submit");
		submitButton.addActionListener(this);
		textArea.add(submitButton, BorderLayout.EAST);

		// Add bottom gui area to frame.
		frame.add(textArea, BorderLayout.SOUTH);

		// Build main text area.
		notepadArea = new JTextArea(notepadText);
		notepadArea.setWrapStyleWord(true);

		// Add the main text area to frame.
		frame.add(new JScrollPane(notepadArea), BorderLayout.CENTER);

		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == saveButton) {

			// save feature:
			PrintStream output = null;
			try {
				output = new PrintStream(new File("Hello.txt"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			output.println(notepadArea.getText());

		} else if (event.getSource() == clearButton) {
			notepadArea.setText("");
		} else if (event.getSource() == openButton) {
			textCapturePanel.setText("Not implemented yet!");
		} else {

			String text = textCapturePanel.getText();

			// http://stackoverflow.com/questions/8345023/need-to-get-current-timestamp-in-java
			Date date = new Date();

			SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");

			String formattedDate = sdf.format(date);

			notepadArea.setText(notepadArea.getText() + text + " [ "
					+ formattedDate + " ] " + "\n");
			textCapturePanel.setText(null);
		}
	}

}

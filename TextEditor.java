
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TextEditor implements ActionListener {

	public static void main(String[] args) {
		
		TextEditor TE1 = new TextEditor();

	}

	private JFrame frame;
	private JTextField captureString;
	private JButton submit;
	private String sampleText = "";
	JTextArea typed;
	
	public TextEditor() {
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(410,550));
		frame.setTitle("SimpleTextEditor v1.0");
		
		JPanel textArea = new JPanel(new BorderLayout());
		captureString = new JTextField("test");
		textArea.add(captureString, BorderLayout.CENTER);
		submit = new JButton("Submit");
		submit.addActionListener(this);
		textArea.add(submit, BorderLayout.EAST);
		
		frame.setLayout(new BorderLayout());
		frame.add(textArea, BorderLayout.SOUTH);
		
		typed = new JTextArea(sampleText);
		typed.setWrapStyleWord(true);
		frame.add(new JScrollPane(typed), BorderLayout.CENTER);
		
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		
		String text = captureString.getText();
		typed.setText(typed.getText() + "\n" + text);
		//TextEditor();
		
	}

}

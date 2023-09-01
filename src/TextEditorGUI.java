import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;

public class TextEditorGUI {
	
	private JFrame frame;
	private JTextArea textArea;
	private FileHandler fileHandler;
	
	public TextEditorGUI() {
		frame = new JFrame("Simple Text Editor");
		textArea = new JTextArea();
		fileHandler = new FileHandler();
		
		setupMenuBar();
		setupTextArea();
		setupFrame();
	}
	
	private void setupMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");
		JMenuItem saveItem = new JMenuItem("Save");
		saveItem.addActionListener(e -> fileHandler.saveFile(textArea.getText()));
		fileMenu.add(saveItem);
		
		JMenu formatMenu = new JMenu("Format");
		JMenuItem boldItem = new JMenuItem("Bold");
		boldItem.addActionListener(e -> textArea.setFont(textArea.getFont().deriveFont(Font.BOLD)));
		JMenuItem plainItem = new JMenuItem("Plain");
		plainItem.addActionListener(e -> textArea.setFont(textArea.getFont().deriveFont(Font.PLAIN)));
		formatMenu.add(boldItem);
		formatMenu.add(plainItem);
		
		menuBar.add(fileMenu);
		menuBar.add(formatMenu);
		frame.setJMenuBar(menuBar);
	}
	
	private void setupTextArea() {
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(textArea);
		frame.add(scrollPane, BorderLayout.CENTER);
	}
	
	private void setupFrame() {
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

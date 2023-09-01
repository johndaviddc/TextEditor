import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;

public class FileHandler {
	
	public void saveFile(String content) {
		JFileChooser fileChooser = new JFileChooser();
		if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try (FileWriter fileWriter = new FileWriter(file)) {
				fileWriter.write(content);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}

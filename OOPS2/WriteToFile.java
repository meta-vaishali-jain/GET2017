import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
/**
 * ClassName WriteToFile
 * @author Vaishali Jain
 * Description To write in file
 */
public class WriteToFile {
	//write text in file
		public static void write(String text, String filePath) {
			try {

				BufferedWriter bw = new BufferedWriter(new FileWriter(new File(
						filePath), true));
				if (text.equals("-1")) {
					bw.newLine();
				} else {
					bw.write(text);
				}
				bw.close();
			} catch (Exception e) {
			}
		}
}

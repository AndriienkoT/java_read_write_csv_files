import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

/**
 * Created by user on 05/01/2017.
 */

public class WorkInFile {

    private static String fileNameToRead = "C://Users/user/Desktop/DataManagement Task/products.csv";
    private static String fileNameToWrite = "C://Users/user/Desktop/DataManagement Task/my_result.csv";

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        //Read the file
        String textFromFile = FileWorker.read(fileNameToRead);
        String changedText = new String(textFromFile.getBytes("UTF-8"), "ISO-8859-1");
        changedText = changedText.replace(";", "|");
        changedText = changedText.replace("\"", "'");

        //Write into the file
        FileWorker.write(fileNameToWrite, changedText);

    }
}

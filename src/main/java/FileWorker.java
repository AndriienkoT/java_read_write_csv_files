import java.io.*;

/**
 * Created by user on 05/01/2017.
 */

public class FileWorker {

    private static void exists(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        if (!file.exists()){
            throw new FileNotFoundException(file.getName());
        }
    }

    public static String read(String fileName) throws FileNotFoundException {
        //The object for string building
        StringBuilder sb = new StringBuilder();

        File file = new File(fileName);
        exists(fileName);

        try {
            //The object for reading the file
            BufferedReader in = new BufferedReader(new FileReader(file.getAbsoluteFile()));
            try {
                //Read the file line by line
                String s;
                while ((s = in.readLine()) != null) {
                    sb.append(s);
                    sb.append("\n");
                }
            } finally {
                //Close the file
                in.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }

        //Return the text from the file
        return sb.toString();
    }

    public static void write(String fileName, String text) {
        //Define the file
        File file = new File(fileName);

        try {
            //If the file is not exist, create it
            if(!file.exists()){
                file.createNewFile();
            }

            //PrintWriter provides the ability to record in the file
            PrintWriter out = new PrintWriter(file.getAbsoluteFile());

            try {
                //Write text into the file
                out.print(text);
            } finally {
                //Close the file
                out.close();
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}

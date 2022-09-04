import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ExtractorReader {

    public static Scanner GetFileRead(String filePath) throws FileNotFoundException{
        return new Scanner(new FileReader(filePath)).useDelimiter("\\n");
    }
}

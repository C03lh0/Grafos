import java.io.FileReader;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {

        Scanner fileRead = ExtractorReader.GetFileRead("pequenoG.txt");
        Graphs myGraph = new Graphs(fileRead);
        myGraph.ShowAllGraphInformation();
    }
}

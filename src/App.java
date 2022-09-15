import java.io.FileReader;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {

        GraphsFactory graphsFactory = new GraphsFactory("pequenoG.txt");
        Graphs myGraphs = graphsFactory.getGraphs();
    }
}

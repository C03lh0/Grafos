import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class GraphAssembler {

    private int graphsOrder;
    private int graphsLength;
    private Scanner readFile;
    private int [][] adjacencyMatrix;

    public GraphAssembler(String filePath) throws FileNotFoundException{
        try{
            this.readFile = new Scanner(new FileReader(filePath)).useDelimiter("\\n");
        }catch (FileNotFoundException e){
            System.out.println("Status: " + e.getMessage());
        }

        InitializeGraph();
    }

    private void InitializeGraph() {
        this.StartGraphMatrix();
        this.FillGraphMatrix();
    }

    private void StartGraphMatrix() {
        int vertices = Integer.parseInt(this.readFile.nextLine());
        int edges = Integer.parseInt(this.readFile.nextLine());
        this.adjacencyMatrix = new int [vertices][vertices];

        this.graphsOrder = vertices;
        this.graphsLength = edges;
    }

    private void FillGraphMatrix() {

        while(this.readFile.hasNextLine()) {
            String receivedElements = this.readFile.nextLine();
            String [] vetor = receivedElements.split(" ");
            int outputVertex = Integer.parseInt(vetor[0]);
            int inputVertex = Integer.parseInt(vetor[1]);
            adjacencyMatrix[outputVertex][inputVertex] = 1;
        }
    }
}

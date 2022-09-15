import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GraphsFactory {

    private int graphsOrder;
    private int graphsLength;
    private Scanner readFile;
    List<Vertices> verticesList;
    private int [][] adjacencyMatrix;

    public GraphsFactory(String filePath) throws FileNotFoundException{
        try{
            this.readFile = new Scanner(new FileReader(filePath)).useDelimiter("\\n");
        }catch (FileNotFoundException e){
            System.out.println("Status: File not found -> " + e.getMessage());
        }

        this.verticesList = new ArrayList<Vertices>();
        this.StartGraphMatrix();
    }

    private void StartGraphMatrix() {
        int vertices = Integer.parseInt(this.readFile.nextLine());
        int edges = Integer.parseInt(this.readFile.nextLine());
        this.adjacencyMatrix = new int [vertices][vertices];

        this.graphsOrder = vertices;
        this.graphsLength = edges;

        this.FillGraphMatrix();
    }

    private void FillGraphMatrix() {

        while(this.readFile.hasNextLine()) {
            String receivedElements = this.readFile.nextLine();
            String [] vetor = receivedElements.split(" ");
            int outputVertex = Integer.parseInt(vetor[0]);
            int inputVertex = Integer.parseInt(vetor[1]);
            adjacencyMatrix[outputVertex][inputVertex] = 1;
        }
        this.FillVerticesList();
    }

    private void FillVerticesList() {

        for(int i = 0; i < this.adjacencyMatrix.length; i++){
            Vertices vertex = new Vertices(Integer.toString(i), i);
            verticesList.add(vertex);
        }
        this.FillNeighboringVertices();
    }

    private void FillNeighboringVertices() {
        for(int i = 0; i < this.adjacencyMatrix.length; i++){
            Vertices vertex = this.verticesList.get(i);
            
            for(int j = 0; j < this.adjacencyMatrix[0].length; j++){

                String verticeName = Integer.toString(j);
                int neighboringVertexValue = this.adjacencyMatrix[i][j];

                if(neighboringVertexValue == 1){
                    Vertices matrixVertex = new Vertices(verticeName, neighboringVertexValue);
                    matrixVertex.setOutputVertex(false);
                    vertex.getNeighboringVertices().add(this.verticesList.get(j));
                }

                verticeName = Integer.toString(j);
                neighboringVertexValue = this.adjacencyMatrix[j][i];

                if(neighboringVertexValue == 1){
                    Vertices matrixVertex = new Vertices(verticeName, neighboringVertexValue);
                    matrixVertex.setOutputVertex(true);
                    vertex.getNeighboringVertices().add(this.verticesList.get(j));
                }
            }
        }
    }

    public Graphs getGraphs(){
        return new Graphs(this.graphsOrder, this.graphsLength, this.verticesList);
    }
}

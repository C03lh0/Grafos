import java.util.Scanner;

public class Graphs {
    
    private int graphsOrder;
    private int graphsLength;
    private int [] [] adjacencyMatrix;
    private Scanner fileGraphsElement;

    public Graphs (Scanner fileGraphsElement){
        this.fileGraphsElement = fileGraphsElement;
        this.InitializeGraph();
    }

    private void InitializeGraph() {
        this.StartGraphMatrix();
        this.FillGraphMatrix();
    }
    private void StartGraphMatrix() {
        int vertices = Integer.parseInt(fileGraphsElement.nextLine());
        int edges = Integer.parseInt(fileGraphsElement.nextLine());
        this.adjacencyMatrix = new int [vertices][vertices];

        this.graphsOrder = vertices;
        this.graphsLength = edges;
    }

    private void FillGraphMatrix() {

        while(this.fileGraphsElement.hasNextLine()) {
            String receivedElements = this.fileGraphsElement.nextLine();
            String [] vetor = receivedElements.split(" ");
            int outputVertex = Integer.parseInt(vetor[0]);
            int inputVertex = Integer.parseInt(vetor[1]);
            adjacencyMatrix[outputVertex][inputVertex] = 1;
        }
        this.ShowMatrix();
    }

    private void ShowMatrix(){
        for(int i = 0; i < adjacencyMatrix.length; i++){
            System.out.print("(" + i + ")" + " ");

            for(int j = 0; j < adjacencyMatrix[0].length; j++){
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void ShowAllGraphInformation(){
        int countIsolatedVertices = 0;
        for(int i = 0; i < adjacencyMatrix.length; i++){
            int inputDegree = 0;
            boolean isIsolatedVertice = true;
            for(int j = 0; j < adjacencyMatrix[0].length; j++){
                if(adjacencyMatrix[j][i] == 1){
                    inputDegree ++;
                    isIsolatedVertice = false;
                }
                if(adjacencyMatrix[i][j] == 1){
                    isIsolatedVertice = false;
                }
            }

            countIsolatedVertices = isIsolatedVertice == true ? countIsolatedVertices + 1 : countIsolatedVertices;

            System.out.println("Grau de entrada do vértice " + i + " = " + inputDegree);
        }
        System.out.println();
        System.out.println("Ordem do Grafo" + " = " + this.graphsOrder);
        System.out.println("Tamanho do Grafo" + " = " + this.graphsLength);
        System.out.println("Total de vértices isolados" + " = " + countIsolatedVertices);
        System.out.println("Não existe grau de extermidade para grafo direcionado.");
    }
}

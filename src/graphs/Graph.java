package graphs;
import java.util.List;

public class Graph implements IGraphs {
    
    private int graphsOrder;
    private int graphsLength;
    protected List<Vertices> verticesList;

    public Graph (int graphsOrder, int graphsLength, List<Vertices> verticesList){
        this.graphsOrder = graphsOrder;
        this.graphsLength = graphsLength;
        this.verticesList = verticesList;
    }


    public int getGraphsOrder() {
        return graphsOrder;
    }


    public int getGraphsLength() {
        return graphsLength;
    }

    public void printDegreeOfEachVertex(){
        
        if(this.verticesList.isEmpty()){
            System.out.println("Não há vétices. Grafo Vazio!");
        } else {
            for (Vertices vertice : verticesList) {
                int inputDegree = vertice.getPredecessorVertex().size();
                System.out.println("Grau de entrada do Vétice " + vertice.toString() + " = " + inputDegree);
            }
        }
    }

    public int getNumberOfIsolatedVertices(){
        int count = 0;

        for (Vertices vertice : verticesList) {
            if(vertice.getSuccessorVertex().isEmpty() && vertice.getPredecessorVertex().isEmpty()){
                count++;
            }
        }
        return count;
    }
}

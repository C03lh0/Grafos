package searchGraph;
import java.util.List;

import graphs.Vertices;
import graphs.Graph;
import graphs.EnumColors;

public class GraphDepthSearch extends Graph {

    private Vertices sourceVertex;
    private Integer timer;

    public GraphDepthSearch(int graphsOrder, int graphsLength, List<Vertices> verticesList, Integer sourceVertexIndex) {
        super(graphsOrder, graphsLength, verticesList);
        try{
            this.sourceVertex = this.verticesList.get(sourceVertexIndex);
        }catch (Exception ex){
            System.out.println("Esse vértice não existe" + ex.getMessage());
        }
        this.timer = -1;
    }

    public void start() {
        Vertices currentVertex = this.sourceVertex;
        List<Vertices> neighboringVerticeSource = currentVertex.getAllAdjacents();

        for (Vertices vertex : neighboringVerticeSource) {
            vertex.setInicialTimer(this.timer);
            vertex.setFinalTimer(this.timer);
        }
        this.timer = 1;
        dfsVisit(currentVertex, neighboringVerticeSource);
    }

    private void dfsVisit(Vertices currentVertex, List<Vertices> listSuccessorsCurrentVertex) {
        this.timer++;
        currentVertex.setColor(EnumColors.Gray);
        currentVertex.setInicialTimer(this.timer);
        printPath(currentVertex);

        for (Vertices vertex : listSuccessorsCurrentVertex) {
            if(vertex.getColor() == EnumColors.White){
                if(!vertex.getPredecessorVertex().contains(currentVertex)){
                    vertex.getPredecessorVertex().add(currentVertex);
                }
                dfsVisit(vertex, vertex.getAllAdjacents());
            }
        }

        this.timer++;
        currentVertex.setColor(EnumColors.Black);
        currentVertex.setFinalTimer(this.timer);
    }

    private void printPath(Vertices currentVertice) {
        System.out.print(" -> " + currentVertice.toString());
    }    
}

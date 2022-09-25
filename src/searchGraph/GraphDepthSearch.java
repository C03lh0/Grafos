package searchGraph;

import java.util.LinkedList;
import java.util.List;

import graphs.Vertices;
import graphs.Graph;
import graphs.EnumColors;

public class GraphDepthSearch extends Graph implements ISearch  {

    private Vertices sourceVertex;
    private Integer timer;

    public GraphDepthSearch(int graphsOrder, int graphsLength, List<Vertices> verticesList, Integer sourceVertexIndex) {
        super(graphsOrder, graphsLength, verticesList);
        this.sourceVertex = this.verticesList.get(sourceVertexIndex);
        this.timer = -1;
        this.start();
    }

    @Override
    public void start() {
        Vertices currentVertex = this.sourceVertex;
        List<Vertices> neighboringVerticeSource = currentVertex.getSuccessorVertex();

        for (Vertices vertex : neighboringVerticeSource) {
            vertex.setInicialTimer(this.timer);
            vertex.setFinalTimer(this.timer);
        }
        this.timer = 1;
        dfsVisit(currentVertex);
    }

    private void dfsVisit(Vertices currentVertex) {
        List<Vertices> listSuccessorsCurrentVertex = currentVertex.getSuccessorVertex();

        this.timer++;
        currentVertex.setColor(EnumColors.Gray);
        currentVertex.setInicialTimer(this.timer);

        for (Vertices vertex : listSuccessorsCurrentVertex) {
            if(vertex.getColor() == EnumColors.White){
                if(!vertex.getPredecessorVertex().contains(currentVertex)){
                    vertex.getPredecessorVertex().add(currentVertex);
                }
                dfsVisit(vertex);
            }
        }

        this.timer++;
        currentVertex.setColor(EnumColors.Black);
        currentVertex.setFinalTimer(this.timer);
    }

    public void checkAndPrintPath(Integer target){
        try{
            Vertices targetVertice = this.verticesList.get(target);
            printPath(targetVertice);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private void printPath(Vertices currentVertice) throws Exception{

        if(this.sourceVertex.equals(currentVertice))
            System.out.print(+ this.sourceVertex.getValue());
        else{
            if(currentVertice.getVertexWithShortestDistance() == null){
                throw new Exception("Ops...! Não há caminho para este vértice");
            }else{
                this.printPath(currentVertice.getVertexWithShortestDistance());
                System.out.print(" -> " + currentVertice.toString());
            }
        }
    }
}

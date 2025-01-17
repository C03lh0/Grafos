package searchGraph;

import java.util.LinkedList;
import java.util.List;

import graphs.Vertices;
import graphs.Graph;
import graphs.EnumColors;

public class GraphBreadthSearch extends Graph implements ISearch {

    private Vertices sourceVertex;

    public GraphBreadthSearch(int graphsOrder, int graphsLength, List<Vertices> verticesList, Integer sourceVertexIndex) {
        super(graphsOrder, graphsLength, verticesList);
        this.sourceVertex = this.verticesList.get(sourceVertexIndex);
        this.start();
    }

    @Override
    public void start() {
        Vertices currentVertex;
        List<Vertices> neighboringVerticeSource ;
        LinkedList<Vertices> queueVertices = new LinkedList<Vertices>();

        currentVertex = this.sourceVertex;
        currentVertex.setColor(EnumColors.Gray);
        queueVertices.add(currentVertex);

        while (!queueVertices.isEmpty()) {
            currentVertex = queueVertices.pop();
            neighboringVerticeSource = currentVertex.getSuccessorVertex();

            for (Vertices vertice : neighboringVerticeSource) {
                if(vertice.getColor() == EnumColors.White){
                    vertice.setColor(EnumColors.Gray);
                    vertice.setDistance(currentVertex.getDistance() + 1);

                    if(!vertice.getPredecessorVertex().contains(currentVertex)){
                        vertice.getPredecessorVertex().add(currentVertex);
                    }
                    queueVertices.add(vertice);
                }
            }
            currentVertex.setColor(EnumColors.Black);
        }
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

package searchGraph;

import java.util.LinkedList;
import java.util.List;

import graphs.EnumColors;
import graphs.Graph;
import graphs.Vertices;

public class GraphBreadthSearch extends Graph implements ISearch {

    private Vertices sourceVertex;

    public GraphBreadthSearch(int graphsOrder, int graphsLength, List<Vertices> verticesList, Integer sourceVertexIndex) {
        super(graphsOrder, graphsLength, verticesList);
        this.sourceVertex = this.verticesList.get(sourceVertexIndex);
        this.search();
    }

    @Override
    public void search() {
        Vertices currentVertex;
        List<Vertices> neighboringVerticeSource ;
        LinkedList<Vertices> queueVertices = new LinkedList<Vertices>();

        currentVertex = this.sourceVertex;
        currentVertex.setColor(EnumColors.Gray);
        queueVertices.add(currentVertex);

        while (!queueVertices.isEmpty()) {
            currentVertex = queueVertices.pop();
            neighboringVerticeSource = currentVertex.getAllNeighbors();

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

    public void printPath(Integer target){
        Vertices targetVertice = this.verticesList.get(target);
        List<Vertices> neighboringVerticeSource = targetVertice.getAllNeighbors() ;

        if(this.sourceVertex.equals(targetVertice))
            System.out.print(+ this.sourceVertex.getValue());
        else{
            if(neighboringVerticeSource.isEmpty()){
                System.out.println("Não há caminho");
            }else{
                Vertices vertexWithShortestDistance = neighboringVerticeSource.get(0);
                for (Vertices vertice : neighboringVerticeSource) {
                    
                    if(vertice.getDistance() < vertexWithShortestDistance.getDistance()){
                        vertexWithShortestDistance = vertice;
                    }
                }
                this.printPath(vertexWithShortestDistance.getValue());
                System.out.print(" -> " + targetVertice.toString());
            }
        }
    }
}

package graphs;
import java.util.ArrayList;
import java.util.List;

public class Vertices {
    private String name;
    private Integer value;
    private EnumColors color;
    private Integer distance;
    private Integer inicialTimer;
    private Integer finalTimer;
    private List<Vertices> successorVertex;
    private List<Vertices> predecessorVertex;

    public Vertices(String name, int value){
        this.name = name;
        this.value = value;
        this.distance = 0;
        this.color = EnumColors.White;
        this.successorVertex = new ArrayList<Vertices>();
        this.predecessorVertex = new ArrayList<Vertices>();
    }

    public boolean addSuccessorVertex(Vertices inputVertex){
        return this.successorVertex.add(inputVertex);
    }

    public List<Vertices> getSuccessorVertex() {
        return successorVertex;
    }

    public boolean addPredecessorVertex(Vertices outputVerticex) {
        return this.predecessorVertex.add(outputVerticex);
    }

    public List<Vertices> getPredecessorVertex() {
        return predecessorVertex;
    }

    public String getName() {
        return name;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public EnumColors getColor() {
        return color;
    }

    public void setColor(EnumColors color) {
        this.color = color;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Integer getInicialTimer() {
        return inicialTimer;
    }

    public void setInicialTimer(Integer inicialTimer) {
        this.inicialTimer = inicialTimer;
    }

    public Integer getFinalTimer() {
        return finalTimer;
    }

    public void setFinalTimer(Integer finalTimer) {
        this.finalTimer = finalTimer;
    }

    public Vertices getVertexWithShortestDistance(){

        if(!this.predecessorVertex.isEmpty()){
            Vertices vertexWithShortestDistance = this.predecessorVertex.get(0);
            for (Vertices vertice : this.predecessorVertex) {
                    
                if(vertice.getDistance() < vertexWithShortestDistance.getDistance()){
                    vertexWithShortestDistance = vertice;
                }
            }   
            return vertexWithShortestDistance;
        }
        return null;
    }

    @Override
    public String toString(){
        return this.getName();
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Vertices){
            Vertices vertex = (Vertices) obj;
            return this.getValue().equals(vertex.getValue());
        }
        return false;
    }
}
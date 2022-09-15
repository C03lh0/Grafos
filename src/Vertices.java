import java.util.ArrayList;
import java.util.List;

public class Vertices {
    private String name;
    private Integer value;
    private EnumColors color;
    private boolean outputVertex;
    private List<Vertices> neighboringVertices;

    public Vertices(String name, int value){
        this.name = name;
        this.value = value;
        this.outputVertex = true;
        this.color = EnumColors.White;
        this.neighboringVertices = new ArrayList<Vertices>();
    }

    public boolean addNewNeighboring(Vertices vertex){
        return this.neighboringVertices.add(vertex);
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

    public List<Vertices> getNeighboringVertices() {
        return neighboringVertices;
    }

    public boolean isOutputVertex() {
        return outputVertex;
    }

    public void setOutputVertex(boolean outputVertex) {
        this.outputVertex = outputVertex;
    }

    public EnumColors getColor() {
        return color;
    }

    public void setColor(EnumColors color) {
        this.color = color;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Vertices {
    private String name;
    private Integer value;
    private List<Vertices> neighboringVertices;

    public Vertices(String name, Integer value){
        this.name = name;
        this.value = value;
        this.neighboringVertices = new ArrayList<Vertices>();
    }

    public boolean addNewNeighboring(Vertices vertex){
        return this.neighboringVertices.add(vertex);
    }

    public String getName() {
        return name;
    }


    public Integer getValue() {
        return value;
    }

    public List<Vertices> getNeighboringVertices() {
        return neighboringVertices;
    }
}

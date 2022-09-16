import java.util.ArrayList;
import java.util.List;

public class Vertices {
    private String name;
    private Integer value;
    private EnumColors color;
    private List<Vertices> pointsToVertices;
    private List<Vertices> pointedByVertices;

    public Vertices(String name, int value){
        this.name = name;
        this.value = value;
        this.color = EnumColors.White;
        this.pointsToVertices = new ArrayList<Vertices>();
        this.pointedByVertices = new ArrayList<Vertices>();
    }

    public boolean addInputVertice(Vertices inputVertex){
        return this.pointsToVertices.add(inputVertex);
    }

    public List<Vertices> getInputVertice() {
        return pointsToVertices;
    }

    public boolean addOutputVertice(Vertices outputVerticex) {
        return this.pointedByVertices.add(outputVerticex);
    }

    public List<Vertices> getOutputVertices() {
        return pointedByVertices;
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
}

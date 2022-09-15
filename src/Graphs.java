import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Graphs {
    
    private int graphsOrder;
    private int graphsLength;
    private List<Vertices> verticesList;

    public Graphs (int graphsOrder, int graphsLength, List<Vertices> verticesList){
        this.graphsOrder = graphsOrder;
        this.graphsLength = graphsLength;
        this.verticesList = verticesList;
    }


    public void ShowAllGraphInformation(){
        System.out.println();
        System.out.println("Ordem do Grafo" + " = " + this.graphsOrder);
        System.out.println("Tamanho do Grafo" + " = " + this.graphsLength);
        System.out.println("Total de vértices isolados" + " = ");
        System.out.println("Não existe grau de extermidade para grafo direcionado.");
    }
}

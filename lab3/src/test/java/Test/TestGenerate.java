package Test;

import generate.Generate;
import model.Graph;

public class TestGenerate {
    public static void main(String[] args){
        Graph graph= Generate.generateGraph(6);
        System.out.print(graph.toString());

    }
}
 
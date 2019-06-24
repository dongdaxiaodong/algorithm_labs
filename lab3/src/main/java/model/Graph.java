package model;

import java.util.LinkedList;

public class Graph {
    private int verticeNums;
    private int pathNums;
    private LinkedList<VerticePath> graphPaths;

    public Graph(){};

    public Graph(int verticeNums, int pathNums, LinkedList<VerticePath> graphPaths) {
        this.verticeNums = verticeNums;
        this.pathNums = pathNums;
        this.graphPaths = graphPaths;
    }

    public int getVerticeNums() {
        return verticeNums;
    }

    public void setVerticeNums(int verticeNums) {
        this.verticeNums = verticeNums;
    }

    public int getPathNums() {
        return pathNums;
    }

    public void setPathNums(int pathNums) {
        this.pathNums = pathNums;
    }

    public LinkedList<VerticePath> getGraphPaths() {
        return graphPaths;
    }

    public void setGraphPaths(LinkedList<VerticePath> graphPaths) {
        this.graphPaths = graphPaths;
    }

    public String toString(){
        StringBuffer stringBuffer=new StringBuffer();
        for(VerticePath verticePath:graphPaths){
            stringBuffer.append(verticePath.getPoint().getName()).append("\n");
            for(Path path:verticePath.getPaths()){
                stringBuffer.append(path.getStartVertice().getName()+" and "+path.getEndVertice().getName()+" by "+path.getWeight()+"\t");
            }
            stringBuffer.append("\n\n");
        }
        return stringBuffer.toString();
    }
}

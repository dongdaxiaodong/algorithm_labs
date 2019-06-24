package model;

import java.util.LinkedList;

public class VerticePath {
    private int id;
    private Vertice point;
    private LinkedList<Path> paths=new LinkedList<>();
    private int pathWeight;

    public VerticePath(){};

    public VerticePath(LinkedList<Path> paths){
        this.point=paths.get(0).getStartVertice();
        this.paths=paths;
    }

    public int getPathWeight() {
        return pathWeight;
    }

    public void setPathWeight(int pathWeight) {
        this.pathWeight = pathWeight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vertice getPoint() {
        return point;
    }

    public void setPoint(Vertice point) {
        this.point = point;
    }

    public LinkedList<Path> getPaths() {
        return paths;
    }

    public void setPaths(LinkedList<Path> paths) {
        this.paths = paths;
    }
}
 
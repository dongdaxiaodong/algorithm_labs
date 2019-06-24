package model;

import util.Random;

public class Path {
    private int id;
    private Vertice startVertice;
    private Vertice endVertice;
    private int weight;

    public Path(){};

    public Path(Vertice startVertice,Vertice endVertice){
        this.startVertice=startVertice;
        this.endVertice=endVertice;
        this.weight= Random.randomPathWeight();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vertice getStartVertice() {
        return startVertice;
    }

    public void setStartVertice(Vertice startVertice) {
        this.startVertice = startVertice;
    }

    public Vertice getEndVertice() {
        return endVertice;
    }

    public void setEndVertice(Vertice endVertice) {
        this.endVertice = endVertice;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
 
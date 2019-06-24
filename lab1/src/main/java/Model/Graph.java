package Model;

import java.util.LinkedList;

public class Graph {
    private LinkedList<City> citys=new LinkedList<>();
    private LinkedList<String> paths=new LinkedList<>();
    private int size=0;
    private int cost=0;
    public Graph(){};

    public LinkedList<City> getCitys() {
        return citys;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setCitys(LinkedList<City> citys) {
        this.citys = citys;
    }

    public LinkedList<String> getPaths() {
        return paths;
    }

    public void setPaths(LinkedList<String> paths) {
        this.paths = paths;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}

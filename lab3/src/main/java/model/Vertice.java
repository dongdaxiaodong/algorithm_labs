package model;

public class Vertice {
    private int id;
    private String name;
    private String des;

    public Vertice(){};

    public Vertice(int id,String name){
        this.id=id;
        this.name=name;
    }

    public Vertice(String name){
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }
}
 
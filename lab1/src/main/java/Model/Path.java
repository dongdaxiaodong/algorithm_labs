package Model;

public class Path {

    private int id;
    private City startCity;
    private City endCity;
    private int cost;

    public Path(){};

    public Path(City startCity,City endCity,int cost){
        this.startCity=startCity;
        this.endCity=endCity;
        this.cost=cost;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public City getStartCity() {
        return startCity;
    }

    public void setStartCity(City startCity) {
        this.startCity = startCity;
    }

    public City getEndCity() {
        return endCity;
    }

    public void setEndCity(City endCity) {
        this.endCity = endCity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}

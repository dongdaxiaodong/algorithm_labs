package generate;
/*
* generate random sets
* city sets and path sets
* */


import Model.City;
import Model.Path;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Generate {
    private static String[] allCitys={"London","Paris","Lyon","Nice","Berlin","Munich","Hamburg","Hanover","Cambridge","Bern"};
    private LinkedList<City> citys=new LinkedList<City>();
    private LinkedList<Path> paths=new LinkedList<Path>();
    private static int nodePathTimes=2;
    private int num;
    private static int maxCount=100;
    public Generate(int num){
        this.num=num;
        this.generateAlgorithm(num);
    }

    public void generateAlgorithm(int num){
        //使用一个内部字典进行path的构造
        this.generateCitys(num);
        this.generatePaths();
    }
    public void generateCitys(int num){
        while (citys.size()<num){
            int selectIndex=(int)(Math.random()*allCitys.length);
            City selectedCity=new City(allCitys[selectIndex]);
            if(citys.stream().
                    filter(city->
                            city.getName().
                                    equals(selectedCity.getName())).count()==0){
                citys.add(selectedCity);
            }
        }
    }
    public void generatePaths(){
        for(int i=0;i<citys.size();i+=1){
            City frontCity=citys.get(i);
            City backCity=(i==citys.size()-1)?citys.get(0):citys.get(i+1);
            paths.add(new Path(frontCity,backCity,(int)(maxCount*Math.random())));
        }
        if(num>=4){
            int morePath=num/4+num-4;
            while (morePath>0){
                City start=citys.get((int)(Math.random()*citys.size()));
                City end=citys.get((int)(Math.random()*citys.size()));
                if(checkInPath(start,end)){
                    morePath-=1;
                    paths.add(new Path(start,end,(int)(Math.random()*maxCount)));
                }
            }
        }
        List<Path> copyPath= paths.stream().map(path -> new Path(path.getEndCity(),path.getStartCity(),path.getCost())).collect(Collectors.toList());
        copyPath.stream().forEach(path ->paths.add(path));
    }
    public  boolean checkInPath(City start,City end){
        boolean check=false;
        long coun1=paths.stream().filter(path ->
                path.getStartCity().getName().equals(start.getName())
        && path.getEndCity().getName().equals(end.getName())).count();
        long coun2=paths.stream().filter(path ->
                path.getEndCity().getName().equals(start.getName())
        && path.getStartCity().getName().equals(end.getName())).count();
        if(coun1+coun2==0){
            check=true;
        }
        return check;
    }
    public void tostring(){
        citys.stream().forEach(city -> System.out.println());
        System.out.println("-----------path-------------");
        paths.stream().forEach(path -> System.out.println(path.getStartCity().getName()+" and "+path.getEndCity().getName()));
    }

    public static String[] getAllCitys() {
        return allCitys;
    }

    public static void setAllCitys(String[] allCitys) {
        Generate.allCitys = allCitys;
    }

    public LinkedList<City> getCitys() {
        return citys;
    }

    public void setCitys(LinkedList<City> citys) {
        this.citys = citys;
    }

    public LinkedList<Path> getPaths() {
        return paths;
    }

    public void setPaths(LinkedList<Path> paths) {
        this.paths = paths;
    }

    public static int getNodePathTimes() {
        return nodePathTimes;
    }

    public static void setNodePathTimes(int nodePathTimes) {
        Generate.nodePathTimes = nodePathTimes;
    }

    public static int getMaxCount() {
        return maxCount;
    }

    public static void setMaxCount(int maxCount) {
        Generate.maxCount = maxCount;
    }
}

package hamiltonian;

import Model.City;
import Model.Graph;
import Model.Path;
import generate.Generate;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class BruteForce {

    public static void hamiltonian(Generate generate, City startCity){
        long startTime=System.currentTimeMillis();
        Graph iniGraph=new Graph();
        iniGraph.getCitys().add(startCity);
        iniGraph.getPaths().add(startCity.getName());
        LinkedList<Graph> runningList=new LinkedList<>();
        runningList.add(iniGraph);
        LinkedList<Graph> finishList=new LinkedList<>();
        LinkedList<Graph> successList=new LinkedList<>();
        while (runningList.size()>0){
            Graph usedGraph=runningList.poll();
            if(usedGraph.getCitys().size()==generate.getCitys().size()){
                City nowCity=usedGraph.getCitys().getLast();
                List<Path> satisList=generate.
                        getPaths().
                        stream().
filter(path -> path.getStartCity().getName().equals(nowCity.getName())
                        && path.getEndCity().getName().equals(usedGraph.getCitys().getFirst().getName())).
                        collect(Collectors.toList());
                if(satisList.size()==0){
                    finishList.add(usedGraph);
                }
                else{
                    usedGraph.getCitys().add(usedGraph.getCitys().getFirst());
                    usedGraph.getPaths().add(usedGraph.getPaths().getFirst());
                    usedGraph.setCost(usedGraph.getCost()+satisList.get(0).getCost());
                    successList.add(usedGraph);
                }
            }
            else{

                City nowCity=usedGraph.getCitys().getLast();
                LinkedList<Path> newPath=generate.getPaths().stream().filter(path ->
                        path.getStartCity().getName().equals(nowCity.getName())
                                && !usedGraph.getPaths().contains(path.getEndCity().getName())).collect(Collectors.toCollection(LinkedList::new));
                if(newPath.size()==0){
                    finishList.add(usedGraph);
                }
                else{
                    for(int i=0;i<newPath.size();i+=1){
                        LinkedList<City> replaceCitys=new LinkedList<>(usedGraph.getCitys());
                        LinkedList<String> replacePath=new LinkedList<>(usedGraph.getPaths());
                        Graph newGraph=new Graph();
                        newGraph.setCitys(replaceCitys);
                        newGraph.setPaths(replacePath);
                        newGraph.setCost(usedGraph.getCost());
                        newGraph.getCitys().add(newPath.get(i).getEndCity());
                        newGraph.getPaths().add(newPath.get(i).getEndCity().getName());
                        newGraph.setCost(newPath.get(i).getCost());
                        runningList.add(newGraph);
                    }
                }
            }
            }
        if(successList.size()>0){
            successList.stream().forEach(path-> System.out.println(path.getPaths().toString()));
            System.out.println("-----------------------");
            successList.stream().sorted(Comparator.comparing(Graph::getCost));
            Graph lastGraph=successList.get(successList.size()-1);
            lastGraph.getPaths().stream().forEach(path-> System.out.print(path+"->"));
            System.out.print(lastGraph.getCost());
        }
        else{
            System.out.println("do not have a hamiltonian path");
        }
        System.out.println();
        long endTime=System.currentTimeMillis();
        System.out.print(endTime-startTime);
    }
    private static void outputCircle(LinkedList<City> circleList){
        circleList.stream().forEach(city -> System.out.println(city.getName()+" "));
    }
}

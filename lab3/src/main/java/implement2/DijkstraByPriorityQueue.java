package implement2;

import model.Graph;
import model.Path;
import model.Vertice;
import model.VerticePath;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class DijkstraByPriorityQueue {

    //todo--如何实现: 首先
    public static void findSortPath(Graph graph, String startCityName, String endCityName){
        //初始化
        HashMap<String,Integer> sortestPath=new HashMap<>();
        graph.getGraphPaths().stream().forEach(gp->sortestPath.put(gp.getPoint().getName(),-1));

        sortestPath.put(startCityName,0);


        PriorityQueue<VerticePath> queue=new PriorityQueue<VerticePath>((a,b)->a.getPathWeight()-b.getPathWeight());
        VerticePath startVerticePath= graph.getGraphPaths().stream().filter(gp->gp.getPoint().getName().equals(startCityName)).collect(Collectors.toList()).get(0);
        startVerticePath.setPathWeight(0);
        queue.add(startVerticePath);

        while (queue.size()>0){
            VerticePath nowVerticePath=queue.poll();
            LinkedList<Path> nowPath=nowVerticePath.getPaths();
            int iniWeight=sortestPath.get(nowVerticePath.getPoint().getName());
            for(Path path:nowPath){
                Vertice endVertice=path.getEndVertice();
                int value=sortestPath.get(endVertice.getName());
                if(value==-1){
                    //说明没有来过,要做的操作:1.改值 2.加入队列
                    sortestPath.put(endVertice.getName(),iniWeight+path.getWeight());
                    VerticePath newVerticePath=graph.getGraphPaths().stream().filter
                            (gp->gp.getPoint().getName().equals(endVertice.getName())).
                            collect(Collectors.toList()).get(0);
                    newVerticePath.setPathWeight(iniWeight+path.getWeight());
                    queue.add(newVerticePath);
                }
            }
        }
        System.out.println("最短距离是 "+sortestPath.get(endCityName));
    }
}
 
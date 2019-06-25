package implement;

import model.Graph;
import model.Path;
import model.Vertice;
import model.VerticePath;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class DijkstraByQueue {

    //todo--如何实现: 首先
    public static void findSortPath(Graph graph,String startCityName,String endCityName){
        //初始化
        HashMap<String,Integer> sortestPath=new HashMap<>();
        graph.getGraphPaths().stream().forEach(gp->sortestPath.put(gp.getPoint().getName(),-1));
        sortestPath.put(startCityName,0);
        LinkedList<VerticePath> queue=new LinkedList<>();
        VerticePath startVerticePath= graph.getGraphPaths().stream().filter(gp->gp.getPoint().getName().equals(startCityName)).collect(Collectors.toList()).get(0);
        queue.add(startVerticePath);

        while (queue.size()>0){
            int maxNum=100000;
            int minIndex=-1;
            for(int i=0;i<queue.size();i+=1){
                int tempNum=sortestPath.get(queue.get(i).getPoint().getName());
                if(tempNum<maxNum){
                    minIndex=i;
                    maxNum=tempNum;
                }
            }


            VerticePath nowVerticePath=queue.get(minIndex);
            queue.remove(minIndex);

            LinkedList<Path> nowPath=nowVerticePath.getPaths();
            int iniWeight=sortestPath.get(nowVerticePath.getPoint().getName());
            for(Path path:nowPath){
                Vertice endVertice=path.getEndVertice();
                int value=sortestPath.get(endVertice.getName());
                if(value==-1){
                    //说明没有来过,要做的操作:1.改值 2.加入队列
                    sortestPath.put(endVertice.getName(),iniWeight+path.getWeight());
                    queue.add(graph.getGraphPaths().stream().filter
                            (gp->gp.getPoint().getName().equals(endVertice.getName())).
                            collect(Collectors.toList()).get(0));
                }
                else{
                    //先判断这次是不是更短
                    int nowWeight=iniWeight+path.getWeight();
                    if(nowWeight<value){
                        sortestPath.put(endVertice.getName(),nowWeight);
                    }
                }
            }
        }
        System.out.println("最短距离是 "+sortestPath.get(endCityName));
    }
}
 
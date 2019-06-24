import generate.Generate;
import implement.DijkstraByQueue;
import implement2.DijkstraByPriorityQueue;
import model.Graph;

import java.util.Scanner;

public class Application {
    public static void main(String[] args){
        useUsualQueue(2);
    }

    public static void useUsualQueue(int num){
        Scanner scanner=new Scanner(System.in);
        System.out.print("input the count of vertices:");
        int number=scanner.nextInt();
        Graph graph= Generate.generateGraph(number);
        System.out.println(graph.toString());
        System.out.print("input the first city:");
        String firstCity=scanner.next();
        System.out.print("input the second city:");
        String secondCity=scanner.next();
        if(num==1){
            DijkstraByQueue.findSortPath(graph,firstCity,secondCity);
        }
        else{
            DijkstraByPriorityQueue.findSortPath(graph,firstCity,secondCity);
        }
    }
}
 
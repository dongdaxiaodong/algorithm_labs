package generate;

import model.Graph;
import model.Path;
import model.Vertice;
import model.VerticePath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Generate {
    private static final double facor=1.5;
    private static final int minVerticeNum=4;
    private static final String[] cityNames = {"chengdu", "shanghai", "beijing", "kunming", "tianjin", "shenyang",
            "jilin", "xian", "fuzhou", "hangzhou", "suzhou", "ningbo",
            "mianyang", "panzihua", "abazhou", "nanchong", "shuining", "chongqing",
            "dali", "lijiang", "zhongjiang", "anshan", "dalian", "haerbing",
            "yanbian", "zhenzou", "xining"};

    public static Graph generateGraph(int verticeNums) {
        String[] selectedCitys=generateVerticeNames(verticeNums);
        List<Vertice> vertices=generateVertices(selectedCitys);
        List<Path> paths=generatePath(vertices);
        perfectPath(paths,vertices.size(),vertices);

        List<VerticePath> verticePaths=generateVerticePath(paths,vertices);

        Graph graph=new Graph(vertices.size(),paths.size(),(LinkedList<VerticePath>) verticePaths);
        return graph;
    }




    private static void perfectPath(List<Path> paths,int verticeNum,List<Vertice> vertices){
        int leftNumber=(int)((verticeNum-minVerticeNum)*facor)+1;
        List<Path> addedVerticePath=new LinkedList<>();
        int times=0;
        while (leftNumber>0){
            for(int i=0;i<verticeNum-(2+times);i+=1){
                addedVerticePath.add(new Path(vertices.get(i),vertices.get(i+(2+times))));
                addedVerticePath.add(new Path(vertices.get(i+(2+times)),vertices.get(i)));
                leftNumber-=1;
                if(leftNumber<=0){
                    break;
                }
            }
            if(leftNumber>0){
                times+=1;
            }
        }
        paths.addAll(addedVerticePath);
    }



    private static List<VerticePath> generateVerticePath(List<Path> paths,List<Vertice> vertices){
        LinkedList<VerticePath> verticePaths=new LinkedList<>();
        for(Vertice vertice: vertices){
            VerticePath verticePath=new VerticePath();
            verticePath.setPoint(vertice);
            for(Path path:paths){
                if(path.getStartVertice().getName().equals(vertice.getName())){
                    verticePath.getPaths().add(path);
                }
            }
            verticePaths.add(verticePath);
        }
        return verticePaths;
    }



    private static List<Path> generatePath(List<Vertice> vertices){
        LinkedList<Path> paths=new LinkedList<>();
        for(int i=0;i<vertices.size()-1;i+=1){
            paths.add(new Path(vertices.get(i),vertices.get(i+1)));
        }
        paths.add(new Path(vertices.get(0),vertices.get(vertices.size()-1)));
        LinkedList<Path> newPath=  new LinkedList<>();
        paths.stream().forEach(path -> newPath.add(new Path(path.getEndVertice(),path.getStartVertice())));
        paths.addAll(newPath);
        return paths;
    }


    private static List<Vertice> generateVertices(String[] verticeNames){
        return Arrays.stream(verticeNames).map(city->new Vertice(city)).collect(Collectors.toList());
    }

    private static String[] generateVerticeNames(int verticeNums) {
        ArrayList<String> generateCitys=new ArrayList<>();
        int lastNum=verticeNums;
        while (lastNum>0){
            int index=(int)(Math.random()*cityNames.length);
            String selectName=cityNames[index];
            if(!generateCitys.contains(selectName)){
                generateCitys.add(selectName);
                lastNum-=1;
            }
        }
        String[] arrays=new String[generateCitys.size()];
        for(int i=0;i<generateCitys.size();i+=1){
            arrays[i]=generateCitys.get(i);
        }
        return arrays;
    }
}
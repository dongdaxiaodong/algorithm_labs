package Test;

import model.Path;
import model.Vertice;

public class TestConstructor {
    public static void main(String[] args){
        Path  path=new Path(new Vertice("chengdu"),new Vertice("anshan"));
        Path path1=new Path(path.getStartVertice(),path.getEndVertice());
        System.out.println(path==path1);
        System.out.println(path.getStartVertice()==path1.getStartVertice());
        path1.getStartVertice().setName("colin");
        System.out.println(path.getStartVertice().equals(path1.getStartVertice()));
        Vertice vertice1=new Vertice("colin");
        Vertice vertice2=new Vertice("andy");
        Vertice vertice3=new Vertice("peter");
        Vertice vertice4=new Vertice("colin");
        vertice4=vertice1;
        vertice4.setName("111");
        System.out.println(vertice1.equals(vertice4));
        System.out.println(vertice1.getName());
        String str1="a";
        String str2="b";
    }
}
 
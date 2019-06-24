package test;

import java.util.LinkedList;

public class TestPull {
    public static void main(String[] args){
        LinkedList<Integer> linkedList=new LinkedList<>();
        linkedList.add(3);
        linkedList.add(2);
        int number=linkedList.poll();
        System.out.println(linkedList.size());
        System.out.println(number);
    }
}
 
package testList;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class test {
    public static void main(String[] args){

        Integer[] intArray={1,2,4};
        List<Integer> intgList=Arrays.asList(intArray);
        System.out.println(        intgList.stream().filter(num-> num==2).count());
        String[] arrays={"andy","colin","peter"};
        List<String> list=Arrays.asList(arrays);
        System.out.println(        list.stream().filter(str-> str.equals("andy")).count());
        LinkedList<String> strList=new LinkedList<>();
//        strList= Arrays.asList(strArrays);
        LinkedList<String> newList=new LinkedList<>();
        Collections.reverse(newList);
        strList.stream().forEach(str-> System.out.println(str));
        char numChar=30;
    }
}

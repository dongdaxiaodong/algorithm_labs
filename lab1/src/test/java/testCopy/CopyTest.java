package testCopy;

import java.util.LinkedList;

public class CopyTest {
    public static void main(String[] args){
        LinkedList<People> peoList=new LinkedList<>();
        peoList.add(new People(1,"andy"));
        peoList.add(new People(2,"colin"));
        peoList.add(new People(3,"rachel"));
        LinkedList<People> newList=(LinkedList<People>) peoList.clone();
        newList.get(0).setAge(111);
        peoList.get(1).setName("cccccccccc");
        peoList.stream().forEach(people -> System.out.print(people.getAge()+" and "+people.getName()));
        System.out.println();
        newList.stream().forEach(people -> System.out.print(people.getAge()+" and "+people.getName()));

    }
}
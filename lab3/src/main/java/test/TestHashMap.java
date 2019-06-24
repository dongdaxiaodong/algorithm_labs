package test;

import java.util.HashMap;

public class TestHashMap {
    public static void main(String[] args){
        HashMap<String,Integer> hashMap=new HashMap<>();
        hashMap.put("colin",1);
        hashMap.put("colin",2);
        System.out.println(hashMap.get("colin"));
    }
}
 
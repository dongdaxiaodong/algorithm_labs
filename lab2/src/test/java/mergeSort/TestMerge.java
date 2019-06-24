package mergeSort;

import generate.Generate;

import java.util.Arrays;

public class TestMerge {
    public static void main(String[] args){
        int[] array={3,2,6,1,5,7,2,4};
        int[] newArray= Generate.generateNums(20);
        MergeSort.sort(newArray);
        Arrays.stream(newArray).forEach(a->System.out.println(a));
    }
}
 
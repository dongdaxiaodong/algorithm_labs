package quicksort;

import generate.Generate;
import quickSort.QuickSort;

import java.util.Arrays;

public class TestQuickSort {
    public static void main(String[] args){
//        int[] array=new int[8];
//        array[0]=6;
//        array[1]=3;
//        array[2]=1;
//        array[3]=9;
//        array[4]=4;
//        array[5]=7;
//        array[6]=6;
//        array[7]=0;
        long startTime=System.currentTimeMillis();
        int[] nums= Generate.generateNums(1000);
        long sortTime=System.currentTimeMillis();
        String unsortNum="";
        for(int i=0;i<nums.length;i+=1){
            unsortNum+=nums[i];
            unsortNum+="  ";
        }
        System.out.println(System.currentTimeMillis()-sortTime);
//        QuickSort.quickSort(array,0,array.length-1);
//        Arrays.stream(array).forEach(a->System.out.println(a));
        String sortNum="";
        QuickSort.quickSort(nums,0,nums.length-1);
        for(int i=0;i<nums.length;i+=1){
            sortNum+=nums[i];
            sortNum+="  ";
        }
        long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
        System.out.println(unsortNum);
        System.out.println(sortNum);
    }
}
 
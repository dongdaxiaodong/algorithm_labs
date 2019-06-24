package mergeSort;

import java.util.Arrays;

public class MergeSort {
    public static void sort(int[] array){
        int left=0;
        int right=array.length-1;
        int[] temp=new int[array.length];
        sort(array,left,right);
        array=temp;
    }

    private static void sort(int[] array,int left,int right){
        if(left>=right){
            return;
        }
        else{
            int middle=(left+right)/2;
            sort(array,left,middle);
            sort(array,middle+1,right);
            merge(array,left,right);
        }
    }

    private static void merge(int[] array,int left,int right){
        int[] temp=new int[right-left+1];
        int middleIndex=(left+right)/2+1;
        int leftIndex=left;
        int rightIndex=right;
        int index=0;
        while (leftIndex<=(left+right)/2 && middleIndex<=right){
            if(array[leftIndex]<array[middleIndex]){
                temp[index]=array[leftIndex];
                index+=1;
                leftIndex+=1;
            }
            else{
                temp[index]=array[middleIndex];
                index+=1;
                middleIndex+=1;
            }
        }
        while (leftIndex<=(right+left)/2){
            temp[index]=array[leftIndex];
            index+=1;
            leftIndex+=1;
        }
        while (middleIndex<=rightIndex){
            temp[index]=array[middleIndex];
            index+=1;
            middleIndex+=1;
        }
        for(int i=0;i<temp.length;i+=1){
            array[left+i]=temp[i];
        }
    }


}
 
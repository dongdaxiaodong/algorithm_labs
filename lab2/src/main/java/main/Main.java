package main;

import generate.Generate;
import mergeSort.MergeSort;
import quickSort.QuickSort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        testSort(0);
        testSort(1);
    }

    public static void testSort(int num){
        System.out.print("input a number:");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();
        System.out.print(name);
        String method;
        method=(num==0)?"merge sort":"quick sort";
        int[] testNums={100000,500000,1000000};
        for(int i=0;i<testNums.length;i+=1){
            long startTime=System.currentTimeMillis();
            int[] tenArray= Generate.generateNums(testNums[i]);
            if(num==1){
                QuickSort.quickSort(tenArray,0,tenArray.length-1);
            }
            else {
                MergeSort.sort(tenArray);
            }
            long endTime=System.currentTimeMillis();
            long spend=endTime-startTime;
            System.out.println(method+" "+testNums[i]+" numbers need "+spend+" ms");
        }
    }


    }


package quickSort;


public class QuickSort {


    public static void quickSort(int[] unsortArray,int left,int right) {
        int lowIndex=left;
        int highIndex=right;

         if(lowIndex+1==highIndex){
            if(unsortArray[lowIndex]>unsortArray[highIndex]){
                int temp=unsortArray[lowIndex];
                unsortArray[lowIndex]=unsortArray[highIndex];
                unsortArray[highIndex]=temp;
            }
        }
         else if(lowIndex>=highIndex){
             return;
         }
        else {
            int key = unsortArray[lowIndex];
            boolean turn = true;//为true则 lowIndex走
            while (lowIndex <= highIndex) {
                if (lowIndex == highIndex) {
                    unsortArray[lowIndex] = key;
                    break;
                } else {
                    if (turn) {
                        if (unsortArray[highIndex] < key) {
                            unsortArray[lowIndex] = unsortArray[highIndex];
                            turn = false;
                        }
                        else{
                            highIndex -= 1;
                        }
                    } else {
                        if (unsortArray[lowIndex] > key) {
                            unsortArray[highIndex] = unsortArray[lowIndex];
                            turn = true;
                        }
                        else{
                            lowIndex += 1;
                        }
                    }
                }
            }
             quickSort(unsortArray,left,lowIndex);
            quickSort(unsortArray,lowIndex+1,right);
        }
    }
}
 
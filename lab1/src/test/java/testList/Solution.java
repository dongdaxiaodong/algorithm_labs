package testList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        Arrays.sort(array);
        if(array.length==0){
            return 0;
        }
        else if(array.length==1){
            return array[0];
        }
        else if(array.length==2){
            if(array[0]==array[1]){
                return array[0];
            }
            else{
                return 0;
            }
        }
        else{
            int middle=array.length/2;
            int middleNum=array[middle];
            if(array[middle]!=array[middle-1] && array[middle]!=array[middle+1]){
                return 0;
            }
            else{
                List<Integer> list = Arrays.stream( array ).boxed().collect(Collectors.toList());

                long count=list.stream().filter(num-> num==middleNum).count();
                if(count>middle){
                    return middleNum;
                }
                else{
                    return 0;
                }
            }
        }
    }
}
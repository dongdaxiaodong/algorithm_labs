package generate;

public class Generate {
    private static int max=1000000;

    public static int[] generateNums(int num){
        int[] unsortArray=new int[num];
        int i=0;
        while (i<num){
            int number=(int)(max*Math.random());
            unsortArray[i]=number;
            i+=1;
        }
        return unsortArray;
    }
}
 
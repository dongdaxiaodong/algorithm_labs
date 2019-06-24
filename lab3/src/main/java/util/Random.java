package util;

public class Random {
    private static final int maxWeight=300;

    public static int randomPathWeight(){
        return (int)(maxWeight*(Math.random()));
    }
}
 
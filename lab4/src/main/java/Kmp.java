import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Kmp {
    private static String text;

    public static void matchStr(String matchedStr){
        LinkedList<String> answers=new LinkedList<>();
        HashMap<Integer,Integer> nextMap=getNextMap(matchedStr);
        int strLength=matchedStr.length();
        int allTextIndex=0;
        int startIndex=0;
        while (allTextIndex<text.length()){
            int strIndex=0;
            int textIndex=0;
            for(int i=startIndex;i<strLength;i+=1){
                if(matchedStr.substring(strIndex+startIndex,strIndex+startIndex+1).equals(text.substring(textIndex+allTextIndex,textIndex+allTextIndex+1))){
                    if(i==strLength-1){
                        //说明匹配成功
                        answers.add((textIndex+allTextIndex-strLength)+" to "+(textIndex+allTextIndex+1));
                        String addedStr=text.substring(textIndex+allTextIndex-strLength-5,textIndex+allTextIndex-strLength)+"*"+text.substring(textIndex+allTextIndex-strLength+1,textIndex+allTextIndex+1)+"*"+text.substring(textIndex+allTextIndex+1,textIndex+allTextIndex+6);
                        System.out.println(addedStr);
                        allTextIndex+=strLength;
                        startIndex=0;
                        break;
                    }
                    else{
                        strIndex+=1;
                        textIndex+=1;
                    }
                }
                else {
                    if(startIndex+strIndex==0){

                        int step=1;
                        allTextIndex+=step;
                        startIndex=0;
                        break;
                    }
                    else {
                        int step = (startIndex + strIndex + 1) - nextMap.get(startIndex + strIndex - 1);
                        allTextIndex += step;
                        startIndex = nextMap.get(startIndex + strIndex - 1);
                        break;
                    }
                }
            }
        }
    }

    private static HashMap<Integer,Integer> getNextMap(String matchedStr){
            HashMap<Integer,Integer> hashMap=new HashMap<>();
            for(int i=0;i<matchedStr.length();i+=1){
                String tempStr=matchedStr.substring(0,i+1);
                int tempValue=getNextValue(tempStr);
                hashMap.put(i,tempValue);

            }
            return hashMap;
    }

    private static int getNextValue(String matchedStr){
            LinkedList<String> prefix=new LinkedList<>();
            LinkedList<String> suffix=new LinkedList<>();
            int matchStrLength=matchedStr.length();
            for(int i=0;i<matchStrLength-1;i+=1){
                prefix.add(matchedStr.substring(0,i+1));
                suffix.add(matchedStr.substring(matchStrLength-(i+1),matchStrLength));
            }
            List<String> common;
            common=suffix.stream().filter(str->prefix.contains(str)).collect(Collectors.toList());
            common.sort((a,b)->a.length()-b.length());
            if(common.size()>0){
                return common.get(common.size()-1).length();
            }
            else{
                return 0;
            }

    }

    public static void setText(String text){
        Kmp.text=text;
    }
}
 
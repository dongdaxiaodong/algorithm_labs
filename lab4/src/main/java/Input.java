import java.io.*;

public class Input {
    private static String baseUrl="src/main/java/";

    public static String readFile(String fileName) throws FileNotFoundException, IOException {
        String fileUrl=baseUrl+fileName;
        StringBuffer stringBuffer=new StringBuffer();
        File file=new File(fileUrl);
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
        String tempStr=null;
        while ((tempStr=bufferedReader.readLine())!=null){
            stringBuffer.append(tempStr);
        }
        return stringBuffer.toString();
    }

}
 
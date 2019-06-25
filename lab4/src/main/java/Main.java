import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        String text=Input.readFile("story.txt");
        Kmp.setText(text);
        Kmp.matchStr("said");
    }
}
 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by PaulPlaia18 on 3/14/2018.
 */
public class Prob02S {
    private static final String INPUT_FILE_NAME = "Prob02.in.txt";

    public static void main(String[] args) {
        try {
            // prepare to read
            File inFile = new File(INPUT_FILE_NAME);
            FileReader fr = new FileReader(inFile);
            BufferedReader br = new BufferedReader(fr);
            String inLine = null;

            // num of test cases
            int T = Integer.parseInt(br.readLine());

            // loop through
            while (T > 0) {
                inLine = br.readLine();

                String[] inputs = inLine.split(" ");
                String word = inputs[0];
                int i = Integer.parseInt(inputs[1]);

                System.out.println(word.substring(0, i) + word.substring(i + 1, word.length()));

                T--;
            }

            // close everything
            br.close();
            fr.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

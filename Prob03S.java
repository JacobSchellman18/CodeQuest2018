import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by PaulPlaia18 on 1/13/2018.
 */

public class Prob03S {
    private static final String INPUT_FILE_NAME = "Prob03.in.txt";

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
                int one = Integer.parseInt(inputs[0]);
                int two = Integer.parseInt(inputs[1]);

                System.out.print((one + two) + " ");
                System.out.println((one * two) + "");

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

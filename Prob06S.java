import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Prob06S {
    private static final String INPUT_FILE_NAME = "Prob06.in.txt";
    private static String[] alphabet = {"Alpha", "Bravo", "Charlie", "Delta", "Echo", "Foxtrot", "Golf", "Hotel", "India",
            "Juliet", "Kilo", "Lima", "Mike", "November", "Oscar", "Papa", "Quebec", "Romeo", "Sierra", "Tango",
            "Uniform", "Victor", "Whisky", "Xray", "Yankee", "Zulu"};
    private static char base = 'a';

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
                String out;
                int I = Integer.parseInt(br.readLine());
                while (I > 0) {
                    out = "";
                    inLine = br.readLine().toLowerCase();
                    String[] words = inLine.split(" ");
                    boolean isFirstWord = true;
                    for (String word : words) {
                        if (!isFirstWord) {
                            out += " ";
                        }
                        for (Character c : word.toCharArray()) {
                            out += alphabet[c - base] + "-";
                        }
                        isFirstWord = false;
                        out = out.substring(0, out.length() - 1);
                    }
                    I--;
                    System.out.println(out);
                }
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

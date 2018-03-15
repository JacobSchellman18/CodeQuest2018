import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Prob04S {
    private static final String INPUT_FILE_NAME = "Prob04.in.txt";

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
                int i = Integer.parseInt(inputs[0]);

                if (i == 0) {
                    System.out.println("0");
                } else if (i == 1) {
                    System.out.println("1");
                } else {
                    int[] nums = new int[90];
                    nums[0] = 0;
                    nums[1] = 1;
                    for (int j = 2; j < 90; j++) {
                        nums[j] = nums[j - 2] + nums[j - 1];
                    }

                    System.out.println(nums[i - 1]);
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

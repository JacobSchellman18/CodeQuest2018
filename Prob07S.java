/**
 * Created by PaulPlaia18 on 3/20/2018.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Prob07S {
    private static final String INPUT_FILE_NAME = "Prob07.in.txt";

    public static void main(String[] args) {
        try {
            // prepare to read the file
            File inFile = new File(INPUT_FILE_NAME);
            FileReader fr = new FileReader(inFile);
            BufferedReader br = new BufferedReader(fr);
            String inLine = null;

            // get the number of test cases
            int T = Integer.parseInt(br.readLine());

            // loop through test cases
            for (int t=0; t<T; t++) {
                // read the line of text
                inLine = br.readLine();

                String name = inLine.substring(0, inLine.indexOf(":")) + "=";
                String[] batData = inLine.substring(inLine.indexOf(":") + 1).split(",");

                int count = 0;
                int num = 0;

                for(String dat : batData) {
                    if (dat.equals("K")) count++;
                    else if (dat.equals("1B")) {
                        count++;
                        num++;
                    }
                    else if (dat.equals("2B")) {
                        count ++;
                        num += 2;
                    }
                    else if (dat.equals("3B")) {
                        count++;
                        num += 3;
                    }
                    else if (dat.equals("HR")) {
                        count++;
                        num += 4;
                    }
                }
                double SLG = 1.0 * num/count;
                DecimalFormat df = new DecimalFormat("0.000");
                df.setRoundingMode(RoundingMode.CEILING);
                System.out.println(name+df.format(SLG));
            }

            // clean up
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


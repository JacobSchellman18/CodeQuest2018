import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Prob05S {
    private static final String INPUT_FILE_NAME = "Prob05.in.txt";

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
                String inLine2 = br.readLine();

                String[] names = inLine.split(",");
                String[] names2 = inLine2.split(",");
                ArrayList<String> last = new ArrayList<>(Arrays.asList(names));
                ArrayList<String> newDonors = new ArrayList<>(Arrays.asList(names2));
                ArrayList<String> all = new ArrayList<>();

                ArrayList<String> con1 = new ArrayList<>();
                ArrayList<String> con2 = new ArrayList<>();
                ArrayList<String> con3 = new ArrayList<>();

                for (String name : last) {
                    all.add(name);
                }
                for (String name : newDonors) {
                    if (!all.contains(name)) {
                        all.add(name);
                    }
                }
                for (String name : all) {
                    if (last.contains(name) && !newDonors.contains(name)) {
                        con1.add(name);
                    } else if (last.contains(name) && newDonors.contains(name)) {
                        con2.add(name);
                    } else {
                        con3.add(name);
                    }
                }

                Collections.sort(con1);
                Collections.sort(con2);
                Collections.sort(con3);

                String con1s = con1.toString();
                String con2s = con2.toString();
                String con3s = con3.toString();

                System.out.println(con1s.substring(1, con1s.length() - 1).replaceAll(" ", ""));
                System.out.println(con2s.substring(1, con2s.length() - 1).replaceAll(" ", ""));
                System.out.println(con3s.substring(1, con3s.length() - 1).replaceAll(" ", ""));

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

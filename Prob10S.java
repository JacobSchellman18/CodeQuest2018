import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class Prob10S {
    private static final String INPUT_FILE_NAME = "Prob10.in.txt";
    private static Map<Character, Character> keyMap = new HashMap<>();
    private static boolean capsLock = false;

    public static void main(String[] args) {
        try {
            // prepare to read
            File inFile = new File(INPUT_FILE_NAME);
            FileReader fr = new FileReader(inFile);
            BufferedReader br = new BufferedReader(fr);
            String inLine = null;

            keyMap.put('q', '`'); // fill the keyMap with the appropriate values to translate
            keyMap.put('w', 'q');
            keyMap.put('e', 'w');
            keyMap.put('r', 'e');
            keyMap.put('t', 'r');
            keyMap.put('y', 't');
            keyMap.put('u', 'y');
            keyMap.put('i', 'u');
            keyMap.put('o', 'i');
            keyMap.put('p', 'o');
            keyMap.put('a', '~');
            keyMap.put('s', 'a');
            keyMap.put('d', 's');
            keyMap.put('f', 'd');
            keyMap.put('g', 'f');
            keyMap.put('h', 'g');
            keyMap.put('j', 'h');
            keyMap.put('k', 'j');
            keyMap.put('l', 'k');
            keyMap.put('z', '!');
            keyMap.put('x', 'z');
            keyMap.put('c', 'x');
            keyMap.put('v', 'c');
            keyMap.put('b', 'v');
            keyMap.put('n', 'b');
            keyMap.put('m', 'n');
            keyMap.put(',', 'm');
            keyMap.put('.', ',');

            // num of test cases
            int T = Integer.parseInt(br.readLine());

            // loop through
            while (T > 0) {
                int S = Integer.parseInt(br.readLine());
                while (S > 0) {
                    inLine = br.readLine();

                    String[] words = inLine.split(" ");
                    String res = "";

                    for (String word : words) { // translate each word
                        res += transword(word) + " ";
                    }
                    System.out.println(res);

                    S--;
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

    /**
     * Returns the translated version of the word
     * @param word
     * @return
     */

    private static String transword(String word) {
        char[] letters = word.toCharArray();
        String res = "";
        for (char letter : letters) {
            if (Character.toLowerCase(letter) == 'q') {
                res += "    ";
            } else if (letter == 'a') {
                capsLock = !capsLock;
            } else if (Character.isUpperCase(letter)) {
                if (capsLock) {
                    res += Character.toLowerCase(keyMap.get(Character.toLowerCase(letter)));
                } else {
                    res += Character.toUpperCase(keyMap.get(Character.toLowerCase(letter)));
                }
            } else {
                if (capsLock) {
                    res += Character.toUpperCase(keyMap.get(letter));
                } else {
                    res += keyMap.get(letter);
                }
            }
        }
        return res;
    }
}

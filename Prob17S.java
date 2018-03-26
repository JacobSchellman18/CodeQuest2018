/**
 * Created by PaulPlaia18 on 3/22/2018.
 */


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Prob17S {
    private static final String INPUT_FILE_NAME = "Prob17.in.txt";

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
            for (int t = 0; t < T; t++) {
                // read the line of text
                String row1 = br.readLine();
                String row2 = br.readLine();
                String row3 = br.readLine();
                String[] board = {row1, row2, row3};

                String[][] possMoves = new String[moveNodes(board).size()][3];
                for(int i = 0; i < moveNodes(board).size(); i++) {
                    String[] nBoard = board.clone();
                    nBoard[moveNodes(board).get(i)[0]] = enterMoveAI(nBoard[moveNodes(board).get(i)[0]], moveNodes(board).get(i)[1]);
                    possMoves[i] = nBoard;
                }

                int M = miniMax(possMoves[0], 0);
                int arrTrack = 0;
                for(int i = 1; i < possMoves.length; i++) {
                    if(compWin(possMoves[i])) {
                        arrTrack = i;
                        break;
                    }
                    else if(miniMax(possMoves[i], 0) > M) {
                        M = miniMax(possMoves[i], 0);
                        arrTrack = i;
                    }
                }

                for(int i = 0; i < 3; i++) {
                    System.out.println(possMoves[arrTrack][i]);
                }
                System.out.println("");
            }

            // clean up
            br.close();
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int miniMax(String[] board, int n) {
        if (compWin(board)) return 1;
        else if (playWin(board)) return -1;
        else if(!compWin(board) && !playWin(board) && moveNodes(board).size() == 0) return 0;
        else {
            ArrayList<int[]> moves = moveNodes(board);
            int[] valsList = new int[moves.size()];
            int i = 0;
            for(int[] move : moves) {
                String[] nBoard = board.clone();
                if(n == 0) {
                    nBoard[move[0]] = enterMoveAI(nBoard[move[0]], move[1]);
                    valsList[i] = miniMax(nBoard, 1);
                }
                else {
                    nBoard[move[0]] = enterMovePl(nBoard[move[0]], move[1]);
                    valsList[i] = miniMax(nBoard, 0);
                }
                i++;
            }
            if (n == 0)
                return max(valsList);
            else
                return min(valsList);
        }
    }

    private static boolean compWin(String[] board) {
        boolean winSoFar = true;
        for (int j = 0; j < 3; j++) {
            winSoFar = true;
            for (int i = 0; i < 3; i++) {
                if (board[j].charAt(i) != 'X') winSoFar = false;
            }
            if (winSoFar) return true;
        }
        for (int j = 0; j < 3; j++) {
            winSoFar = true;
            for (int i = 0; i < 3; i++) {
                if (board[i].charAt(j) != 'X') winSoFar = false;
            }
            if (winSoFar) return true;
        }
        winSoFar = true;
        for (int j = 0, i = 0; i < 3; i++, j++) {
            if (board[i].charAt(j) != 'X') winSoFar = false;
        }
        if (winSoFar) return true;
        else {
            winSoFar = true;
            for (int j = 2, i = 2; i >= 0; i--, j--) {
                if (board[i].charAt(j) != 'X') winSoFar = false;
            }
            return winSoFar;
        }
    }

    private static boolean playWin(String[] board) {
        boolean winSoFar = true;
        for (int j = 0; j < 3; j++) {
            winSoFar = true;
            for (int i = 0; i < 3; i++) {
                if (board[j].charAt(i) != 'X') winSoFar = false;
            }
            if (winSoFar) return true;
        }
        for (int j = 0; j < 3; j++) {
            winSoFar = true;
            for (int i = 0; i < 3; i++) {
                if (board[i].charAt(j) != 'X') winSoFar = false;
            }
            if (winSoFar) return true;
        }
        winSoFar = true;
        for (int j = 0, i = 0; i < 3; i++, j++) {
            if (board[i].charAt(j) != 'X') winSoFar = false;
        }
        if (winSoFar) return true;
        else {
            winSoFar = true;
            for (int j = 2, i = 2; i >= 0; i--, j--) {
                if (board[i].charAt(j) != 'X') winSoFar = false;
            }
            return winSoFar;
        }
    }

    private static ArrayList<int[]> moveNodes(String[] board) {
        ArrayList<int[]> nodes = new ArrayList<>();
        for (int j = 0; j < 3; j++) {
            for (int i = 0; i < 3; i++) {
                if (board[j].charAt(i) == '*') nodes.add(new int[]{j, i});
            }
        }
        return nodes;
    }

    private static String enterMoveAI(String row, int j) {
        String res = "";
        for (int i = 0; i < 3; i++) {
            if (i != j) res += row.charAt(i);
            else res += 'X';
        }
        return res;
    }

    private static String enterMovePl(String row, int j) {
        String res = "";
        for (int i = 0; i < 3; i++) {
            if (i != j) res += row.charAt(i);
            else res += 'O';
        }
        return res;
    }

    private static int max (int[] vals) {
        int max = vals[0];
        for(int i = 1; i < vals.length; i++)
            if (vals[i] > max) max = vals[i];
        return max;
    }

    private static int min (int[] vals) {
        int min = vals[0];
        for(int i = 1; i < vals.length; i++)
            if (vals[i] < min) min = vals[i];
        return min;
    }
}

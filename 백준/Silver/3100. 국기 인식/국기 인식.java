import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    static final int ROWS = 6;
    static final int COLS = 9;
    static char[][] flag = new char[ROWS][COLS];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < ROWS; i++) {
            String line = br.readLine();
            flag[i] = line.toCharArray();
        }
        int answer = Integer.MAX_VALUE;
        HashSet<Character> colors = new HashSet<>();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                colors.add(flag[i][j]);
            }
        }
        if (colors.size() == 1) {
            System.out.println(18);
            return;
        }
        for (char color1 : colors) {
            for (char color2 : colors) {
                for (char color3 : colors) {
                    if (color2 != color1 && color2 != color3) {
                        int horizontalChanges = countHorizontalChanges(color1, color2, color3);
                        int verticalChanges = countVerticalChanges(color1, color2, color3);
                        answer = Math.min(answer, Math.min(horizontalChanges, verticalChanges));
                    }
                }
            }
        }
        System.out.println(answer);
    }

    static int countHorizontalChanges(char top, char middle, char bottom) {
        int changes = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < COLS; j++) {
                if (flag[i][j] != top)
                    changes++;
            }
        }
        for (int i = 2; i < 4; i++) {
            for (int j = 0; j < COLS; j++) {
                if (flag[i][j] != middle)
                    changes++;
            }
        }
        for (int i = 4; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (flag[i][j] != bottom)
                    changes++;
            }
        }
        return changes;
    }

    static int countVerticalChanges(char left, char middle, char center) {
        int changes = 0;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < 3; j++) {
                if (flag[i][j] != left)
                    changes++;
            }
        }
        for (int i = 0; i < ROWS; i++) {
            for (int j = 3; j < 6; j++) {
                if (flag[i][j] != middle)
                    changes++;
            }
        }
        for (int i = 0; i < ROWS; i++) {
            for (int j = 6; j < COLS; j++) {
                if (flag[i][j] != center)
                    changes++;
            }
        }
        return changes;
    }
}
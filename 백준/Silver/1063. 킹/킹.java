import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] king = toIntArr(st.nextToken());
        int[] stone = toIntArr(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        while (n-- > 0) {
            char[] oper = br.readLine().toCharArray();
            int[] move = new int[2];
            for (int i = 0; i < oper.length; i++)
                switch (oper[i]) {
                case 'R':
                    move[0]++;
                    break;
                case 'L':
                    move[0]--;
                    break;
                case 'B':
                    move[1]--;
                    break;
                case 'T':
                    move[1]++;
                    break;
                }
            int[] tempKing = { king[0] + move[0], king[1] + move[1] };
            int[] tempStone = { stone[0] + move[0], stone[1] + move[1] };
            if (isValid(tempKing[0], tempKing[1])) {
                if (tempKing[0] == stone[0] && tempKing[1] == stone[1]) {
                    if (isValid(tempStone[0], tempStone[1])) {
                        king = tempKing;
                        stone = tempStone;
                    }
                } else {
                    king = tempKing;
                }
            }
        }
        System.out.println(toStr(king));
        System.out.println(toStr(stone));
    }

    private static boolean isValid(int y, int x) {
        return 'A' <= y && y <= 'H' && '1' <= x && x <= '8';
    }

    private static String toStr(int[] arr) {
        return String.valueOf(new char[] { (char) arr[0], (char) arr[1] });
    }

    private static int[] toIntArr(String str) {
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++)
            arr[i] = str.charAt(i);
        return arr;
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int[][] MAP = { { 1, 2, 3, 4, 5, 1, 2, 3 }, { 4, 5, 1, 2, 3, 4, 5, 1 }, { 2, 3, 4, 5, 1, 2, 3, 4 },
            { 5, 1, 2, 3, 4, 5, 1, 2 }, { 3, 4, 5, 1, 2, 3, 4, 5 } };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] arr = new int[8];
        for (int tc = 1; tc <= 10; tc++) {
            br.readLine();
            st = new StringTokenizer(br.readLine());
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 8; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                min = Math.min(min, arr[i]);
            }
            int idx = simulate(arr, min / 15);
            sb.append("#").append(tc).append(" ");
            for (int i = idx + 1; i < 8; i++)
                sb.append(arr[i]).append(" ");
            for (int i = 0; i <= idx; i++)
                sb.append(arr[i]).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int simulate(int[] arr, int cycle) {
        for (int i = 0; i < 8; i++)
            arr[i] -= (cycle - 1) * 15;
        int i = 0, j = 0;
        while (arr[i] > 0) {
            arr[i] = Math.max(0, arr[i] - MAP[j][i]);
            if (arr[i] == 0)
                break;
            i++;
            if (i == 8) {
                i = 0;
                j = (j + 1) % 5;
            }
        }
        return i;
    }
}
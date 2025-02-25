import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    static int n, maxValue, minValue;
    static int[] opers, numbers;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= t; tc++) {
            n = Integer.parseInt(br.readLine());
            opers = new int[4];
            numbers = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++)
                opers[i] = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++)
                numbers[i] = Integer.parseInt(st.nextToken());
            maxValue = Integer.MIN_VALUE;
            minValue = Integer.MAX_VALUE;
            recursive(1, numbers[0]);
            sb.append("#").append(tc).append(" ").append(maxValue - minValue).append("\n");
        }
        System.out.println(sb);
    }

    private static void recursive(int depth, int value) {
        if (depth == n) {
            maxValue = Math.max(maxValue, value);
            minValue = Math.min(minValue, value);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (opers[i] != 0) {
                opers[i]--;
                int nextValue = calculate(value, numbers[depth], i);
                recursive(depth + 1, nextValue);
                opers[i]++;
            }
        }
    }

    private static int calculate(int a, int b, int oper) {
        switch (oper) {
        case 0:
            return a + b;
        case 1:
            return a - b;
        case 2:
            return a * b;
        case 3:
            return a / b;
        }
        return 0;
    }
}
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        while (true) {
            int n = read();
            if (n == 0)
                break;
            int[] arr = new int[n + 1];
            for (int i = 0; i < n; i++)
                arr[i] = read();
            Arrays.sort(arr);
            boolean possible = true;
            for (int i = 0; i < n; i++)
                if (arr[i + 1] - arr[i] > 200) {
                    possible = false;
                    break;
                }
            if (1422 - arr[n] > 100)
                possible = false;
            sb.append(possible ? "POSSIBLE\n" : "IMPOSSIBLE\n");
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
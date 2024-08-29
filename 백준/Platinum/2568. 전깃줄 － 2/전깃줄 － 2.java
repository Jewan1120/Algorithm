import java.util.Arrays;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i] = new int[] { read(), read() };
        }
        Arrays.sort(arr, (o1, o2) -> o1[0] - o2[0]);
        int[] lis = new int[n];
        int[] tracking = new int[n];
        int[] lastIndex = new int[n];
        Arrays.fill(tracking, -1);
        int len = 0;
        for (int i = 0; i < n; i++) {
            int num = arr[i][1];
            int idx = Arrays.binarySearch(lis, 0, len, num);
            if (idx < 0)
                idx = ~idx;
            lis[idx] = num;
            lastIndex[idx] = i;
            if (idx > 0)
                tracking[i] = lastIndex[idx - 1];
            if (idx == len)
                len++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(n - len).append("\n");
        HashSet<Integer> hs = new HashSet<>();
        for (int i = lastIndex[len - 1]; i != -1; i = tracking[i]) {
            hs.add(arr[i][0]);
        }
        for (int i = 0; i < n; i++)
            if (!hs.contains(arr[i][0]))
                sb.append(arr[i][0]).append("\n");
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
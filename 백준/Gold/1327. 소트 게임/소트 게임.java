import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), k = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        int[] tempArr = arr.clone();
        Arrays.sort(tempArr);
        String answer = arrToStr(tempArr);
        Deque<int[]> dq = new ArrayDeque<>();
        HashSet<String> hs = new HashSet<>();
        dq.offer(arr);
        int cnt = 0;
        while (!dq.isEmpty()) {
            int size = dq.size();
            while (size-- > 0) {
                int[] cur = dq.poll();
                String curStr = arrToStr(cur);
                if (hs.contains(curStr))
                    continue;
                if (curStr.equals(answer)) {
                    System.out.println(cnt);
                    return;
                }
                hs.add(curStr);
                for (int i = 0; i < n - k + 1; i++) {
                    int[] next = nextArr(cur, i, k);
                    dq.offer(next);
                }
            }
            cnt++;
        }
        System.out.println(-1);
    }

    private static int[] nextArr(int[] arr, int s, int k) {
        int[] next = arr.clone();
        for (int i = 0; i < k; i++) {
            next[s + i] = arr[s + k - i - 1];
        }
        return next;
    }

    private static String arrToStr(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr)
            sb.append(i);
        return sb.toString();
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return n;
    }
}
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = read();
            hm.put(arr[i], hm.getOrDefault(arr[i], 0) + 1);
        }
        Deque<Integer> dq = new ArrayDeque<>();
        int[] result = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!dq.isEmpty() && hm.get(dq.peekLast()) <= hm.get(arr[i]))
                dq.pollLast();
            if (dq.isEmpty())
                result[i] = -1;
            else
                result[i] = dq.peekLast();
            dq.offerLast(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i : result)
            sb.append(i).append(" ");
        System.out.println(sb);
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
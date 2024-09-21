import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        int m = read();
        int[][] commands = new int[m][3];
        for (int i = 0; i < m; i++)
            commands[i] = new int[] { read(), read(), read() };
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(arrToInt(arr), 0);
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> hm.get(arrToInt(o1)) - hm.get(arrToInt(o2)));
        pq.offer(arr.clone());
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int key = arrToInt(cur);
            for (int[] command : commands) {
                int[] next = swap(cur, command[0], command[1]);
                int nextKey = arrToInt(next);
                if (hm.get(key) + command[2] < hm.getOrDefault(nextKey, Integer.MAX_VALUE)) {
                    hm.put(nextKey, hm.get(key) + command[2]);
                    pq.add(next);
                }
            }
        }
        Arrays.sort(arr);
        int key = arrToInt(arr);
        System.out.println(hm.getOrDefault(key, -1));
    }

    private static int arrToInt(int[] arr) {
        int result = 0;
        for (int num : arr) {
            result *= 10;
            if (num == 10)
                result *= 10;
            result += num;
        }
        return result;
    }

    private static int[] swap(int[] arr, int s, int e) {
        int[] result = arr.clone();
        int temp = result[s - 1];
        result[s - 1] = result[e - 1];
        result[e - 1] = temp;
        return result;
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
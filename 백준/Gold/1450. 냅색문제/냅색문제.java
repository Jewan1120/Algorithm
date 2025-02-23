import java.util.Map;
import java.util.TreeMap;

public class Main {

    static int n, c;
    static TreeMap<Long, Integer> tm = new TreeMap<>();
    static TreeMap<Long, Integer> prefixSum = new TreeMap<>();

    public static void main(String[] args) throws Exception {
        n = read();
        c = read();
        int[] aArr = new int[n / 2];
        int[] bArr = new int[n - n / 2];
        for (int i = 0; i < aArr.length; i++)
            aArr[i] = read();
        for (int i = 0; i < bArr.length; i++)
            bArr[i] = read();
        recursive(0, 0, aArr);

        int sum = 0;
        for (Map.Entry<Long, Integer> entry : tm.entrySet()) {
            sum += entry.getValue();
            prefixSum.put(entry.getKey(), sum);
        }

        System.out.println(countSubsets(0, 0, bArr));
    }

    private static void recursive(int depth, long sum, int[] arr) {
        if (sum > c)
            return;
        if (depth == arr.length) {
            tm.put(sum, tm.getOrDefault(sum, 0) + 1);
            return;
        }
        recursive(depth + 1, sum + arr[depth], arr);
        recursive(depth + 1, sum, arr);
    }

    private static long countSubsets(int depth, long sum, int[] arr) {
        if (sum > c)
            return 0;
        if (depth == arr.length) {
            return prefixSum.floorEntry(c - sum) != null ? prefixSum.floorEntry(c - sum).getValue() : 0;
        }
        return countSubsets(depth + 1, sum + arr[depth], arr) + countSubsets(depth + 1, sum, arr);
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
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        int n = read();
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
            int p = read();
            if (p != -1)
                tree.get(p).add(i);
        }
        System.out.println(recursive(0));
    }

    private static int recursive(int n) {
        ArrayList<Integer> sub = tree.get(n);
        int len = sub.size();
        Integer[] arr = new Integer[len];
        int max = 0;
        for (int i = 0; i < len; i++) {
            arr[i] = recursive(sub.get(i));
        }
        Arrays.sort(arr, (o1, o2) -> o2.compareTo(o1));
        for (int i = 0; i < len; i++)
            max = Math.max(max, arr[i] + (i + 1));
        return max;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return m ? ~n + 1 : n;
    }
}
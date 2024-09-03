import java.util.ArrayList;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n + 1];
        for (int i = 1; i < n + 1; i++)
            arr[i] = read();
        ArrayList<HashSet<Integer>> al = new ArrayList<>();
        for (int i = 0; i < n + 1; i++)
            al.add(new HashSet<>());
        for (int i = 1; i < n + 1; i++)
            for (int j = i; j < n + 1; j++) {
                if (isPalidrome(arr, i, j))
                    al.get(i).add(j);
            }
        int m = read();
        StringBuilder sb = new StringBuilder();
        while (m-- > 0)
            sb.append(al.get(read()).contains(read()) ? 1 : 0).append("\n");
        System.out.println(sb);
    }

    public static boolean isPalidrome(int[] arr, int s, int e) {
        while (s < e) {
            if (arr[s] != arr[e])
                return false;
            s++;
            e--;
        }
        return true;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
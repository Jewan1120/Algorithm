import java.util.Arrays;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        int[] lis = new int[n];
        int[] lisIdx = new int[n];
        int len = 0;
        for (int i = 0; i < n; i++) {
            int idx = Arrays.binarySearch(lis, 0, len, arr[i]);
            if (idx < 0)
                idx = ~idx;
            lis[idx] = arr[i];
            lisIdx[i] = idx + 1;
            if (idx == len)
                len++;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(len).append("\n");
        Stack<Integer> stk = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (lisIdx[i] == len) {
                stk.add(arr[i]);
                len--;
            }
        }
        while(!stk.isEmpty())
            sb.append(stk.pop()).append(" ");
        System.out.println(sb);
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
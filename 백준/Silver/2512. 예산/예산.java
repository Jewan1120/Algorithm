import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        Arrays.sort(arr);
        int m = read();
        int max = 0;
        int l = 0, r = arr[n - 1];
        while (l <= r) {
            int mid = (l + r) / 2;
            int budgetSum = 0;
            int maxBudget = 0;
            for (int i = 0; i < n; i++) {
                int budget = Math.min(mid, arr[i]);
                maxBudget = Math.max(maxBudget, budget);
                budgetSum += budget;
            }
            if (budgetSum <= m) {
                l = mid + 1;
                max = Math.max(max, maxBudget);
            } else
                r = mid - 1;
        }
        System.out.println(max);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        int minRange = 2_000_000_001;
        int leftValue = 0, rightValue = 0;
        int l = 0, r = n - 1;
        while (l < r) {
            int sum = arr[l] + arr[r];
            int distance = Math.abs(sum);
            if (distance < minRange) {
                minRange = distance;
                leftValue = arr[l];
                rightValue = arr[r];
            }
            if (sum > 0)
                r--;
            else if (sum < 0)
                l++;
            else
                break;
        }
        System.out.printf("%d %d", leftValue, rightValue);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return m ? ~n + 1 : n;
    }
}

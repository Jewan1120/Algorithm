public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        int gcd = 0;
        for (int i = 1; i < n; i++)
            gcd = gcd(gcd, Math.abs(arr[i] - arr[i - 1]));
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= gcd; i++)
            if (gcd % i == 0)
                sb.append(i).append(" ");
        System.out.println(sb);
    }

    private static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
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

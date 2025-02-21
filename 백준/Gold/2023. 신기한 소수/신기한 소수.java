public class Main {

    static int n;
    static int[] arr = { 1, 3, 5, 7, 9 };
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        n = read();
        for (int i = 2; i < 10; i++)
            if (isPrime(i))
                recursive(1, i);
        System.out.println(sb);
    }

    private static void recursive(int depth, int num) {
        if (depth == n) {
            sb.append(num).append("\n");
            return;
        }
        for (int i = 0; i < 5; i++) {
            int next = num * 10 + arr[i];
            if (isPrime(next))
                recursive(depth + 1, next);
        }
    }

    private static boolean isPrime(int num) {
        for (int i = 2; i <= Math.sqrt(num); i++)
            if (num % i == 0)
                return false;
        return true;
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
public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n + 1];
        arr[0] = 2;
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] + (int) Math.pow(2, i - 1);
        }
        System.out.println((int) Math.pow(arr[n], 2));
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}
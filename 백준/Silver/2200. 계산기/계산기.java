public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n + 1];
        for (int i = 0; i < n + 1; i++)
            arr[i] = read();
        int cnt = n * 2;
        for (int i = 1; i < n + 1; i++) {
            if (arr[i] != 0) {
                cnt += count(arr[i]) + 1;
            }
        }
        System.out.println(cnt);
    }

    private static int count(int x) {
        return (int) Math.log10(x) + 1;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
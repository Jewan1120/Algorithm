public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = read();
        int buy = arr[0], max = 0;
        for (int i = 1; i < n; i++) {
            int price = arr[i];
            if (price < buy)
                buy = price;
            else
                max = Math.max(max, price - buy);
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
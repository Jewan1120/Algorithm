public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[n];
        int avg = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = read();
            avg += arr[i];
        }
        avg /= n;
        int pos = 0, neg = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > avg + 1) {
                pos += arr[i] - (avg + 1);
            }
            if (arr[i] < avg) {
                neg += avg - arr[i];
            }
        }
        System.out.println(Math.max(pos, neg));
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
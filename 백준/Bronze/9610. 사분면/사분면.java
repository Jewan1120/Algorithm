public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        int[] arr = new int[5];
        while (n-- > 0) {
            int a = read(), b = read();
            if (a == 0 || b == 0) {
                arr[0]++;
            } else if (a > 0) {
                if (b > 0) {
                    arr[1]++;
                } else {
                    arr[4]++;
                }
            } else {
                if (b > 0) {
                    arr[2]++;
                } else {
                    arr[3]++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 4; i++) {
            sb.append("Q").append(i).append(": ").append(arr[i]).append("\n");
        }
        sb.append("AXIS: ").append(arr[0]);
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
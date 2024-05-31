public class Main {
    public static void main(String[] args) throws Exception {
        boolean[] prime = new boolean[246913];
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(246912); i++) {
            if (!prime[i]) {
                for (int j = i * i; j <= 246912; j += i) {
                    prime[j] = true;
                }
            }
        }
        int[] cntArr = new int[246913];
        int cnt = 0;
        for (int i = 0; i < 246913; i++) {
            if (!prime[i]) cnt++;
            cntArr[i] = cnt;
        }
        StringBuilder sb = new StringBuilder();
        int n;
        while((n = read()) > 0) {
            sb.append(cntArr[2 * n] - cntArr[n]).append("\n");
        }
        System.out.println(sb);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        final int max = 1000 * 1000 + 1;
        int[] dpR = { read(), max, max };
        int[] dpG = { max, read(), max };
        int[] dpB = { max, max, read() };
        for (int i = 0; i < n - 1; i++) {
            int r = read(), g = read(), b = read();
            int[] tempR = { Math.min(dpR[1], dpR[2]) + r, Math.min(dpR[0], dpR[2]) + g, Math.min(dpR[0], dpR[1]) + b };
            int[] tempG = { Math.min(dpG[1], dpG[2]) + r, Math.min(dpG[0], dpG[2]) + g, Math.min(dpG[0], dpG[1]) + b };
            int[] tempB = { Math.min(dpB[1], dpB[2]) + r, Math.min(dpB[0], dpB[2]) + g, Math.min(dpB[0], dpB[1]) + b };
            dpR = tempR;
            dpG = tempG;
            dpB = tempB;
        }
        System.out.println(
                Math.min(Math.min(dpR[1], dpR[2]), Math.min(Math.min(dpG[0], dpG[2]), Math.min(dpB[0], dpB[1]))));
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
public class Solution {

    public static void main(String[] args) throws Exception {
        int t = read();
        StringBuilder sb = new StringBuilder();
        int n;
        for (int tc = 1; tc <= t; tc++) {
            n = read();
            int cur = 0, prev = 0;
            int totalCnt = 0, uCnt = 0;
            boolean dFlag = false;
            for (int i = 0; i < n; i++) {
                cur = read();
                if (prev < cur) {
                    if (dFlag) {
                        uCnt = 1;
                        dFlag = false;
                    }
                    uCnt++;
                } else {
                    dFlag = true;
                    totalCnt += uCnt - 1;
                }
                prev = cur;
            }
            sb.append("#").append(tc).append(" ").append(totalCnt).append("\n");
        }
        System.out.println(sb);
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
public class Main {
    public static void main(String[] args) throws Exception {
        int n = read();
        int[][] judge = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++){
                judge[i][j] = read();
            }
        }
        int cnt = 0;
        next: for (int i = 123; i <= 987; i++) {
            int[] num = {i / 100, i % 100 / 10, i % 10};
            if (num[0] == 0 || num[1] == 0 || num[2] == 0 || num[0] == num[1] || num[0] == num[2] || num[1] == num[2])
                continue;
            for (int j = 0; j < n; j++) {
                int[] jnum = {judge[j][0] / 100, judge[j][0] % 100 / 10, judge[j][0] % 10};
                int stk = 0, ball = 0;
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        if (num[k] == jnum[l]) {
                            if (k == l) stk++;
                            else ball++;
                        }
                    }
                }
                if (stk != judge[j][1] || ball != judge[j][2])
                    continue next;
            }
            cnt++;
        }
        System.out.println(cnt);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
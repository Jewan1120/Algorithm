public class Main {

    static int n, maxScore = Integer.MIN_VALUE;
    static int[][] rounds;

    static int[] orders = new int[9];
    static boolean[] visited = { true, false, false, false, false, false, false, false, false };

    public static void main(String[] args) throws Exception {
        n = read();
        rounds = new int[n][9];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < 9; j++)
                rounds[i][j] = read();
        recursive(0);
        System.out.println(maxScore);
    }

    private static void recursive(int depth) {
        if (depth == 9) {
            int score = 0, index = 0;
            for (int i = 0; i < n; i++) {
                int[] round = rounds[i];
                int result = 0, outCount = 0;
                while (outCount < 3) {
                    int oper = round[orders[index++]];
                    if (index == 9)
                        index = 0;
                    if (oper == 0) {
                        outCount++;
                        continue;
                    }
                    result <<= oper;
                    result |= (1 << (oper - 1));
                    score += Integer.bitCount(result >> 3);
                    result &= 7;
                }
            }
            maxScore = Math.max(maxScore, score);
            return;
        }
        if (depth == 3) {
            recursive(depth + 1);
            return;
        }
        for (int i = 1; i < 9; i++)
            if (!visited[i]) {
                visited[i] = true;
                orders[depth] = i;
                recursive(depth + 1);
                visited[i] = false;
            }
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
public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        boolean[][] maze = new boolean[n - 2][4];
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < 4; j++)
                maze[i][j] = System.in.read() == '0';
            System.in.read();
        }
        int min = 10001;
        for (int i = 0; i < 4; i++) {
            int cnt = 0;
            for (int j = 0; j < n - 2; j++) {
                int move = 4;
                if ((i == 0 && maze[j][3]) || (i == 3 && maze[j][0]))
                    move = 1;
                for (int k = 0; k < 4; k++)
                    if (maze[j][k]) {
                        move = Math.min(move, Math.abs(i - k));
                        break;
                    }
                cnt += move;
            }
            min = Math.min(min, cnt);
        }
        System.out.println(min + n + 2);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
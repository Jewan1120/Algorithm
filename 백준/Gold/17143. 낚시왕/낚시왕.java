import java.util.ArrayList;

public class Main {

    static int R, C, M, h = 0, totalSize = 0;
    static int[] dr = { 0, -1, 1, 0, 0 }, dc = { 0, 0, 0, 1, -1 };
    static int[][] board;
    static ArrayList<int[]> sharks = new ArrayList<>(), nextSharks = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        R = read();
        C = read();
        M = read();
        board = new int[R + 1][C + 1];
        for (int i = 0; i < M; i++) {
            int r = read(), c = read(), s = read(), d = read(), z = read();
            sharks.add(new int[] { r, c, s, d, z });
            if (c == 1)
                h = h == 0 ? r : Math.min(h, r);
            board[r][c] = z;
        }
        sharks.sort((o1, o2) -> o2[4] - o1[4]);
        for (int i = 1; i < C + 1; i++) {
            totalSize += board[h][i];
            int nh = 0;
            nextSharks = new ArrayList<>();
            board = new int[R + 1][C + 1];
            for (int[] shark : sharks) {
                if (shark[0] == h && shark[1] == i)
                    continue;
                int[] nextShark = moveShark(shark);
                int r = nextShark[0], c = nextShark[1], z = nextShark[4];
                if (board[r][c] != 0)
                    continue;
                nextSharks.add(nextShark);
                if (c == i + 1)
                    nh = nh == 0 ? r : Math.min(nh, r);
                board[r][c] = z;
            }
            sharks = nextSharks;
            h = nh;
        }
        System.out.println(totalSize);
    }

    private static int[] moveShark(int[] shark) {
        int r = shark[0], c = shark[1], s = shark[2], d = shark[3], z = shark[4];
        int ns = 0;
        if (d == 1 || d == 2) {
            ns = s % ((R - 1) * 2);
        } else {
            ns = s % ((C - 1) * 2);
        }
        for (int i = 0; i < ns; i++) {
            r += dr[d];
            c += dc[d];
            if (!isValid(r, c)) {
                r -= dr[d] * 2;
                c -= dc[d] * 2;
                if (d == 1 || d == 3)
                    d++;
                else
                    d--;
            }
        }
        return new int[] { r, c, s, d, z };
    }

    private static boolean isValid(int r, int c) {
        return 0 < r && r <= R && 0 < c && c <= C;
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
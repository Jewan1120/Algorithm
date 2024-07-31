public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        boolean[][] board = new boolean[500][500];
        int area = 0;
        while (n-- > 0) {
            int x1 = read(), y1 = read(), x2 = read(), y2 = read();
            for (int i = y1; i < y2; i++)
                for (int j = x1; j < x2; j++) {
                    if(!board[i][j])
                        area++;
                    board[i][j] = true;
                }
        }
        System.out.println(area);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
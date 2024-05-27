public class Main {

    public static void main(String[] args) throws Exception {
        int max = -1;
        int x = 0, y = 0;
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                int p = read();
                if (p > max) {
                    max = p;
                    y = i;
                    x = j;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(y).append(" ").append(x);
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}
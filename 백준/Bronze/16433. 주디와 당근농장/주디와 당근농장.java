public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        boolean flg = (read() + read()) % 2 == 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (flg)
                    sb.append("v");
                else
                    sb.append(".");
                flg = !flg;
            }
            if (n % 2 == 0)
                flg = !flg;
            sb.append("\n");
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
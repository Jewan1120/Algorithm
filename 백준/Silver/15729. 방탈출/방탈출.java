public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        boolean[] btn = new boolean[n];
        for (int i = 0; i < n; i++)
            btn[i] = read() == 1;
        int cnt = 0;
        boolean[] temp = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (temp[i] != btn[i]) {
                cnt++;
                for (int j = i; j < i + 3 && j < n; j++) {
                    temp[j] = !temp[j];
                }
            }
        }
        System.out.println(cnt);
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
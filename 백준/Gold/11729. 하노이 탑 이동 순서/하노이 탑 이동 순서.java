public class Main {
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        int c, n = System.in.read() & 15;
        while((c = System.in.read()) >= 48) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        sb.append((int) Math.pow(2, n) - 1).append("\n");
        hanoi(n, 1 , 2, 3);
        System.out.println(sb);
    }
    private static void hanoi(int n, int s, int m, int e) {
        if (n == 1) {
            sb.append(s).append(" ").append(e).append("\n");
            return;
        }
        hanoi(n - 1, s, e, m);
        sb.append(s).append(" ").append(e).append("\n");
        hanoi(n - 1, m, s, e);
    }
}
public class Main {
    public static void main(String[] args) throws Exception {
        int[] xArr = new int[2];
        int[] yArr = new int[2];
        for (int i = 0; i < 2; i++) {
            xArr[i] = read();
            yArr[i] = read();
        }
        StringBuilder sb = new StringBuilder();
        int x = read();
        int y = read();
        sb.append(xArr[0] == xArr[1] ? x : xArr[0] == x ? xArr[1] : xArr[0]);
        sb.append(" ");
        sb.append(yArr[0] == yArr[1] ? y : yArr[0] == y ? yArr[1] : yArr[0]);
        System.out.println(sb);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48) 
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
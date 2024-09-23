public class Main {

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws Exception {
        Node A = new Node(read(), read());
        Node B = new Node(read(), read());
        Node C = new Node(read(), read());
        Node D = new Node(read(), read());
        int AB = ccw(A, B, C) * ccw(A, B, D);
        int CD = ccw(C, D, A) * ccw(C, D, B);
        if (AB == 0 && CD == 0) {
            if ((Math.max(A.x, B.x) >= Math.min(C.x, D.x) && Math.max(C.x, D.x) >= Math.min(A.x, B.x))
                    && (Math.max(A.y, B.y) >= Math.min(C.y, D.y) && Math.max(C.y, D.y) >= Math.min(A.y, B.y)))
                System.out.println(1);
            else
                System.out.println(0);
        } else if (AB <= 0 && CD <= 0)
            System.out.println(1);
        else
            System.out.println(0);
    }

    private static int ccw(Node p1, Node p2, Node p3) {
        long op = (long) (p2.x - p1.x) * (p3.y - p1.y) - (long) (p2.y - p1.y) * (p3.x - p1.x);
        if (op > 0)
            return 1;
        else if (op == 0)
            return 0;
        else
            return -1;
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        boolean m = n == 13;
        if (m)
            n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        if (c == 13)
            System.in.read();
        return m ? ~n + 1 : n;
    }
}
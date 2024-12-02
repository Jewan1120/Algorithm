public class Main {

    static StringBuilder sb = new StringBuilder();
    static int[] inOrder, inOrderIdx, postOrder;

    public static void main(String[] args) throws Exception {
        int n = read();
        inOrder = new int[n];
        inOrderIdx = new int[n + 1];
        for (int i = 0; i < n; i++) {
            inOrder[i] = read();
            inOrderIdx[inOrder[i]] = i;
        }
        postOrder = new int[n];
        for (int i = 0; i < n; i++)
            postOrder[i] = read();
        getPreOrder(0, n - 1, 0, n - 1);
        System.out.println(sb);
    }

    private static void getPreOrder(int il, int ir, int pl, int pr) {
        if (il > ir || pl > pr)
            return;
        int root = postOrder[pr];
        sb.append(root).append(" ");
        int rootIdx = inOrderIdx[root];
        getPreOrder(il, rootIdx - 1, pl, pl + rootIdx - il - 1);
        getPreOrder(rootIdx + 1, ir, pl + rootIdx - il, pr - 1);
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
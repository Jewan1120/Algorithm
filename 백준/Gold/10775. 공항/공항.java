public class Main {

    static int[] parent;

    public static void main(String[] args) throws Exception {
        int g = read(), p = read();
        parent = new int[g + 1];
        for (int i = 1; i < g + 1; i++)
            parent[i] = i;
        int[] arr = new int[p];
        for (int i = 0; i < p; i++)
            arr[i] = read();
        int cnt = 0;
        for (int i = 0; i < p; i++) {
            int gi = find(arr[i]);
            if (gi == 0)
                break;
            cnt++;
            parent[gi]--;
        }
        System.out.println(cnt);
    }

    private static int find(int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent[x]);
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
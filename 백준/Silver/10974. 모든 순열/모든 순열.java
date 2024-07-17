public class Main {

    static int n;
    static int[] arr;
    static int[] result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        n = read();
        arr = new int[n];
        result= new int[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++)
            arr[i] = i + 1;
        sequence(0);
        System.out.println(sb);
    }

    private static void sequence(int depth) {
        if (depth == n) {
            for (int i = 0; i < n; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                sequence(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
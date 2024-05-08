import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<ArrayList<char[]>> graph;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        StringTokenizer st;
        for (; n > 0; n--) {
            st = new StringTokenizer(br.readLine());
            int p = st.nextToken().charAt(0) - 'A';
            graph.get(p).add(new char[] {st.nextToken().charAt(0), st.nextToken().charAt(0)});
        }
        preorder(0);
        sb.append("\n");
        inorder(0);
        sb.append("\n");
        postorder(0);
        System.out.println(sb);
        br.close();
    }

    public static void preorder(int v) {
        char[] edge = graph.get(v).get(0);
        sb.append((char) (v + 'A'));
        if (edge[0] != '.') {
            preorder(edge[0] - 'A');
        }
        if (edge[1] != '.') {
            preorder(edge[1] - 'A');
        }
    }

    public static void inorder(int v) {
        char[] edge = graph.get(v).get(0);
        if (edge[0] != '.') {
            inorder(edge[0] - 'A');
        }
        sb.append((char) (v + 'A'));
        if (edge[1] != '.') {
            inorder(edge[1] - 'A');
        }
    }

    public static void postorder(int v) {
        char[] edge = graph.get(v).get(0);
        if (edge[0] != '.') {
            postorder(edge[0] - 'A');
        }
        if (edge[1] != '.') {
            postorder(edge[1] - 'A');
        }
        sb.append((char) (v + 'A'));
    }
}
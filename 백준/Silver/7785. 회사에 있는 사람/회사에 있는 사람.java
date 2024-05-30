import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TreeSet<String> ts = new TreeSet<>((s1, s2) -> s2.compareTo(s1));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if (st.nextToken().equals("enter")) ts.add(name);
            else ts.remove(name);
        }
        StringBuilder sb = new StringBuilder();
        for (String name : ts)
            sb.append(name).append("\n");
        System.out.println(sb);
    }
}
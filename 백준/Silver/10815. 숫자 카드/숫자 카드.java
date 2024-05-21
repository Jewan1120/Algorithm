import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> hs = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (; n > 0; n--) {
            hs.add(Integer.parseInt(st.nextToken()));
        }
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (; n > 0; n--) {
            sb.append(hs.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append(" ");
        }
        System.out.println(sb);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> hs = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        hs.add("ChongChong");
        while (n-- > 0) {
            StringTokenizer sb = new StringTokenizer(br.readLine());
            String p1 = sb.nextToken();
            String p2 = sb.nextToken();
            if (hs.contains(p1)) {
                hs.add(p2);
            }
            if (hs.contains(p2)) {
                hs.add(p1);
            }
        }
        System.out.println(hs.size());
    }
}
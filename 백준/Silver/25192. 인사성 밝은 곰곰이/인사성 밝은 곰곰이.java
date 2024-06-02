import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashSet<String> hs = new HashSet<>();;
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (n-- > 0) {
            String str = br.readLine();
            if (str.equals("ENTER")) {
                cnt += hs.size();
                hs = new HashSet<>();
            } else {
                hs.add(str);
            }
        }
        System.out.println(cnt + hs.size());
    }
}
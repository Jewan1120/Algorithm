import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
public class Main {
    public static void main(String[] arge) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        int len = arr.length;
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < len; j++) {
                sb.append(arr[j]);
                hs.add(sb.toString());
            }
        }
        System.out.println(hs.size());
    }
}
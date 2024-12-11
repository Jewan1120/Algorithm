import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> tm = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String ext = br.readLine().split("\\.")[1];
            tm.put(ext, tm.getOrDefault(ext, 0) + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (String ext : tm.keySet())
            sb.append(ext).append(" ").append(tm.get(ext)).append("\n");
        System.out.println(sb);
    }
}
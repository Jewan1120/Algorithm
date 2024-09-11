import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> hm = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            hm.put(st.nextToken(), i);
        int cnt = 0;
        String[] arr = br.readLine().split(" ");
        for (int i = 0; i < n - 1; i++)
            for (int j = i + 1; j < n; j++)
                if (hm.get(arr[i]) < hm.get(arr[j]))
                    cnt++;
        System.out.println(cnt + "/" + n * (n - 1) / 2);
    }
}
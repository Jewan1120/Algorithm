import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[] ranks = arr.clone();
        Arrays.sort(ranks);
        int rank = 0;
        for (int i : ranks) {
            if (!hm.containsKey(i)) {
                hm.put(i, rank++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(hm.get(i)).append(" ");
        }
        System.out.println(sb.toString());
    }
}
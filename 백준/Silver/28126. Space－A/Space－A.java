import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String oper = br.readLine();
        int[] operCnt = new int[3];
        for (int i = 0; i < n; i++) {
            int idx = 0;
            if (oper.charAt(i) == 'U')
                idx = 1;
            else if (oper.charAt(i) == 'X')
                idx = 2;
            operCnt[idx]++;
        }
        int k = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int u = Integer.parseInt(st.nextToken()) - 1;
            int x = Math.min(operCnt[2], Math.min(r, u));
            if (operCnt[0] >= r - x && operCnt[1] >= u - x) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
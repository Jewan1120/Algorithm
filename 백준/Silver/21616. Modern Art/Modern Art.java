import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] mArr = new int[m + 1];
        int[] nArr = new int[n + 1];
        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            int p = Integer.parseInt(st.nextToken());
            if (oper.equals("R"))
                mArr[p]++;
            else
                nArr[p]++;
        }
        int cnt = 0;
        for (int i = 1; i < m + 1; i++)
            for (int j = 1; j < n + 1; j++)
                if ((mArr[i] + nArr[j]) % 2 == 1)
                    cnt++;
        System.out.println(cnt);
    }
}
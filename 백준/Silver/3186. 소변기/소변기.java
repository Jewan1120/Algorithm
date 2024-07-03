import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        boolean useFlg = false;
        int useTime = 0, startTime = 0, timer = 0;
        for (int i = 0; i < n; i++) {
            if (!useFlg) {
                if (arr[i] == '1') {
                    timer++;
                    if (timer == k) {
                        useFlg = true;
                        startTime = i + 1;
                        timer = 0;
                    }
                } else {
                    timer = 0;
                }
            } else { 
                if (arr[i] == '1')
                    timer = 0;
                else
                    timer++;
                useTime++;
                if (timer == l) {
                    sb.append(startTime + useTime).append("\n");
                    useFlg = false;
                    useTime = 0;
                    timer = 0;
                }
            }
        }
        if (useFlg)
            sb.append(startTime + useTime + (l - timer));
        System.out.println(sb.length() != 0 ? sb : "NIKAD");
    }
}
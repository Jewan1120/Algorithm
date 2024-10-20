import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        String str = br.readLine();
        ArrayList<Integer> rArr = new ArrayList<>();
        ArrayList<Integer> bArr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c == 'R')
                rArr.add(i);
            if (c == 'B')
                bArr.add(i);
        }
        StringBuilder sb = new StringBuilder();
        while (q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int a = 0, b = 0, c = 0, d = 0;
            a = binarySearch(s, e, rArr);
            b = binarySearch(a + 1, e, rArr);
            c = binarySearch(b + 1, e, bArr);
            d = binarySearch(c + 1, e, bArr);
            if (a == -1 || b == -1 || c == -1 || d == -1)
                sb.append(-1).append("\n");
            else
                sb.append(a).append(" ").append(b).append(" ").append(c).append(" ").append(d).append("\n");
        }
        System.out.println(sb);
    }

    private static int binarySearch(int s, int e, ArrayList<Integer> arr) {
        int l = 0, r = arr.size() - 1;
        int answer = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            int idx = arr.get(m);
            if (s <= idx && idx <= e) {
                answer = idx;
                r = m - 1;
            } else if (idx < s) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return answer;
    }
}
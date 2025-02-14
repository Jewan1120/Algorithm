import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    static final long BASE = 131L;

    static int n;
    static int[] iArr, pArr, possible;
    static long[] prefix, power;
    static String[] strArr;
    static HashMap<String, Integer> sHm = new HashMap<>();
    static HashMap<Integer, Integer> iHm = new HashMap<>();
    static HashSet<Integer> hs = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        strArr = br.readLine().split(" ");
        init();
        if (sHm.size() == n) {
            System.out.println(-1);
            return;
        }
        int maxLen = 0, maxCnt = 0;
        int strL = 0;
        for (int i = 0; i < n; i++) {
            if (pArr[i] == -1)
                continue;
            int s = pArr[i];
            int len = i - s;
            if (possible[s] < len)
                continue;
            int cnt = 2;
            while (i + (cnt - 2) * len + len <= n) {
                long hBlock = getHash(s, s + len - 1);
                long hNext = getHash(i + (cnt - 2) * len, i + (cnt - 2) * len + len - 1);
                if (hBlock == hNext)
                    cnt++;
                else
                    break;
            }
            cnt--;
            if (cnt > 1) {
                if (cnt > maxCnt || (cnt == maxCnt && s < strL)) {
                    maxCnt = cnt;
                    maxLen = len;
                    strL = s;
                }
            }
        }
        if (maxCnt == 0) {
            System.out.println(-1);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(maxLen).append(" ").append(maxCnt).append("\n").append(toString(strL, strL + maxLen));
        System.out.println(sb);
    }

    private static void init() {
        int value = 1;
        iArr = new int[n];
        for (int i = 0; i < n; i++) {
            String key = strArr[i];
            if (!sHm.containsKey(key))
                sHm.put(key, value++);
            iArr[i] = sHm.get(key);
        }

        pArr = new int[n];
        for (int i = 0; i < n; i++) {
            if (iHm.containsKey(iArr[i]))
                pArr[i] = iHm.get(iArr[i]);
            else
                pArr[i] = -1;
            iHm.put(iArr[i], i);
        }

        prefix = new long[n];
        power = new long[n];
        prefix[0] = iArr[0];
        power[0] = 1;
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] * BASE + iArr[i];
            power[i] = power[i - 1] * BASE;
        }

        possible = new int[n];
        int l = 0, r = 0;
        while (l < n) {
            while (r < n && !hs.contains(iArr[r]))
                hs.add(iArr[r++]);
            possible[l] = hs.size();
            hs.remove(iArr[l++]);
        }
    }

    private static String toString(int l, int r) {
        StringBuilder sb = new StringBuilder();
        for (int i = l; i < r; i++)
            sb.append(strArr[i]).append(" ");
        return sb.toString();
    }

    private static long getHash(int l, int r) {
        return l == 0 ? prefix[r] : prefix[r] - prefix[l - 1] * power[r - l + 1];
    }
}
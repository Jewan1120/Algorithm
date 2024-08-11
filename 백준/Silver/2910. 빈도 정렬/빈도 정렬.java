import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read(), c = read();
        HashMap<Integer, int[]> hm = new HashMap<>();
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int p = read();
            hm.putIfAbsent(p, new int[] { ++idx, 0 });
            hm.get(p)[1]++;
        }
        ArrayList<Integer> al = new ArrayList<>(hm.keySet());
        al.sort((o1, o2) -> hm.get(o2)[1] == hm.get(o1)[1] ? hm.get(o1)[0] - hm.get(o2)[0]
                : hm.get(o2)[1] - hm.get(o1)[1]);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < hm.size(); i++) {
            int cnt = hm.get(al.get(i))[1];
            for (int j = 0; j < cnt; j++) {
                sb.append(al.get(i)).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
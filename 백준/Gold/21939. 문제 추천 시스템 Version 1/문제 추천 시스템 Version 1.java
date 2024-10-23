import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {

    static class Problem {
        int num, level;

        Problem(int num, int level) {
            this.num = num;
            this.level = level;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        TreeSet<Problem> ts = new TreeSet<>((o1, o2) -> o1.level != o2.level ? o1.level - o2.level : o1.num - o2.num);
        HashMap<Integer, Integer> hm = new HashMap<>();
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            Problem problem = new Problem(p, l);
            ts.add(problem);
            hm.put(p, l);
        }
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            int p = Integer.parseInt(st.nextToken());
            int l;
            switch (oper) {
            case "recommend":
                if (p == 1)
                    sb.append(ts.last().num);
                else
                    sb.append(ts.first().num);
                sb.append("\n");
                break;
            case "add":
                l = Integer.parseInt(st.nextToken());
                ts.add(new Problem(p, l));
                hm.put(p, l);
                break;
            case "solved":
                l = hm.get(p);
                Problem problem = new Problem(p, l);
                ts.remove(problem);
                hm.remove(p);
                break;
            }
        }
        System.out.println(sb);
    }
}
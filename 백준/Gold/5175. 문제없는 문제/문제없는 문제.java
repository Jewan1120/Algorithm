import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 0
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int[] problemMask = new int[N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int mask = 0;
                while (st.hasMoreTokens()) {
                    int algo = Integer.parseInt(st.nextToken()) - 1;
                    mask |= (1 << algo);
                }
                problemMask[i] = mask;
            }

            int targetMask = (1 << M) - 1;

            int minProblemCount = N + 1;
            List<Integer> bestSet = null;

            for (int subset = 1; subset < (1 << N); subset++) {
                int currentMask = 0;
                List<Integer> currentSet = new ArrayList<>();

                for (int i = 0; i < N; i++) {
                    if ((subset & (1 << i)) != 0) {
                        currentMask |= problemMask[i];
                        currentSet.add(i + 1);
                    }
                }

                if (currentMask == targetMask) {
                    if (currentSet.size() < minProblemCount) {
                        minProblemCount = currentSet.size();
                        bestSet = currentSet;
                    } else if (currentSet.size() == minProblemCount) {
                        if (compareSets(currentSet, bestSet) < 0) {
                            bestSet = currentSet;
                        }
                    }
                }
            }
            sb.append("Data Set ").append(t).append(": ").append(toProblemSetString(bestSet)).append("\n");
            if (t < T)
                sb.append("\n");
        }
        System.out.println(sb);
    }

    static int compareSets(List<Integer> set1, List<Integer> set2) {
        for (int i = 0; i < Math.min(set1.size(), set2.size()); i++) {
            if (!set1.get(i).equals(set2.get(i))) {
                return set1.get(i) - set2.get(i);
            }
        }
        return set1.size() - set2.size();
    }

    static String toProblemSetString(List<Integer> set) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < set.size(); i++) {
            sb.append((char) ('A' + set.get(i) - 1));
            if (i < set.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
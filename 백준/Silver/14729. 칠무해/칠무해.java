import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] bs = new double[8];
        Arrays.fill(bs, 100);
        for (int i = 0; i < n; i++) {
            double num = Double.parseDouble(br.readLine());
            int idx = Arrays.binarySearch(bs, 0, 7, num);
            if (idx < 0) {
                idx = -(idx + 1);
            }
            if (idx < 7) {
                for (int j = 6; j > idx; j--) {
                    bs[j] = bs[j - 1];
                }
            }
            bs[idx] = num;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            sb.append(String.format("%.3f", bs[i])).append("\n");
        }
        System.out.println(sb);
    }
}
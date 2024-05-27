import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        float total = 0;
        float scoreSum = 0;
        for (int i = 0; i < 20; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            st.nextToken();
            float score = Float.parseFloat(st.nextToken());
            String grade = st.nextToken();
            float g = 'E' - grade.charAt(0);
            if (g != -11) {
                if (g > 0) {
                    if (grade.charAt(1) == '+') {
                        g += 0.5;
                    }
                    total += score * g;
                }
                scoreSum += score;
            }
        }
        System.out.println(total / scoreSum);
    }
}
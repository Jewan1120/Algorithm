import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String[] weeks = {"Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s1 = strToInt(br.readLine()), s2 = strToInt(br.readLine());
        int n1 = strToInt(br.readLine()), n2 = strToInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 1440; i++) {
            if (s1 == s2) {
                System.out.println(weeks[(s1 / 1440) % 7]);
                System.out.printf("%02d:%02d", (s1 / 60) % 24, s1 % 60);
                return;
            } else {
                s1 = s1 < s2 ? s1 + n1 : s1;
                s2 = s2 < s1 ? s2 + n2 : s2;
            }
        }
        System.out.println("Never");
    }

    private static int strToInt(String str) {
        StringTokenizer st = new StringTokenizer(str, ":");
        return Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());
    }
}
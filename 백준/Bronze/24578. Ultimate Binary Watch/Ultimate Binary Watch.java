import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] strArr = new String[4][5];
        int num = Integer.parseInt(br.readLine());
        for (int i = 4; i >= 0; i--) {
            if (i == 2) {
                for (int j = 0; j < 4; j++)
                    strArr[j][i] = " ";
                continue;
            }
            int p = num % 10;
            num /= 10;
            for (int j = 0; j < 4; j++) {
                String str = ".";
                if (((p >> j) & 1) == 1)
                    str = "*";
                strArr[3 - j][i] = str;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++)
            sb.append(String.join(" ", strArr[i])).append("\n");
        sb.append(String.join(" ", strArr[3]));
        System.out.println(sb);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = "";
        while (!(str = br.readLine()).equals("R0C0")) {
            String[] strArr = str.split("[RC]");
            sb.append(convert(strArr[2])).append(strArr[1]).append("\n");
        }
        System.out.println(sb);
    }

    private static String convert(String str) {
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(str);
        while (num > 0) {
            num--;
            sb.append((char) (num % 26 + 'A'));
            num /= 26;
        }
        return sb.reverse().toString();
    }
}
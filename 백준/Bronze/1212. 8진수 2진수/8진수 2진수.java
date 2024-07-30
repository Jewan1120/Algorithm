import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] arr = {"000", "001", "010", "011", "100", "101", "110", "111"};
        String str = br.readLine();
        if (str.equals("0")) {
            System.out.println(0);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            sb.append(arr[str.charAt(i) - '0']);
        }
        while (sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        System.out.println(sb);
    }
}
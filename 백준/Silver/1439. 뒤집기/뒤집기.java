import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int zero = str.split("0+").length;
        int one = str.split("1+").length;
        if (str.charAt(0) == '0')
            zero--;
        else
            one--;
        System.out.println(Math.max(Math.min(zero, one), 0));
    }
}
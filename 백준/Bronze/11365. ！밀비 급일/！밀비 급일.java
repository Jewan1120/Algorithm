import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        while (!(str = br.readLine()).equals("END"))
            sb.append(new StringBuilder(str).reverse()).append("\n");
        System.out.println(sb);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        StringBuilder sb = new StringBuilder();
        int idx = 0;
        while (!(str = br.readLine()).equals("0"))
            sb.append("Case ").append(++idx).append(": Sorting... done!").append("\n");
        System.out.println(sb);
    }
}
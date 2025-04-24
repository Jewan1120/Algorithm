import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        double s1 = Double.parseDouble(st.nextToken());
        double s2 = Double.parseDouble(st.nextToken());

        if (s1 >= s2 / 2)
            System.out.println("E");
        else
            System.out.println("H");
    }
}
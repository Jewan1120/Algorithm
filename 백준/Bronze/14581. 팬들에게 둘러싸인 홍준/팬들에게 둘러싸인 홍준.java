import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.printf(":fan::fan::fan:\n"
                + ":fan::%s::fan:\n"
                + ":fan::fan::fan:", br.readLine());
    }
}
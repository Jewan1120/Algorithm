import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder str = new StringBuilder();
        str.append("  ___  ___  ___\n");
        str.append("  | |__| |__| |\n");
        str.append("  |           |\n");
        str.append("   \\_________/\n");
        str.append("    \\_______/\n");
        str.append("     |     |\n");
        str.append("     |     |\n");
        str.append("     |     |\n");
        str.append("     |     |\n");
        str.append("     |_____|\n");
        str.append("  __/       \\__\n");
        str.append(" /             \\\n");
        str.append("/_______________\\");

        System.out.println(str.toString());
        br.close();
    }
}
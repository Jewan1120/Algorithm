import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] time = br.readLine().split(" ");
        int min = (Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]) + Integer.parseInt(br.readLine())) % 1440;
        StringBuilder sb = new StringBuilder();
        sb.append(min / 60).append(" ").append(min % 60);
        System.out.println(sb.toString());
    }
}
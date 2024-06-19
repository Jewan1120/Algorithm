import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double[] score = new double[n];
        for(int i = 0; i <n ;i++) {
            score[i] = Double.parseDouble(br.readLine());
        }
        Arrays.sort(score);
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < 7; i ++) {
            sb.append(String.format("%.3f", score[i])).append("\n");
        }
        System.out.println(sb);
    }
}
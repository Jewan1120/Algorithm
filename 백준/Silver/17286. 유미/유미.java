import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[4][2];
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        double[][] len = new double[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == j) continue;
                len[i][j] = Math.sqrt(Math.pow(arr[i][0] - arr[j][0], 2) + Math.pow(arr[i][1] - arr[j][1], 2));
            }
        }
        double min = 100_001;
        for (int i = 1; i < 4; i++) {
            boolean[] visited = new boolean[4];
            double sum = len[0][i];
            visited[i] = true;
            for (int j = 1; j < 4; j++) {
                if (!visited[j]) {
                    sum += len[i][j];
                    visited[j] = true;
                    for (int k = 1; k < 4; k++) {
                        if (!visited[k]) {
                            sum += len[j][k];
                            min = Math.min(min, sum);
                            sum -= len[j][k];
                        }
                    }
                    sum -= len[i][j];
                    visited[j] = false;
                }
            }
        }
        System.out.println((int) min);
    }
}
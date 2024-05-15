import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] arr = new int[3][2];
        StringTokenizer st;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        if (dir(arr[0], arr[1]) != dir(arr[0], arr[2]))
            System.out.println("WINNER WINNER CHICKEN DINNER!");
        else
            System.out.println("WHERE IS MY CHICKEN?");
    }
    
    public static float dir(int[] p1, int[] p2) {
        if (p1[0] == p2[0]) return 0;
        if (p1[1] == p2[1]) return 1;
        return (float) (p1[1] - p2[1]) / (p1[0] - p2[0]);
    }
}
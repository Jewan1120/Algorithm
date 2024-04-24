import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;
    static int idx;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int d = Integer.parseInt(st.nextToken());
        arr = new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
        idx = 0;
        find(0, 0, d);
        System.out.println(idx);
    }

    public static void find(int y, int x, int d) {
        if (arr[0] == y && arr[1] == x) {
            return;
        }
        int len = (int) Math.pow(2, d);
        int mid = len / 2, dy = y + mid, dx = x + mid;
        int k = 0;
        if (arr[0] >= dy) {
            y = dy;
            k += 2;
        }
        if (arr[1] >= dx) {
            x = dx;
            k += 1;
        }
        idx += k * (int) Math.pow(mid, 2);
        find(y, x, d - 1);
    }
}
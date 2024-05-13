import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())};
        Arrays.sort(arr);
        if (arr[2] * arr[2] == arr[1] * arr[1] + arr[0] * arr[0]) {
            System.out.println(1);
        } else if (arr[0] == arr[1] && arr[0] == arr[2]) {
            System.out.println(2);
        } else {
            System.out.println(0);
        }
    }
}

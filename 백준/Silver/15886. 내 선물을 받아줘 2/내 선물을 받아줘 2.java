import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();
        int cnt = 0;
        for (int i = 0; i < arr.length - 1; i++)
            if (arr[i] == 'E' && arr[i + 1] == 'W')
                cnt++;
        System.out.println(cnt);
    }
}
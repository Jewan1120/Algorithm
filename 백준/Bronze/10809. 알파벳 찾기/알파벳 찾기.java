import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[26];
        Arrays.fill(arr, -1);
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            int idx = str.charAt(i) - 'a';
            if (arr[idx] == -1) {
                arr[idx] = i;
            }
        }
        for (int i : arr) {
            bw.write(i + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine().toUpperCase();
        int[][] arr = new int[26][2];
        int len = str.length();
        while (len > 0) {
            char c = str.charAt(0);
            int idx = c - 'A';
            str = str.replace(Character.toString(c), "");
            arr[idx][0] = c;
            arr[idx][1] = len - str.length();
            len = str.length();
        }
        Arrays.sort(arr, (o1, o2) -> o2[1] - o1[1]);
        if (arr[0][1] != arr[1][1]){
            bw.write(Character.toString((char) arr[0][0]));
        } else {
            bw.write("?");
        }
        bw.flush();
        bw.close();
    }
}
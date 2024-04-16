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
        int[] arr = new int[3];
        String str;
        while ((str = br.readLine()) != null) {
            if (str.equals("0 0 0")) break;
            String[] strToken = str.split(" ");
            arr[0] = Integer.parseInt(strToken[0]);
            arr[1] = Integer.parseInt(strToken[1]);
            arr[2] = Integer.parseInt(strToken[2]);
            Arrays.sort(arr);
            if (Math.pow(arr[2], 2) == Math.pow(arr[0], 2) + Math.pow(arr[1], 2)) {
                bw.write("right");
            } else {
                bw.write("wrong");
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
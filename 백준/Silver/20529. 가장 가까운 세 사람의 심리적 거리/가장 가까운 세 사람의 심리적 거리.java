import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            if (n > 32) {
                br.readLine();
                bw.write("0\n");
            } else {
                String[] strArr = br.readLine().split(" ");
                int min = 100_001;
                for (int j = 0; j < n - 2; j++) {
                    for (int k = j + 1; k < n - 1; k++) {
                        for (int l = k + 1; l < n; l++) {
                            int sum = 0;
                            for (int m = 0; m < 4; m++) {
                                if (strArr[j].charAt(m) != strArr[k].charAt(m)) {
                                    sum++;
                                }
                                if (strArr[j].charAt(m) != strArr[l].charAt(m)) {
                                    sum++;
                                }
                                if (strArr[k].charAt(m) != strArr[l].charAt(m)) {
                                    sum++;
                                }
                            }
                            min = Math.min(min, sum);
                        }
                    }
                }
                bw.write(min + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
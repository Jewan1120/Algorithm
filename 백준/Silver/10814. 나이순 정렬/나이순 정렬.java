import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        String[][] strArr = new String[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            strArr[i][0] = String.valueOf(i);
            strArr[i][1] = st.nextToken();
            strArr[i][2] = st.nextToken();
        }
        Arrays.sort(strArr,
                (o1, o2) -> o1[1].equals(o2[1]) ? Integer.parseInt(o1[0]) - Integer.parseInt(o2[0])
                        : Integer.parseInt(o1[1]) - Integer.parseInt(o2[1]));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            bw.write(strArr[i][1]);
            bw.write(" ");
            bw.write(strArr[i][2]);
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
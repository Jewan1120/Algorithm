import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<String> stk = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (; n > 0; n--) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            char c = command.charAt(0);
            if (command.equals("push")) {
                stk.push(st.nextToken());
            } else if (stk.size() == 0) {
                if (c == 'p' || c == 't') {
                    bw.write("-1\n");
                } else if (c == 's') {
                    bw.write("0\n");
                } else {
                    bw.write("1\n");
                }
            } else {
                if (c == 'p') {
                    bw.write(stk.pop()+ "\n");
                } else if (c == 't') {
                    bw.write(stk.peek() + "\n");
                } else if (c == 's') {
                    bw.write(stk.size() + "\n");
                } else {
                    bw.write("0\n");
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
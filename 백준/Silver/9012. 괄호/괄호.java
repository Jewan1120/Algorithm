import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        for (; n > 0; n--) {
            String str = br.readLine();
            Stack<Character> stk = new Stack<>();
            for (char c : str.toCharArray()) {
                if (stk.isEmpty()) {
                    stk.push(c);
                } else {
                    if (stk.peek() == '(' && c == ')') {
                        stk.pop();
                    } else {
                        stk.push(c);
                    }
                }
            }
            if (stk.size() == 0) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
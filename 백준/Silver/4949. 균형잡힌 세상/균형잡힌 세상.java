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
        String str;
        while (!(str = br.readLine()).equals(".")) {
            str = str.replaceAll("[^()\\[\\]]", "");
            Stack<Character> stk = new Stack<>();
            for (char c : str.toCharArray()) {
                if (stk.isEmpty()) {
                    stk.push(c);
                } else {
                    if (stk.peek() == '[' && c == ']' || stk.peek() == '(' && c == ')') {
                        stk.pop();
                    } else {
                        stk.push(c);
                    }
                }
            }
            if (stk.size() == 0) {
                bw.write("yes\n");
            } else {
                bw.write("no\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
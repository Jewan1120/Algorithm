import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));   
        char[] cArr = br.readLine().toCharArray();
        Stack<String> stk = new Stack<>();
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] == ')') {
                int cnt = 0;
                while (!stk.peek().equals("(")) {
                    String str = stk.pop();
                    if (str.equals("*"))
                        cnt += Integer.parseInt(stk.pop());
                    else
                        cnt++;
                }
                stk.pop();
                cnt *= Integer.parseInt(stk.pop());
                stk.push(String.valueOf(cnt));
                stk.push("*");
            } else
                stk.push(String.valueOf(cArr[i]));
        }
        int cnt = 0;
        while (!stk.isEmpty()) {
            String str = stk.pop();
            if (str.equals("*"))
                cnt += Integer.parseInt(stk.pop());
            else
                cnt++;
        }
        System.out.println(cnt);
    }
}
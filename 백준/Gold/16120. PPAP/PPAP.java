import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Stack<Character> stk = new Stack<>();
        int pCnt = 0;
        boolean flg = false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == 'P') {
                if (flg) {
                    pCnt--;
                    stk.pop();
                    stk.pop();
                } else {
                    pCnt++;
                    stk.push(c);
                }
                flg = false;
            } else {
                if (!flg) {
                    if (pCnt >= 2) {
                        flg = true;
                    } else {
                        pCnt = 0;
                    }
                } else {
                    flg = false;
                    pCnt = 0;
                }
                stk.push(c);
            }
        }
        System.out.println(pCnt == 1 && stk.size() == 1 ? "PPAP" : "NP");
    }
}
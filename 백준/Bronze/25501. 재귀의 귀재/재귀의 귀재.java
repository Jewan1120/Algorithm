import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main {
    static int cnt;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (n-- > 0) {
            char[] cArr = br.readLine().toCharArray();
            cnt = 0;
            sb.append(isPalindrome(cArr)).append(" ").append(cnt).append("\n");
        }
        System.out.println(sb);
    }
    private static int isPalindrome(char[] cArr) {
        return recursion(cArr, 0, cArr.length - 1);   
    }
    private static int recursion(char[] cArr, int l, int r) {
        cnt++;
        if (l >= r) return 1;
        else if (cArr[l] != cArr[r]) return 0;
        else return recursion(cArr, l + 1, r - 1);
    }
    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
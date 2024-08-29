import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<BigInteger> fibo = new ArrayList<>();
        fibo.add(BigInteger.ONE);
        fibo.add(BigInteger.TWO);
        while (true) {
            BigInteger next = fibo.get(fibo.size() - 1).add(fibo.get(fibo.size() - 2));
            if (next.compareTo(BigInteger.TEN.pow(101)) > 0) {
                break;
            }
            fibo.add(next);
        }
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger A = new BigInteger(st.nextToken());
            BigInteger B = new BigInteger(st.nextToken());
            if (A.equals(BigInteger.ZERO) && B.equals(BigInteger.ZERO))
                break;
            int cnt = 0;
            for (BigInteger bi : fibo) {
                if (bi.compareTo(A) >= 0 && bi.compareTo(B) <= 0)
                    cnt++;
                if (bi.compareTo(B) > 0)
                    break;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
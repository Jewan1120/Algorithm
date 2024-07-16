import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws Exception {
        int n = read();
        StringBuilder sb = new StringBuilder();
        boolean[] isPrime = new boolean[n + 1];
        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i * i <= n; i++)
            if (!isPrime[i])
                for (int j = i * i; j <= n; j += i)
                    isPrime[j] = true;
        for (int i = 1; i <= n; i++) {
            if (!isPrime[i]) {
                boolean flg = false;
                Set<Integer> hs = new HashSet<>();
                int num = i;
                while (!hs.contains(num)) {
                    if (num == 1) {
                        flg = true;
                        break;
                    }
                    hs.add(num);
                    int temp = 0;
                    int len = (int) Math.log10(num) + 1;
                    while (len-- > 0) {
                        temp += Math.pow(num % 10, 2);
                        num /= 10;
                    }
                    num = temp;
                }
                if (flg)
                    sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int read() throws Exception {
        int c, n = System.in.read() & 15;
        while ((c = System.in.read()) >= 48)
            n = (n << 3) + (n << 1) + (c & 15);
        return n;
    }
}
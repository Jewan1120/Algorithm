import java.io.BufferedReader;
import java.io.InputStreamReader;

// 0
public class Main {

    static long[] lengths = new long[100];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long M = Long.parseLong(br.readLine());

        lengths[1] = 5;
        lengths[2] = 13;

        int N = 2;
        for (int i = 3; i < 100; i++) {
            lengths[i] = lengths[i - 1] + 1 + lengths[i - 2];
            if (lengths[i] >= M) {  
                N = i; 
                break;
            }
        }

        String result = findCharacter(M, N);
        System.out.println(result);
    }

    static String findCharacter(long M, int N) {
        if (N == 1) {
            if (M <= 5)
                return "Messi".substring((int) M - 1, (int) M);
        }
        if (N == 2) {
            if (M <= 13) {
                if (M <= 5)
                    return "Messi".substring((int) M - 1, (int) M);
                else if (M == 6)
                    return "Messi Messi Gimossi";
                else
                    return "Gimossi".substring((int) M - 7, (int) M - 6);
            }
        }

        if (M <= lengths[N - 1]) {
            return findCharacter(M, N - 1);
        } else if (M == lengths[N - 1] + 1) {
            return "Messi Messi Gimossi";
        } else {
            return findCharacter(M - lengths[N - 1] - 1, N - 2);
        }
    }
}
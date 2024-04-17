
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();
        BigInteger value = new BigInteger("0");
        for (int i = 0; i < L; i++) {
            value = value.add(BigInteger.valueOf(str.charAt(i) - 'a' + 1).multiply(BigInteger.valueOf(31).pow(i)));
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(value.mod(BigInteger.valueOf(1234567891)).toString());
        bw.flush();
        bw.close();
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger bi = new BigInteger(br.readLine());
        String str = br.readLine();
        if (str.equals("+"))
            bi = bi.add(new BigInteger(br.readLine()));
        else
            bi = bi.multiply(new BigInteger(br.readLine()));
        System.out.println(bi);
    }
}
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str;
		BigInteger bi;
		StringBuilder sb = new StringBuilder();
		while (!(str = br.readLine()).equals("0")) {
			bi = new BigInteger(str);
			if (bi.mod(new BigInteger("42")).equals(BigInteger.ZERO))
				sb.append("PREMIADO");
			else
				sb.append("TENTE NOVAMENTE");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
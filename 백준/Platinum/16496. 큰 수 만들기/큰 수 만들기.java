import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");
        Arrays.sort(arr, (o1, o2) -> new BigInteger(o2 + o1).compareTo(new BigInteger(o1 + o2)));
        StringBuilder sb = new StringBuilder();
        for (String str : arr)
            sb.append(str);
        System.out.println(sb.charAt(0) == '0' ? "0" : sb.toString());
    }
}
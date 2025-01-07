import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> hm = new HashMap<>();
        hm.put("NLCS", "North London Collegiate School");
        hm.put("BHA", "Branksome Hall Asia");
        hm.put("KIS", "Korea International School");
        hm.put("SJA", "St. Johnsbury Academy");
        System.out.println(hm.get(br.readLine()));
    }
}
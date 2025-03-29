import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<String, String> hm = new HashMap<>();
		hm.put("Algorithm", "204");
		hm.put("DataAnalysis", "207");
		hm.put("ArtificialIntelligence", "302");
		hm.put("CyberSecurity", "B101");
		hm.put("Network", "303");
		hm.put("Startup", "501");
		hm.put("TestStrategy", "105");
		StringBuilder sb = new StringBuilder();
		while (n-- > 0)
			sb.append(hm.get(br.readLine())).append("\n");
		System.out.println(sb);
	}
}
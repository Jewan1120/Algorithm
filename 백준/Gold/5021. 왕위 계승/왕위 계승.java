import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static HashMap<String, String[]> tree = new HashMap<>();
    static HashMap<String, Double> bloodMap = new HashMap<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String root = br.readLine();
        bloodMap.put(root, 1D);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String child = st.nextToken();
            String parent1 = st.nextToken();
            String parent2 = st.nextToken();
            tree.put(child, new String[] { parent1, parent2 });
            bloodMap.put(child, 0D);
            bloodMap.putIfAbsent(parent1, 0D);
            bloodMap.putIfAbsent(parent2, 0D);
        }
        String answer = "";
        double maxBlood = 0;
        while (m-- > 0) {
            String name = br.readLine();
            double blood = recursive(name);
            if (blood > maxBlood) {
                answer = name;
                maxBlood = blood;
            }
        }
        System.out.println(answer);
    }

    private static double recursive(String person) {
        if (bloodMap.containsKey(person) && bloodMap.get(person) > 0) {
            return bloodMap.get(person);
        }
        if (!tree.containsKey(person)) {
            return 0;
        }
        String[] parents = tree.get(person);
        double parent1Blood = recursive(parents[0]) / 2.0;
        double parent2Blood = recursive(parents[1]) / 2.0;
        double personBlood = parent1Blood + parent2Blood;
        bloodMap.replace(person, personBlood);
        return personBlood;
    }
}
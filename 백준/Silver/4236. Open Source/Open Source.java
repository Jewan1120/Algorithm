import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";
        String projectName = "";
        HashMap<String, HashSet<String>> project = new HashMap<>();
        HashSet<String> check = new HashSet<>();
        while (!(str = br.readLine()).equals("0")) {
            if (str.equals("1")) {
                System.out.println(print(project, check));
                project = new HashMap<>();
                check = new HashSet<>();
                continue;
            }
            if (Character.isUpperCase(str.charAt(0))) {
                projectName = str;
                project.put(projectName, new HashSet<>());
            } else {
                for (String key : project.keySet()) {
                    if (projectName.equals(key))
                        continue;
                    if (project.get(key).contains(str))
                        check.add(str);
                }
                project.get(projectName).add(str);
            }
        }
    }

    private static String print(HashMap<String, HashSet<String>> project, HashSet<String> check) {
        StringBuilder sb = new StringBuilder();
        for (String key : project.keySet()) {
            for (String checkStr : check) {
                if (project.get(key).contains(checkStr))
                    project.get(key).remove(checkStr);
            }
        }
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> project.get(o2).size() != project.get(o1).size()
                ? project.get(o2).size() - project.get(o1).size()
                : o1.compareTo(o2));
        for (String key : project.keySet()) {
            pq.offer(key);
        }
        int size = pq.size();
        for(int i =0; i < size; i++) {
            String projectName = pq.poll();
            sb.append(projectName).append(" ").append(project.get(projectName).size());
            if(i < size - 1)
                sb.append("\n");
        }
        return sb.toString();
    }
}
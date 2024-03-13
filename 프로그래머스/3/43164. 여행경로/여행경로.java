import java.util.TreeMap;
class Solution {
    boolean flg;
    public String[] solution(String[][] tickets) {
        int len = tickets.length + 1;
        String[] answer = new String[len];

        TreeMap<String, TreeMap<String, Integer>> ticketMap = new TreeMap<>();

        for (String[] ticket : tickets) {
            String a = ticket[0];
            String b = ticket[1];
            if (!ticketMap.containsKey(a)) {
                ticketMap.put(a, new TreeMap<>((o1, o2) -> o1.compareTo(o2)));
            }
            TreeMap<String, Integer> fromMap = ticketMap.get(a);
            if (!fromMap.containsKey(b)) {
                fromMap.put(b, 0);
            }
            fromMap.replace(b, fromMap.get(b) + 1);
        }
        answer[0] = "ICN";
        dfs(ticketMap, answer, "ICN", 1);
        return answer;
    }

    public void dfs(TreeMap<String, TreeMap<String, Integer>> ticketMap, String[] answer, String cur,
            int depth) {
        if (depth == answer.length) {
            flg = true;
            return;
        }
        TreeMap<String, Integer> fromMap = ticketMap.get(cur);
        if (fromMap != null) {
            for (String to : fromMap.keySet()) {
                if (fromMap.get(to) > 0) {
                    fromMap.replace(to, fromMap.get(to) - 1);
                    answer[depth] = to;
                    dfs(ticketMap, answer, to, depth + 1);
                    if(flg) return;
                    fromMap.replace(to, fromMap.get(to) + 1);
                }
            }
        }
    }
}
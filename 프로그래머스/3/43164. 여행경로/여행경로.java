import java.util.Map;
import java.util.HashMap;
import java.util.TreeMap;
class Solution {
    public String[] solution(String[][] tickets) {
        int len = tickets.length + 1;
        String[] answer = new String[len];
        Map<String, TreeMap<String, Integer>> ticketMap = buildTicketMap(tickets);
        answer[0] = "ICN";
        dfs(ticketMap, answer, "ICN", 1);
        return answer;
    }

    private Map<String, TreeMap<String, Integer>> buildTicketMap(String[][] tickets) {
        Map<String, TreeMap<String, Integer>> ticketMap = new HashMap<>();
        for (String[] ticket : tickets) {
            String from = ticket[0];
            String to = ticket[1];
            ticketMap.putIfAbsent(from, new TreeMap<>());
            TreeMap<String, Integer> fromMap = ticketMap.get(from);
            fromMap.put(to, fromMap.getOrDefault(to, 0) + 1);
        }
        return ticketMap;
    }

    public boolean dfs(Map<String, TreeMap<String, Integer>> ticketMap, String[] answer, String cur,
            int depth) {
        if (depth == answer.length) {
            return true;
        }
        TreeMap<String, Integer> fromMap = ticketMap.get(cur);
        if (fromMap != null) {
            for (String to : fromMap.keySet()) {
                if (fromMap.get(to) > 0) {
                    fromMap.replace(to, fromMap.get(to) - 1);
                    answer[depth] = to;
                    if (dfs(ticketMap, answer, to, depth + 1)) {
                        return true;
                    }
                    fromMap.replace(to, fromMap.get(to) + 1);
                }
            }
        }
        return false;
    }
}
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;
class Solution {
    public int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        ArrayList<HashSet<String>> bannedArr = new ArrayList<>(banned_id.length);
        for (int i = 0; i < banned_id.length; i++) {
            banned_id[i] = banned_id[i].replace("*", ".");
            bannedArr.add(new HashSet<String>());
        }
        for (String user : user_id) {
            for (int i = 0; i < banned_id.length; i++) {
                if (user.matches(banned_id[i])) {
                    bannedArr.get(i).add(user);
                }
            }
        }
        HashSet<String> usedSet = new HashSet<>();
        Queue<HashSet<String>> usedQue = new ArrayDeque<>();
        Queue<Integer> idxQue = new ArrayDeque<>();
        usedQue.offer(new HashSet<String>());
        idxQue.offer(0);
        while (!usedQue.isEmpty()) {
            HashSet<String> usedHs = usedQue.poll();
            int idx = idxQue.poll();
            if (idx == bannedArr.size()) {
                String[] userArr = usedHs.toArray(new String[0]);
                Arrays.sort(userArr);
                String userStr = String.join("-", userArr);
                if (!usedSet.contains(userStr)) {
                    usedSet.add(userStr);
                    answer++;
                }
                continue;
            }
            HashSet<String> bannedHs = bannedArr.get(idx);
            for (String user : bannedHs) {
                if (!usedHs.contains(user)) {
                    HashSet<String> tmpHs = new HashSet<>();
                    tmpHs.addAll(usedHs);
                    tmpHs.add(user);
                    usedQue.offer(tmpHs);
                    idxQue.offer(idx + 1);
                }
            }
        }
        return answer;
    }
}
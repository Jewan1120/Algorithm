import java.util.HashSet;
class Solution {
    
    int n;
    int len;
    HashSet<Integer> hs = new HashSet<>();
    
    public int solution(String[] user_id, String[] banned_id) {
        n = user_id.length;
        len = banned_id.length;
        for (int i = 0; i < len; i++)
            banned_id[i] = banned_id[i].replace("*", ".");
        recursive(user_id, banned_id, 0, 0);
        return hs.size();
    }

    private void recursive(String[] user_id, String[] banned_id, int depth, int visited) {
        if (depth == len) {
            hs.add(visited);
            return;
        }
        for (int i = 0; i < n; i++) {
            if ((visited & (1 << i)) == 0 && user_id[i].matches(banned_id[depth])) {
                recursive(user_id, banned_id, depth + 1, visited | (1 << i));
            }
        }
    }
}
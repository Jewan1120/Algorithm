import java.util.ArrayList;
class Solution {
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] chk = new boolean[cards.length];
        boolean flg = true;
        ArrayList<ArrayList<Integer>> groups = new ArrayList<>();
        while (flg) {
            int idx = -1;
            ArrayList<Integer> group = new ArrayList<>();
            for (int i = 0; i < chk.length; i++) {
                if (chk[i] == false) {
                    idx = i;
                }
            }
            if (idx == -1) {
                break;
            }
            while (!chk[idx]) {
                group.add(cards[idx]);
                chk[idx] = true;
                idx = cards[idx] - 1;
            }
            groups.add(group);
        }
        groups.sort(((o1, o2) -> o2.size() - o1.size()));
        answer = groups.size() == 1 ? 0 : groups.get(0).size() * groups.get(1).size();
        return answer;
    }
}
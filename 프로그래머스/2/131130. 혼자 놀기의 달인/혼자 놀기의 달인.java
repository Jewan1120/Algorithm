class Solution {
    public int solution(int[] cards) {
        boolean[] visited = new boolean[cards.length];
        int c1 = 0, c2 = 0;
        for (int i = 0; i < cards.length; i++) {
            int cnt = 0;
            if (!visited[i]) {
                visited[i] = true;
                int idx = cards[i] - 1;
                cnt++;
                while (!visited[idx]) {
                    visited[idx] = true;
                    idx = cards[idx] - 1;
                    cnt++;
                }
            }
            if (c1 < cnt) {
                c2 = c1;
                c1 = cnt;
            } else
                c2 = Math.max(c2, cnt);
        }
        return c1 * c2;
    }
}
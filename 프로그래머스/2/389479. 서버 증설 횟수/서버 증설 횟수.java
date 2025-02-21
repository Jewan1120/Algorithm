class Solution {
    public int solution(int[] players, int m, int k) {
        int n = players.length;
        int total = 0;
        for (int i = 0; i < n; i++) {
            int needs = (int) Math.floor((double) players[i] / m);
            if (needs == 0)
                continue;
            total += needs;
            for (int j = 0; j < k && i + j < n; j++)
                players[i + j] = Math.max(0, players[i + j] - m * needs);
        }
        return total;
    }
}
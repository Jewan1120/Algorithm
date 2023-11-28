class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        for (int i = 0; i < d.length - 1; i++) {
            for (int j = 0; j < d.length - i - 1; j++) {
                if (d[j] > d[j + 1]) {
                    int tmp = d[j];
                    d[j] = d[j + 1];
                    d[j + 1] = tmp;
                }
            }
        }
        for (int i : d) {
            budget -= i;
            if (budget < 0) {
                break;
            }
            answer++;
        }
        return answer;
    }
}
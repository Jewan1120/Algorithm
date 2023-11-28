class Solution {
    public int solution(int k, int m, int[] score) {
        int[][] boxing = new int[k][2];
        for (int i = 0; i < boxing.length; i++) {
            boxing[i][0] = boxing.length - i;
        }
        for (int i = 0; i < score.length; i++) {
            for (int j = 0; j < boxing.length; j++) {
                if (score[i] == boxing[j][0]) {
                    boxing[j][1]++;
                }
            }
        }
        int sum = 0;
        int mod = 0;
        for (int i = 0; i < boxing.length; i++) {
            boxing[i][1] += mod;
            sum += (boxing[i][0] * (boxing[i][1] / m));
            mod = boxing[i][1] % m;
        }
        return sum * m;
    }
}
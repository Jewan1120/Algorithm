class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for (int n = i; n <= j; n++) {
            int tmp = n;
            while (tmp > 0) {
                if (tmp % 10 == k) {
                    answer++;
                }
                tmp /= 10;
            }
        }
        return answer;
    }
}
class Solution {
    public int solution(int n) {
        int answer = 0;
        boolean flg = false;
        for (int i = 0; i < n; i++) {
            answer++;
            flg = true;
            while (flg) {
                if (answer % 3 == 0) {
                    answer++;
                } else if (answer % 10 == 3 || answer / 10 % 10 == 3) {
                    answer++;
                } else {
                    flg = false;
                }
            }
        }
        return answer;
    }
}
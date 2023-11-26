class Solution {
    public int solution(int n, int m, int[] section) {
        int painted = 0;
        int answer = 0;
        for (int point : section) {
            if (painted <= point) {
                painted = point + m;
                answer++;
            }
        }
        return answer;
    }
}
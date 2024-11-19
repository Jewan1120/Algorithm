import java.util.Arrays;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        // budget 안에서 많이 나눠주기
        for(int i = 0; i < d.length; i++) {
            if(d[i] <= budget) {
                answer++;
                budget -= d[i];
            } else {
                break;
            }
        }
        return answer;
    }
}
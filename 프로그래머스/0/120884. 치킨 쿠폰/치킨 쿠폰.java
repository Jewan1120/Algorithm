class Solution {
    public int solution(int chicken) {
        int answer = 0;
        while (chicken >= 10) {
            chicken -= 10;
            chicken ++;
            answer ++;
        }
        return answer;
    }
}
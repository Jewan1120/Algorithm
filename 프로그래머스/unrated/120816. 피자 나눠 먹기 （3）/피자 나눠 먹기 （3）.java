class Solution {
    public int solution(int slice, int n) {
        int answer = 1;
        while(answer * slice < n){
            answer++;
        }
        return answer;
    }
}
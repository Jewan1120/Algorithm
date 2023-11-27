class Solution {
    public int solution(int n) {
        int answer = 0;
        for(int i = 3; i <= n; i ++){
            int divisor = 2;
            while(divisor < i){
                if(i % divisor == 0){
                    answer++;
                    break;
                }
                divisor++;
            }
        }
        return answer;
    }
}
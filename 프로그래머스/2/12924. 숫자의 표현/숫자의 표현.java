class Solution {
    public int solution(int n) {
        int answer = 1;
        for(int i = 1; i <= n / 2; i++){
            int tmp = n;
            int j = 0;
            while(tmp > 0){
                tmp -= i + j;
                j++;
            }
            if(tmp == 0) answer ++;
        }
        return answer;
    }
}
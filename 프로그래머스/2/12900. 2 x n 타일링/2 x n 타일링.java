class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] tmp = new int[]{1, 2, 3};
        if(3 < n){
            for(int i = 4; i <= n; i++){
                tmp[0] = tmp[1];
                tmp[1] = tmp[2];
                tmp[2] = (tmp[0] + tmp[1]) % 1000000007;
            }
            answer = tmp[2];
        }else answer = tmp[n - 1];
        return answer;
    }
}
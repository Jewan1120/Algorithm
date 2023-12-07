class Solution {
    public long solution(int n) {
        long[] jump = {0, 1, 1};
        int i = 0;
        while(++i < n){
            jump[0] = jump[1] % 1234567;
            jump[1] = jump[2] % 1234567;
            jump[2] = jump[0] + jump[1];
        }
        return jump[2] % 1234567;
    }
}
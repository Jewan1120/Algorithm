class Solution {
    public String solution(int n) {
        StringBuilder sb = new StringBuilder();
        while(n > 0){
            int i = n % 3;
            if(i == 0){
                sb.insert(0, 4);
                n -=1;
            }else sb.insert(0, i);
            n /= 3;
        }
        return sb.toString();
    }
}
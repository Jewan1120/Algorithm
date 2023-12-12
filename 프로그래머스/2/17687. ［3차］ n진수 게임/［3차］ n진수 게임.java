class Solution {
    public String solution(int n, int t, int m, int p) {
        int num = 0;
        int turn = 0;
        int pointer = 0;
        StringBuilder sb = new StringBuilder();
        if(m == p) p = 0;
        while(sb.length() < t){
            String numStr = Integer.toString(num, n);
            if(++turn % m == p) sb.append(numStr.charAt(pointer));
            if(++pointer > numStr.length() - 1){
                pointer = 0;
                num++;
            }
        }
        return sb.toString().toUpperCase();
    }
}
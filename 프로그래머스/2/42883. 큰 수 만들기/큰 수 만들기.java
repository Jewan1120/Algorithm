class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        int count = 0;
        for(int i = 0; i < sb.length() -1;){
            if(sb.charAt(i) < sb.charAt(i + 1)){
                sb.deleteCharAt(i);
                count++;
                if(i > 0) i--;
                if(count == k) break;
            }else  i++;
        }
        if(count != k) sb.delete(sb.length() - (k - count), sb.length());
        return sb.toString();
    }
}
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s.toLowerCase());
        for(int i = 0; i < sb.length(); i++){
            if(i == 0 || (s.charAt(i) != ' ' && s.charAt(i - 1) == ' ')){
                sb.replace(i, i + 1, String.valueOf(sb.charAt(i)).toUpperCase());
            }
        }
        return sb.toString();
    }
}
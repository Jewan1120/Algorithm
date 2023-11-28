class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder(s.toLowerCase());
        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == ' ') {
                count = 0;
                continue;
            }
            if (count % 2 == 0) {
                sb.setCharAt(i, Character.toUpperCase(sb.charAt(i)));
            }
            count++;
        }
        return sb.toString();
    }
}
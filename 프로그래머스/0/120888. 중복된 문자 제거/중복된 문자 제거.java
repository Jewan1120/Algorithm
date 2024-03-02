class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < my_string.length(); i++) {
            if (sb.indexOf(String.valueOf(my_string.charAt(i))) == -1) {
                sb.append(my_string.charAt(i));
            }
        }
        return sb.toString();
    }
}
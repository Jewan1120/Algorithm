class Solution {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder(my_string.toLowerCase());
        for (int i = 0; i < sb.length() - 1; i++) {
            for (int j = 0; j < sb.length() - 1; j++) {
                if (sb.charAt(j) > sb.charAt(j + 1)) {
                    char tmp = sb.charAt(j);
                    sb.setCharAt(j, sb.charAt(j + 1));
                    sb.setCharAt(j + 1, tmp);
                }
            }
        }
        return sb.toString();
    }
}
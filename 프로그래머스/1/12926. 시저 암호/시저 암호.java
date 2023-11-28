class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char c = sb.charAt(i);
            if (c != ' ') {
                if (Character.isUpperCase(c)) {
                    if (c + n > 90) {
                        c = (char) (c + n - 26);
                    } else {
                        c += n;
                    }
                } else {
                    if (c + n > 122) {
                        c = (char) (c + n - 26);
                    } else {
                        c += n;
                    }
                }
            }
            sb.setCharAt(i, c);
        }
        return sb.toString();
    }
}
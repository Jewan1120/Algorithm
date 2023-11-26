class Solution {
    boolean solution(String s) {
        int p = 0;
        int y = 0;
        for (String part : s.toLowerCase().split("")) {
            if (part.equals("p")) {
                p++;
            } else if (part.equals("y")) {
                y++;
            }
        }
        return p == y ? true : false;
    }
}
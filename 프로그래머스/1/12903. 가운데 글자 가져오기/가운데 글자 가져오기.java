class Solution {
    public String solution(String s) {
        int center = s.length() / 2;
        return s.length() % 2 != 0 ? s.substring(center, center + 1) : s.substring(center - 1, center + 1);
    }
}
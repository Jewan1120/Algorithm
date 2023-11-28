class Solution {
    public boolean solution(String s) {
        return (s.length() == 4 || s.length() == 6) && s.length() == s.replaceAll("[A-z]", "").length() ? true : false ;
    }
}
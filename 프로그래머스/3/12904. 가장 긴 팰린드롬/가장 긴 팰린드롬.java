class Solution {
    public int solution(String s) {
        int answer = 0;
        for(int i = 0; i < s.length(); i++) {
            int odd = findPalindrome(s, i, i);
            int even = findPalindrome(s, i, i + 1);
            int palindrome = Math.max(odd, even);
            answer = Math.max(palindrome, answer);
        }
        return answer;
    }
    
    public int findPalindrome(String s, int l, int r) {
        while(0 <= l && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }
}
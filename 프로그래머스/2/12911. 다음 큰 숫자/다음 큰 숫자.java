class Solution {
    public int solution(int n) {
        int l = Integer.bitCount(n);
        while(l != Integer.bitCount(++n)){}
        return n;
    }
}
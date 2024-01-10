class Solution {
    public long solution(int w, int h) {
        return (long) w * h - (w + h - gcd(w, h));
    }
    public int gcd(int a, int b){
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }
}
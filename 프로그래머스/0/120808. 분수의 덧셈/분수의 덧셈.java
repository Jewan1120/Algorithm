class Solution {
    public int[] solution(int numer1, int denom1, int numer2, int denom2) {
        int lcm = 1;
        int divisor = 2;
        while (lcm % denom1 != 0 || lcm % denom2 != 0) {
            lcm++;
        }
        int numer3 = (numer1 * (lcm / denom1)) + (numer2 * (lcm / denom2));
        int denom3 = lcm;
        while (divisor <= lcm) {
            if (numer3 % divisor == 0 && denom3 % divisor == 0) {
                numer3 /= divisor;
                denom3 /= divisor;
            } else {
                divisor++;
            }
        }
        return new int[] {numer3, denom3};
    }
}
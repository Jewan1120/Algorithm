import java.math.BigInteger;
class Solution {
    public int solution(int n) {
        BigInteger a = new BigInteger("0");
        BigInteger b = new BigInteger("1");
        for(int i = 2; i <= n; i++){
            BigInteger c = b;
            b = b.add(a);
            a = c;
        }
        return Integer.parseInt(b.mod(new BigInteger("1234567")).toString());
    }
}
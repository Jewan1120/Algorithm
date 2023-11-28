import java.math.BigInteger;
class Solution {
    public String solution(String a, String b) {
        BigInteger bi1 = new BigInteger(a);
        BigInteger bi2 = new BigInteger(b);
        return bi1.add(bi2).toString();
    }
}
import java.math.BigInteger;
class Solution {
    public String addBinary(String a, String b) {
        BigInteger i1 = new BigInteger(a, 2);
        BigInteger i2 = new BigInteger(b, 2);
        return i1.add(i2).toString(2);
    }
}
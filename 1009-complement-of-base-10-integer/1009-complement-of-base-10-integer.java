class Solution {
    public int bitwiseComplement(int n) {
        StringBuilder result = new StringBuilder();
        String binaryString = Integer.toBinaryString(n);
        binaryString.chars().forEach(c -> result.append(c == '0' ? '1' : '0'));
        
        return Integer.parseInt(result.toString(), 2);
    }
}
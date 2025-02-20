class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int binaryLength = nums[0].length();
        int range = (int) Math.pow(2, binaryLength);
        int[] cell = new int[range];
        for (String num : nums) {
            int i = Integer.valueOf(num, 2);
            cell[i] = 1;
        }

        StringBuilder sb = new StringBuilder();
        sb.repeat("0", binaryLength);
        DecimalFormat decimalFormat = new DecimalFormat(sb.toString());

        String result = "";
        for (int i = 0; i < range; i++) {
            if (cell[i] == 0) {
                String binaryString = Integer.toBinaryString(i);
                int parsedBinaryString = Integer.parseInt(binaryString);
                result = decimalFormat.format(parsedBinaryString);
                break;
            }
        }

        return result;
    }
}
class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0;
        int twos = 0;
        int commonBitMask;

        for (int num : nums) {
            // Update 'twos' by adding common set bits
            twos |= (ones & num);

            // Update 'ones' by XORing with the new element
            ones ^= num;

            // Remove extra bits from both 'ones' and 'twos'
            commonBitMask = ~(ones & twos);
            ones &= commonBitMask;
            twos &= commonBitMask;
        }

        return ones;
    }
}
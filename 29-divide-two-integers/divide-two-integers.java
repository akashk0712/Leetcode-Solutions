class Solution {
    public int divide(int dividend, int divisor) {
    boolean sign = true;
    long dividendL = dividend;
    long divisorL = divisor;
    if (dividendL < 0) {
        sign = !sign;
        dividendL = -dividendL;
    }
    if (divisorL < 0) {
        sign = !sign;
        divisorL = -divisorL;
    }
    List<long[]> memo = new ArrayList<>(); // the size of the list is at most 32. So it is O(1) space.
    long sum = divisorL;
    long mult = 1;
    memo.add(new long[]{sum, mult});
    while ( sum + sum <= dividendL ) {
        sum += sum;
        mult += mult;
        long[] current = {sum, mult};
        memo.add(current);
    }
    long res = 0;
    for (int i = memo.size() - 1; i >= 0; i--) {
        if (dividendL - memo.get(i)[0] >= 0) {
            dividendL -= memo.get(i)[0];
            res += memo.get(i)[1];
        }
    }
    if (!sign) res = -res;
    if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
    else return (int) res;
}
}
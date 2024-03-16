class Solution {
    public int firstUniqChar(String s) {
        int min = Integer.MAX_VALUE;
        for(char ch : s.toCharArray()){
            int index = s.indexOf(ch);
            
            if(index != -1 && index == s.lastIndexOf(ch)){
                min = Math.min(min,index);
            }
        }
        if(min == Integer.MAX_VALUE) return -1;
        return min;
    }
}
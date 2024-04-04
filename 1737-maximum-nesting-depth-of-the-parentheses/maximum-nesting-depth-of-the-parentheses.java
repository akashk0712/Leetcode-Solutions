class Solution {
    public int maxDepth(String s) {
        int ans=0,k=0;
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='(')k++;
            else if(s.charAt(i)==')')k--;
            ans=Math.max(ans,k);
        }
        return ans;
    }
}
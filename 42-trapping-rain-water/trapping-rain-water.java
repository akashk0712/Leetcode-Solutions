class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] pref = new int[n];
        int[] suff = new int[n];
        for(int i=0;i<n;i++){
            pref[i] = height[i];
            if(i>0){
                pref[i] = Math.max(pref[i],pref[i-1]);
            }
        }
        for(int i=n-1;i>=0;i--){
            suff[i] = height[i];
            if(i+1<n){
                suff[i] = Math.max(suff[i],suff[i+1]);
            }
        }
        int ans = 0;
        for(int i=1;i<n-1;i++){
            ans += Math.max(0,Math.min(pref[i-1],suff[i+1])-height[i]);
        }
        return ans;
    }
}
class Solution {
    public int specialArray(int[] a) {
       int n = a.length , counter = 0;
        for(int i = 1 ; i <= n ; i++)
        {
            counter = 0;
            for(int j = 0 ; j < n ; j++)
                if(a[j] >= i)
                    counter++;
            if(counter == i)
                return i;
        }
        return -1; 
    }
}
class Solution {
    public String sortString(String s) {
        ArrayList<Integer> frq = new ArrayList<Integer>();
        for(int i=0;i<26;i++)
            frq.add(0);
        for(int i=0;i<s.length();i++)
            frq.set(s.charAt(i)-'a', frq.get(s.charAt(i)-'a')+1);
        int par = 0;
        StringBuilder ans = new StringBuilder();
        boolean can = false;
        do{
            can = false;
            StringBuilder ss = new StringBuilder();
            for(int i=0;i<26;i++)
                if(frq.get(i)>0){
                    ss.append((char)(i+'a'));
                    frq.set(i, frq.get(i)-1);
                    can |= (frq.get(i) > 0);
                }
            if(par == 1)
                ss.reverse();
            par ^= 1;
            ans.append(ss);
        } while(can == true);
        return ans.toString();
    }
}
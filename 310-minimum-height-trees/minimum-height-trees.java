class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n < 2) {
            ArrayList<Integer> res = new ArrayList<>();
            for (int i = 0; i < n; i++)
                res.add(i);
            return res;
        }
        
        Map<Integer, List<Integer>> adj = new HashMap();
        int[] deg = new int[n];
        List<Integer> res = new ArrayList();
        
        for(int[] edge: edges){
            if(!adj.containsKey(edge[1])){
                adj.put(edge[1], new ArrayList<Integer>());
            }
            
            if(!adj.containsKey(edge[0])){
                adj.put(edge[0], new ArrayList<Integer>());
            }
            
            adj.get(edge[1]).add(edge[0]);
            adj.get(edge[0]).add(edge[1]);
            deg[edge[0]]++;
            deg[edge[1]]++;
        }
        
        Queue<Integer> q = new LinkedList();
        
        for(int i=0; i<n ; i++){
            if(deg[i] == 1) q.add(i);
        }
        
        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList();
            int sz = q.size();
            
            while(sz-- > 0){
                int u = q.remove();
                temp.add(u);
                
                for(int v: adj.get(u)){
                    if(--deg[v] == 1) q.add(v);
                }
            }
            
            res = temp;
        }
        
        return res;
    }
}
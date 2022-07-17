class Solution {
    /**
   * Time O(V^2)
   *  - we need to visit all vertices and each vertex visits 1 less vertex than the previous vertex.
   *    Which is (V - 1) + (V - 2) + ... + 1 + 0 = V! = ((V - 1) + 0)*V / 2 = O(V^2)
   * Space O(V)     
   */
    /**
   * Time O(V^2 + E)
   * Space O(V^2)
   */
    public boolean validPath(int n, int[][] edges, int src, int des) {
        if(src==des)
            return true;
        ArrayList<Integer>[] graph=new ArrayList[n];
    for(int i =0 ;i<n;i++){
    graph[i] = new ArrayList<>();
     }

    for(int [] edge : edges){
        graph[edge[0]].add(edge[1]);
        graph[edge[1]].add(edge[0]);
    }
       // return dfs(src,des,graph,new boolean[n]);
        Queue<Integer>q= new LinkedList<>();
        boolean[] vis=new boolean[n];
        q.add(src);
        vis[src]=true;
        
        while(!q.isEmpty()){
            int top=q.poll();
            if(top==des){
                return true;
            }
            
            for(int ele:graph[top]){
                if(!vis[ele]){
                    q.add(ele);
                    vis[ele]=true;
                }
            }
        }
        
        return false;
        
    }
    public boolean dfs(int src,int dst,ArrayList<Integer> graph[],boolean[] vis){
        if(src==dst)
            return true;
        if(vis[src]==true)
            return false;
        vis[src]=true;
        for(int nbr:graph[src]){
            if(vis[nbr]==false){
                boolean hasPath=dfs(nbr,dst,graph,vis);
                if(hasPath==true)
                    return true;
            }
        }
        return false;
    }
}
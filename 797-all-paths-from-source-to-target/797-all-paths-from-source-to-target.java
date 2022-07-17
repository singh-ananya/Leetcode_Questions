class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
       List<List<Integer>> res=new ArrayList<>();
        boolean vis[]=new boolean[graph.length];
        dfs(graph,0,res,new ArrayList<>(),vis);
        return res;
    }
    public void dfs(int[][] graph,int src,List<List<Integer>> res,List<Integer> path,boolean vis[]){
        path.add(src);
        if(src==graph.length-1){
            res.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return;
        }
        vis[src]=true;
        for(int nbr:graph[src]){
            if(!vis[nbr])
                dfs(graph,nbr,res,path,vis);
        }
        vis[src]=false;
        path.remove(path.size()-1);
    }
}
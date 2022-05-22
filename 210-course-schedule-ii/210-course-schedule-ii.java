class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> graph,int vis[],int src,ArrayList<Integer> ans){
        vis[src]=1;
        for(int nbr:graph.get(src)){
            if(vis[nbr]==0){
               boolean cycle=dfs(graph,vis,nbr,ans);
                if(cycle)
                    return true;
            }else if(vis[nbr]==1)
                return true;
        }
        vis[src]=2;
        ans.add(src);
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int e[]:prerequisites){
            int a=e[0];
            int b=e[1];
            graph.get(b).add(a);
            
        }
        int vis[]=new int[numCourses];
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            if(vis[i]==0){
                boolean check=dfs(graph,vis,i,ans);
                if(check==true){
                    return new int[]{};
                }
            }
        }
        // for(int i=0;i<vis.length;i++){
        //     if(vis[i]==2)
        //         ans.add(i);
        // }
        int []res=new int[ans.size()];
        //int idx=0;
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(ans.size()-i-1);
        }
        return res;
    }
}